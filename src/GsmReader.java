import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;

/*skup sie na czytaniu. o reszte nie dbaj
ewentualnie jakies parsowanie tekstu tutaj żeby go można było odczytać
 */
public class GsmReader extends Thread {

    //byte[] rawBuffer = new byte[32];  jednak inicjowanie w pętli jest dogodniejsze, bo odczytamy tyle ile jest dostępne
    SerialPort serial;
    char[] processedBuffer;
    Stack stos;


    @Override
    public void run() {
        while(true)
        {
            try {
                if (serial.bytesAvailable() == 0) {
                    Thread.sleep(20);
                } else {
                    byte[] rawBuffer = new byte[serial.bytesAvailable()];
                    int readBytes = serial.readBytes(rawBuffer, rawBuffer.length);//w sumie tyle, jest w buforze
                    System.out.println("readed "+ readBytes+" bytes");
                    System.out.println(Arrays.toString(rawBuffer));
//                  tutaj czeba cos reagować
                    //obrobic dane a wtedy wrzucic na stos
                    //char[] output = bytesToChar(rawBuffer);
                    String s = rawBuffToString(rawBuffer);
                    System.out.println(String.valueOf(s));
                    stos.add(s);  //bedzie dodawać coś za każdym odczytem, potem sie tym zajmie executor
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public GsmReader(SerialPort serial, Stack stos) {
        this.serial = serial;
        this.stos = stos;
    }

    private char[] bytesToChar(byte[] toProceed)    //jednak metoda poniżej robi tą robote i więcej
    {
        //todo
        char[] solution = new char[toProceed.length];
        for (int i = 0; i < toProceed.length; i++) {
            solution[i] = (char) toProceed[i];
        }
        return solution;
    }
    private static String rawBuffToString(byte[] readBuffer)
    {
        char[] wynik = new char[readBuffer.length];
        for(int i=0; i<readBuffer.length;i++)
        {
            wynik[i] = (char)readBuffer[i];
        }
        String s = String.valueOf(wynik);
        return s;
    }
}
