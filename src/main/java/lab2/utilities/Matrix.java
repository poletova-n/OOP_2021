package lab2.utilities;

import lab2.exceptions.DividedByZero;
import lab2.exceptions.FileNotFound;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Matrix {

    private final double [][] matrix;

    public Matrix(int size) {

        matrix = new double[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = (double) Math.floor(Math.random()* (2*size + 1) - size);
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

    public void divideByNeighbours(){

        int neighboursSum = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){

                if (j + 1 <= matrix.length - 1){
                    neighboursSum += matrix[i][j + 1];
                }

                if (j - 1 >= 0){
                    neighboursSum += matrix[i][j - 1];
                }

                if (i + 1 <= matrix.length - 1){
                    neighboursSum += matrix[i + 1][j];
                }

                if (i - 1 >= 0){
                    neighboursSum += matrix[i - 1][j];
                }

                try {

                    if (neighboursSum == 0){
                        throw new DividedByZero("Division by 0 in element [" + i + "][" + j + "] occurred!");
                    }

                    matrix[i][j] = Math.round((matrix[i][j] / neighboursSum) * 100.0) / 100.0;

                }catch (DividedByZero exception){
                    matrix[i][j] = Double.POSITIVE_INFINITY;
                    exception.printStackTrace();
                }

                neighboursSum = 0;

            }
        }
    }

    public void printMatrixToFile(String filePath){

        int matrixDegrees = 90;

        try {
            File outputFile = new File(filePath);

            if (!outputFile.exists()){
                throw new FileNotFound("Output file not found!");
            }

        }catch (FileNotFound exception){
            exception.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)){

            StringBuilder stringBuilder = new StringBuilder();

            for (int k = 0; k < 3; k++) {

                stringBuilder.append("Matrix ").append(matrixDegrees).append(" degrees:\n\n");

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        stringBuilder.append(matrix[i][j]).append("\t\t");
                    }
                    stringBuilder.append("\n\n\n");
                }

                stringBuilder.append("\n\n======================================================================\n\n\n\n");

                divideByNeighbours();
                rotateMatrix();
                matrixDegrees += 90;

            }

            writer.write(stringBuilder.toString());

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                stringBuilder.append(matrix[i][j]).append("\t\t");
            }
            stringBuilder.append("\n\n\n");
        }

        return stringBuilder.toString();

    }

}
