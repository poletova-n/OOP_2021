package lab2;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix("./src/main/java/lab2/files/dim.txt");

        for (int x = 0; x < 3; x++) {
            m.rotate();
            m.divideEachElement();

            m.writeToFile("./src/main/java/lab2/files/matrix.txt");
        }

    }
}
