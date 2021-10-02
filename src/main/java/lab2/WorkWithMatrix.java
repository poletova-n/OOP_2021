package lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WorkWithMatrix {
    private int m,n,i,j;
    private int[][] matrix;
    private Scanner scanner = new Scanner("MatrixOut");

    WorkWithMatrix(int N){
        m = N;
        n = N;
        matrix = new int[N][N];
        for (int i = 0; i<N;i++){
            for (int j = 0; j<N; j++){
                matrix[i][j] = (int)(Math.random()*(N + N)+1)-N;
            }
        }
    }

    WorkWithMatrix(int[][] matrix){
        for (int i = 0; i<m;i++){
            for (int j = 0; j<m; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public int[][] turn90(){
        int [][] matrixA = new int[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = matrix[j][m-i-1];
            }
        }
        return matrixA;
    }

    public int[][] turn180(){
        int [][] matrixA = new int[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = matrix[m-i-1][m-j-1];
            }
        }
        return matrixA;
    }

    public int[][] turn270(){
        int [][] matrixA = new int[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; i < n; j++) {
                matrixA[i][j] = matrix[m-j-1][i];
            }
        }
        return matrixA;
    }

    public void div(){
        int [][] matrixA = new int[m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; i < n; j++) {
                matrixA[i][j] = matrix[i][j];
            }
        }
        try {
            if (m > 1 && n > 1) {
                if ((matrixA[0][1] + matrixA[1][0]) == 0 || (matrixA[0][m - 1] + matrixA[1][m]) == 0
                        || (matrixA[m - 1][0] + matrixA[m][1]) == 0 || (matrixA[m][m - 1] + matrixA[m - 1][m]) == 0) {
                    throw new DivideByZero("You cannot divide an element by zero", 1);
                }
                matrix[0][0] /= (matrixA[0][1] + matrixA[1][0]);
                matrix[0][m] /= (matrixA[0][m - 1] + matrixA[1][m]);
                matrix[m][0] /= (matrixA[m - 1][0] + matrixA[m][1]);
                matrix[m][m] /= (matrixA[m][m - 1] + matrixA[m - 1][m]);
                for (i = 1; i < m - 1; i++) {
                    if ((matrixA[0][i - 1] + matrixA[1][i] + matrixA[0][i + 1]) == 0
                            || (matrixA[m][i - 1] + matrixA[m - 1][i] + matrixA[m][i + 1]) == 0
                            || (matrixA[i - 1][0] + matrixA[i][1] + matrixA[i + 1][0]) == 0
                            || (matrixA[i - 1][m] + matrixA[i][m - 1] + matrixA[i + 1][m]) == 0) {
                        throw new DivideByZero("You cannot divide an element by zero", 1);
                    }
                    matrix[0][i] /= (matrixA[0][i - 1] + matrixA[1][i] + matrixA[0][i + 1]);
                    matrix[m][i] /= (matrixA[m][i - 1] + matrixA[m - 1][i] + matrixA[m][i + 1]);
                    matrix[i][0] /= (matrixA[i - 1][0] + matrixA[i][1] + matrixA[i + 1][0]);
                    matrix[i][m] /= (matrixA[i - 1][m] + matrixA[i][m - 1] + matrixA[i + 1][m]);
                }
                for (i = 1; i < m - 1; i++) {
                    if ((matrixA[i][i - 1] + matrixA[i - 1][i] + matrixA[i][i + 1] + matrixA[i + 1][i]) == 0) {
                        throw new DivideByZero("You cannot divide an element by zero", 1);
                    }
                    matrix[i][i] /= (matrixA[i][i - 1] + matrixA[i - 1][i] + matrixA[i][i + 1] + matrixA[i + 1][i]);
                }
            }
        }catch (DivideByZero e){
            System.out.print(e.getMessage());
            System.out.print(e.getNumber());
            matrix[i][j] = (int)Double.POSITIVE_INFINITY;
        }catch (ArithmeticException e){
            System.out.print(e.getMessage());
        }
    }

    public void Print(){
        for (int i = 0; i< m; i++){
            for (int j = 0; j < m; i++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void OutOfFile(FileWriter file){
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    file.write(matrix[i][j]);
                }
                file.write("\n");
                //file.flush();
            }
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }
}
