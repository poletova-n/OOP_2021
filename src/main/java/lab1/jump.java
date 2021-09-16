package lab1;

public class Jump implements Activity
{
    public void move(Plase now,Plase future)
    {
        if (now.comparePlase(future))
        {
            System.out.println("You're already here!");
        }
        else if (now.getZ()-future.getZ()>1 || future.getZ()-now.getZ()>1 )
        {
            System.out.println("You can't jump that high");
        }
        else
        {
            System.out.println("You have moved to a new place !");
            now.setPlase(future);
        }
    }
}
