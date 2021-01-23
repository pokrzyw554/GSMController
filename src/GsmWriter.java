import com.fazecast.jSerialComm.SerialPort;

public class GsmWriter {

    SerialPort port;
    public GsmWriter(SerialPort port) {
        this.port = port;
    }
    public void customWrite(String string)
    {
        char[] processed = toCharArray(string);
        byte[] ready = toByteArray(processed);
        port.writeBytes(ready, charSizeofString(string));
    }

    private long charSizeofString(String string)
    {
        //todo ma namliczycz rozmiar stringa
        char[] chars = string.toCharArray();
        return chars.length;
    }

    char[] toCharArray(String wiadomosc)
    {
        //ma zamieniac stringa na tablice charow
        char[] tablica;
        tablica = wiadomosc.toCharArray();
        return tablica;
    }
    byte[] toByteArray(char[] tablica)
    {
        byte[] table = new byte[tablica.length];
        for (int i = 0; i < tablica.length; i++)
        {
            table[i] = (byte) tablica[i];
        }
         //done?
        return table;
    }
}
