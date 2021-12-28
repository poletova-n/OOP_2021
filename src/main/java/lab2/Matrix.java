package Lab2;
import Lab2.exceptions.DivisionByZeroException;
import Lab2.exceptions.OverflowException;

public class Matrix {
    private int[][] matrix;

    public Matrix(int size) {
        if (size > 1_000_000)
            throw new OverflowException("The size of the matrix can not be more than 1 000 000");
        matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void dividingElementsOfMatrix () {
        int[][] temp = getMatrix();
        for (int i = 0; i < temp.length; ++i) {
            for (int j = 0; j < temp.length; ++j) {
                int sum = 0;
                if (i != 0) sum += matrix[i - 1][j];
                if (i != temp.length - 1) sum += matrix[i + 1][j];
                if (j != 0) sum += matrix[i][j - 1];
                if (j != temp.length - 1) sum += matrix[i][j + 1];
                if (sum == 0) throw new DivisionByZeroException("You can't divide it by zero!");
                temp[i][j] /= sum;
            }
        }
        matrix = temp;
    }

    public void rotateNinetyDegree() {
        int[][] copyMatrix = getMatrix();
        for (int i = 0; i < copyMatrix.length / 2; i++) {
            int bottom = copyMatrix.length - 1 - i;
            for (int j = i; j < bottom; j++) {
                int temp = copyMatrix[i][j];
                copyMatrix[i][j] = copyMatrix[j][bottom];
                copyMatrix[j][bottom] = copyMatrix[bottom][bottom - (j - i)];
                copyMatrix[bottom][bottom - (j - i)] = copyMatrix[bottom - (j - i)][i];
                copyMatrix[bottom - (j - i)][i] = temp;
            }
        }
    }

    public void rotateTwoHundredSeventyDegree () {
        rotateNinetyDegree();
    }

    public void rotateOneHundredEightyDegree () {
        rotateNinetyDegree();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                str.append(ints[j]).append(" ");
            }
            str.append('\n');
        }
        return str.toString();
    }

    public void fillMatrix() {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = (int) Math.round((Math.random() * matrix.length * 2) - matrix.length);
            }
        }
    }
}
