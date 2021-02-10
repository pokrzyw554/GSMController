public class Stack {
    String[] stosik;
    int top;

    public void add(String payload)
    {
        //jakies sprawdzenie czy stos nie jest przepelniony?
        stosik[top] = payload;
        top++;
        System.out.println("stosik ma obecnie "+top+" pozycji");
    }
    public String take()
    {
        if(isStackEmpty())
        {
            return null;
        }else {
            String tmp = stosik[top-1];
            top--;
            return tmp;
        }
    }

    public Stack()
    {
        top=0;
        stosik = new String[10];    //randomowa wartość która powinna starczyć
    }
    public boolean isStackEmpty()
    {
        return top==0;
    }
}
