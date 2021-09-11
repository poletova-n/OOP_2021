package lab2;

import lab2.exceptions.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Matrix {

    private final double [][]  matrix;

    public Matrix(String pathToFile)
    {
        int x;
        int tempSize = 0;

        try(FileInputStream fileInputStream = new FileInputStream( pathToFile)){

            StringBuilder sb = new StringBuilder();

            while ((x = fileInputStream.read()) != -1){
                sb.append((char) x);
            }
            fileInputStream.close();

            tempSize = Integer.parseInt(sb.toString());

            if(tempSize > 1000000 | tempSize <= 0){
                throw new WrongMatrixSize("Inadmissible matrix size!");
            }

            if (sb.isEmpty()){
                throw new EmptyFile("File is empty!");
            }
        } catch ( IOException | NumberFormatException | EmptyFile | WrongMatrixSize exception) {
            exception.printStackTrace();
        }
        matrix = new double[tempSize][tempSize];
        for (int i = 0; i < tempSize; i++) {
            for (int j = 0; j < tempSize; j++) {
                matrix[i][j] = Math.floor(Math.random() * (2 * tempSize + 1) - tempSize);
            }
        }
    }

    public void rotateMatrix()
    {
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < matrix.length - x - 1; y++) {

                double temp = matrix[x][y];

                // Move values from right to top
                matrix[x][y] = matrix[y][matrix.length - 1 - x];

                // Move values from bottom to right
                matrix[y][matrix.length - 1 - x] = matrix[matrix.length - 1 - x][matrix.length - 1 - y];

                // Move values from left to bottom
                matrix[matrix.length - 1 - x][matrix.length - 1 - y] = matrix[matrix.length - 1 - y][x];

                // Assign temp to left
                matrix[matrix.length - 1 - y][x] = temp;

            }
        }
    }

    public void divideMatrix(){
        int sumOfNeighbours = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if(i - 1 >= 0){
                    sumOfNeighbours += matrix[i - 1][j];
                }
                if(j + 1 <= matrix.length - 1){
                    sumOfNeighbours += matrix[i][j + 1];
                }
                if(i + 1 <= matrix.length - 1){
                    sumOfNeighbours += matrix[i + 1][j];
                }
                if(j - 1 >= 0){
                    sumOfNeighbours += matrix[i][j - 1];
                }

                try {
                    if (sumOfNeighbours == 0){
                        throw new DividedByZero("Division by 0 occurred!");
                    }

                    matrix[i][j] = Math.round((matrix[i][j] / sumOfNeighbours) * 100.0) / 100.0;
                }catch (DividedByZero exception){
                    matrix[i][j] = Double.POSITIVE_INFINITY;
                    exception.printStackTrace();
                }

                sumOfNeighbours = 0;
            }

        }
    }


    public void printMatrixToFile(String pathToFile){

        int degreeOfRotation = 90;

        try(FileOutputStream fileOutputStream = new FileOutputStream(pathToFile)){

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                sb.append("Matrix ").append(degreeOfRotation).append(" degrees:\n\n");
                for (double[] doubles : matrix) {
                    for (int k = 0; k < matrix.length; k++) {
                        sb.append(doubles[k]).append("\t\t");
                    }
                    sb.append("\n\n\n");
                }
                sb.append("---------------------------------------------------------\n\n\n\n");

                divideMatrix();
                rotateMatrix();
                degreeOfRotation += 90;
            }

            fileOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(doubles[j]).append("\t\t\t");
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }
}
