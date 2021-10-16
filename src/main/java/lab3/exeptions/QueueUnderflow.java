package lab3.exeptions;

public class QueueUnderflow extends Exception
{
    public QueueUnderflow(String message)
    {
        super(message);
    }
}