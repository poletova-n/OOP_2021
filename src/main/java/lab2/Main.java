package lab2;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix("./src/main/java/lab2/input.txt");

        for (int x = 0; x < 3; x++) {
            m.rotate();
            m.divideSumNeighbors();
            m.writeToFile("./src/main/java/lab2/matrix.txt");
        }

    }
}