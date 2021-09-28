package lab2;

import java.io.*;
import java.util.Scanner;

public class Matrix
{
    private int size;
    private double[][] matrix;

    public Matrix(String file)
    {
        readSize(file);
        matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.round((Math.random() * (size * 2)) - size);
            }
        }
    }

    private void readSize(String file) {
        try
        {
            File input = new File(file);

            if (!input.exists())
            {
                throw new UnableToOpenFile("Input file not found!");
            }
        }
        catch (UnableToOpenFile ex)
        {
            ex.printStackTrace();
        }
        try(Scanner getSize = new Scanner(new File(file))) {
            size = getSize.nextInt();
            if(size > 1_000_000)
            {
                throw new SizeIsTooLarge("File size is greater than 1000000!");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void rotate()
    {
        double[][] tempMatrix = new double[size][size];

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                tempMatrix[i][j] = matrix[j][size - i - 1];
            }
        }

        matrix = tempMatrix;
    }

    public void subtractAndDivide(){
        double divider;
        int i,j;
        double[][] tempMatrix = new double[size][size];
        for(i = 0; i < size; i++) {
            for(j = 0; j < size; j++) {
                try {
                    if (j == size - 1) {
                        if (i == size - 1) {
                            divider = matrix[i - 1][j] + matrix[i][j - 1];
                        } else {
                            divider = matrix[i + 1][j] + matrix[i][j - 1];
                        }
                    } else {
                        if (i == size - 1) {
                            divider = matrix[i - 1][j] + matrix[i][j + 1];
                        } else {
                            divider = matrix[i + 1][j] + matrix[i][j + 1];
                        }
                    }
                    if (divider == 0) {
                        throw new DivisionByZero("Unable to divide by zero! Element will be replaced with infinity");
                    }
                    tempMatrix[i][j] = Math.round(matrix[i][j] / divider);
                }
                catch(DivisionByZero ex)
                {
                    matrix[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        matrix = tempMatrix;
    }

    public void printMatrix(String file) {
        try
        {
            File output = new File(file);

            if (!output.exists())
            {
                throw new UnableToOpenFile("Output file not found!");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)))
        {
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    writer.append(String.valueOf(matrix[i][j]));
                    writer.append(" ");
                }

                writer.append('\n');
            }

            writer.append('\n');
            writer.flush();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while writing to file");
            e.printStackTrace();
        }
    }
}
