package lab2;

public class Main {
    public static void main(String[] args) {
        Matrix newMatrix = new Matrix("src/main/java/lab2/input.txt");
        newMatrix.fillRandom();
        for (int i = 0; i < 3; i++) {
            newMatrix.rotateAndDivide();
            newMatrix.printMatrix("src/main/java/lab2/output.txt");
        }
    }
}
