

public class ANSII_CODES {
    static public String GREEN = "";
    static public String RED = "";
    static public String BLUE = "";
    static public String RESET = "";

    static String buildRED(String str){
        return RED + str + RESET;
    }
    static String buildGREEN(String str){
        return GREEN + str + RESET;
    }
    static String buildBLUE(String str){
        return BLUE + str + RESET;
    }
}
