package lab2;

import lab2.exceptions.DivisionByZeroException;
import lab2.exceptions.MyFileNotFoundException;
import lab2.exceptions.NGreateThanMillionException;

import java.io.*;

public class Matrix {

    private int N;
    private double[][] m;

    public Matrix(String fileName)
    {
        readDimensionality(fileName);
        fillMatrix();
    }


    private void readDimensionality(String fileName) {


        try {
            File tempFile = new File(fileName);
            if (!tempFile.exists()) {
                throw new MyFileNotFoundException("No such file!");
            }
        } catch (MyFileNotFoundException e) {
            e.printStackTrace();
        }


        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            N = Integer.parseInt(br.readLine());

            if (N > 1_000_000)
            {
                throw new NGreateThanMillionException("N is greater than one million");
            }

        } catch (NumberFormatException | NGreateThanMillionException | IOException e) {
            e.printStackTrace();
        }

    }

    private void fillMatrix() {
        m = new double[N][N];

        try {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double rand = Math.round((Math.random() * (N  * 2)) - N);

                    m[i][j] =  rand;
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }


    }

    public void rotate() {
        double[][] mRotated = new double[N][N];

        try {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mRotated[i][j] = m[j][N - i - 1];
                }
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        m = mRotated;
    }



    private double sumOfNeighbours(int i, int j) {
        double sum = 0;

        int[][] idxs = {{-1,1},{0, 1},{1,1}, {-1,0},{1,0}, {-1,-1},{0, -1},{1,-1}};

        for (int k = 0; k < 8; k++) {
            if (i + idxs[k][0] >= 0 && i + idxs[k][0] < N
                    && j + idxs[k][1] >= 0 && j + idxs[k][1] < N) {
                sum += m[i + idxs[k][0]] [j + idxs[k][1]];
            }
        }

        return sum;

    }

    public void divideEachElement() {
        double[][] mDiveded = new double[N][N];

        try {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double sum =  sumOfNeighbours(i,j);

                    if (sum == 0) {
                        throw new DivisionByZeroException("Division by zero occurred");
                    }
                    mDiveded[i][j] = m[i][j] / sum;
                }
            }
        } catch (OutOfMemoryError | ArithmeticException e) {
            e.printStackTrace();
        }
        m = mDiveded;

    }

    public void writeToFile(String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    writer.append(String.format("%.6f", m[i][j]));
                    writer.append(" ");
                }
                writer.append('\n');
            }
            writer.append('\n');
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
