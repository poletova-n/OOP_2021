package lab1;

import java.io.InputStream;
import java.util.Scanner;

public class Trip {
    public static void main(String[] args){
        Hero myHero=new Hero();

        Scanner in = new Scanner(System.in);

        System.out.println("What do you watn to do?" +
                "1-walk , 2-run ,3-swim ,4-jump , 5-fly 6- to end");
        int comand =in.nextInt();
        while(comand!=6)
        {
            System.out.print("Where o you want to go?");
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int z2 = in.nextInt();
            Plase finish=new Plase(x2,y2,z2);

            if(comand==1)
            {
                myHero.setActivity(new Walk());
                myHero.executeActivity(finish);
            }
            else  if(comand==2)
            {
                myHero.setActivity(new Run());
                myHero.executeActivity(finish);
            }
            else  if(comand==3)
            {
                myHero.setActivity(new Swim());
                myHero.executeActivity(finish);
            }
            else  if(comand==4)
            {
                myHero.setActivity(new Jump());
                myHero.executeActivity(finish);
            }
            else  if(comand==5)
            {
                myHero.setActivity( new Fly());
                myHero.executeActivity(finish);
            }
            System.out.println("What do you watn to do now?" +
                    "1-walk , 2-run ,3-swim ,4-jump , 5-fly ,6- to end");
            comand =in.nextInt();
        }
        in.close();
        System.out.println("The end of trip on");
        myHero.getStart().tellAbout();
    }

}
