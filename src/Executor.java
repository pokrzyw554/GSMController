import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
klasa będzie sie zajmować odczytywaniem i ściąganiem ze stosu odebranych danych/komend
oraz adekwatne wykonywanie ich lub reagowanie na nie
 */
public class Executor extends Thread{

    Stack stos_reference;
    String  odczytane;
    boolean mutex = false;
    Matcher matcher;
    public Executor(Stack stos_pointer)
    {
        stos_reference = stos_pointer;
    }

    Pattern incomingSMS = Pattern.compile("AT\\+CMGR=\\d{1,}"); //regex for checking if messege appear
    //Matcher matcher = incomingSMS.matcher()

    public void run()
    {
            while (true)
            {
                try
                {
                    if(stos_reference.isStackEmpty()) {
                        Thread.sleep(5000);
                        System.out.println("idle");
                    }else {
                        odczytane = stos_reference.take();
                        matcher = incomingSMS.matcher(odczytane);
                        if(matcher.find())
                        {
                            newMessege();

                        }else {
                            switch (odczytane) {
                                //this section is for debuging test device
                                case "Blue":
                                    System.out.println("a teraz niebieska");
                                    break;
                                case "Green":
                                    System.out.println("odczytano zielona");
                                    break;
                                //end of debuging section
                                case "RING":
                                    incommingCall();
                                default:
                                    System.out.println("takie coś odczytałem " + odczytane);
                                    break;
                            }
                        }
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
    }

    private void newMessege() {
        //todo
    }

    private void incommingCall() {
        //todo
    }

}
