import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello world\n");
        SerialPort[] porty = SerialPort.getCommPorts();
        SerialPort port = porty[2];     //todo zrób to profesjonalniejsze
        System.out.println(Arrays.toString(porty));
        GSM GSM = new GSM(port);
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        System.out.println(userInput);
        GSM.customWrite(userInput);         //testing purpose
        GSM.customWrite("zielona");
        Thread.sleep(2000);
    }
}
