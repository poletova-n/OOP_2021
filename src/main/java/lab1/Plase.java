package lab1;

public class Plase
{
    private int x;
    private int y;
    private int z;

    public Plase()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Plase(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean comparePlase(Plase forCopmp)
    {
        if (this.x == forCopmp.x && this.y == forCopmp.y && this.z == forCopmp.z)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setPlase(Plase plase)
    {
        this.x = plase.x;
        this.y = plase.y;
        this.z = plase.z;
    }

    public int getZ()
    {
        return z;
    }

    public void tellAbout()
    {
        System.out.print(this.x);
        System.out.print(" , ");
        System.out.print(this.y);
        System.out.print(" , ");
        System.out.print(this.z);
        System.out.print(" .");
    }
}
