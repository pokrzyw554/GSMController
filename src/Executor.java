

/*
klasa będzie sie zajmować odczytywaniem i ściąganiem ze stosu odebranych danych/komend
oraz adekwatne wykonywanie ich lub reagowanie na nie
 */
public class Executor extends Thread{

    Stack stos_reference;
    String  odczytane;
    boolean mutex = false;
    public Executor(Stack stos_pointer)
    {
        stos_reference = stos_pointer;
    }


    public void run()
    {
            while (true)
            {
                try
                {
                    if(stos_reference.isStackEmpty()) {
                        Thread.sleep(1000);
                    }
                    odczytane = stos_reference.take();
                    switch (odczytane)
                    {

                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
    }

}
