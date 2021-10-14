package lab2;

public class Main {

    public static final String  INPUT_FILE = "C:/Users/Tortila/Java2021_2022/OOP_2021/src/main/java/lab2/input.txt";
    public static final String  OUTPUT_FILE = "C:/Users/Tortila/Java2021_2022/OOP_2021/src/main/java/lab2/output.txt";


    public static void main(String[] args) {
           Matrix matrix = new Matrix(INPUT_FILE);

           matrix.printMatrixToFile(OUTPUT_FILE);
    }


}



