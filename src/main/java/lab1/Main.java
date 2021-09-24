package lab1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String keyWord = "y";
        Hero chr = new Hero("WALK");
        while(keyWord.equals("y")){
            System.out.println("Choose activity type [Walk/Run/Fly/Horse]: ");
            Scanner in = new Scanner(System.in);
            String activityIn = in.next();
            chr.activityType(activityIn);
            System.out.println("Enter coordinate X: ");
            int x_ = in.nextInt();
            System.out.println("Enter coordinate Y: ");
            int y_ = in.nextInt();
            chr.moveToDestination(new Point(x_,y_));
            System.out.println("Continue the program? [y/n]:");
            keyWord = in.next();
        }
    }
}
