package lab7;

import java.util.Random;

public class Utils {
     static Random random = new Random();
    public static int parseIntFromArgs(String arg) {
        int N = 0;
        try {
            N = Integer.parseInt(arg);
        }
        catch (NumberFormatException e){
            System.err.println(e.getMessage() + " N = 0 default");
        }
        return N;
    }
    public static String getRandomString() {
        return "Hello "
                + (random.nextInt() % 500 + 500);
    }
}
