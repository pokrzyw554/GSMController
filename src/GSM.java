import com.fazecast.jSerialComm.SerialPort;
/*
do tej klasy ma miec dostep kontroler Springa
klasa powinna być ściśle powiązana z GSM controller, GSM Reader
powinna mieć dostęp do SQL writera lub handlera
*/
public class GSM {
    boolean isPinLocked;
    boolean isSIMinside;
    boolean isPowerOn;
    String lastMessage;
    int messegesInModule;
    SerialPort port; //potrzebne? tak! do konstrukcji innych modułów
    GsmReader reader;
    GsmWriter writer;
    Stack stos;

    //todo konstruktor  //done
    GSM(SerialPort port)
    {
        this.port = port;
        this.stos = new Stack();
        this.reader = new GsmReader(this.port, this.stos);
        this.writer = new GsmWriter(this.port);
        init();
    }

    private void init() {
        port.setBaudRate(115200);
        port.openPort();
        Thread odczyt = new Thread(reader);
        odczyt.start();
        //reader.start();
        try {
            Thread.sleep(20);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isOK()
    {
        return true;
    }
    public void SendSMS(String receiver, String content)
    {
        //jakis sanitize przed wyslaniem
    }

    public void providePin(int Pin)
    {
        //AT+CPIN 86str
    }

    public String getLastMessage() //docelowo ma być prywatna
    {
        return lastMessage;
    }

    public void customWrite(String command)
    {
        writer.customWrite(command+'\n');
    }

    private void checkPIN()
    {
        //AT+CPIN 86str
    }
}
