package com.example.lab1;

public class Hero {
    Activity activity;

    public void setActivity(Activity activity)
    {
        this.activity=activity;
    }
    public void executeActivity(Plase plase,Plase plase2)
    {
        activity.move(plase, plase2) ;
    }
}
