package lab1;

public class Hero {
    Activity activity;
    Plase start=new Plase();

    public void setActivity(Activity activity)
    {
        this.activity=activity;
    }
    public void executeActivity( Plase plase2)
    {
        activity.move(this.start, plase2) ;
    }
    public Plase getStart(){return this.start;}
}
