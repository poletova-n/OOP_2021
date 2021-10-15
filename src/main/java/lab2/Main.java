package lab2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //file existing test (input)
        try {
            File file = new File("C:\\Users\\Enipok\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\in.txt");
            if (!file.exists()) {
                throw new FileDontExistException("File " + file + " don't exist!");
            }
        }
        catch (FileDontExistException ex) {
            System.out.print("FileDontExistException!!! ");
            System.out.println(ex.getMessage());
            return;
        }

        //main part
        try (Scanner in = new Scanner(new File ("C:\\Users\\Enipok\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\in.txt"))) {
            if (!in.hasNext()) {
                throw new IOException("File is empty!");
            }
            if (!in.hasNextInt()) {
                throw new IOException("Invalid data type in the file (an integer was expected)!");
            }
            int size;
            size = in.nextInt();
            if (size > 1000000) {
                throw new LargeMatrixSizeException("The matrix size is too large (expected size <= 1000000)");
            }
            in.close();

            //Creating the matrices used in the work
            Matrices test = new Matrices(size);
            test.fillMatrix();
            Matrices test90 = test.getRotatedMatrix();
            Matrices test180 = test90.getRotatedMatrix();
            Matrices test270 = test180.getRotatedMatrix();

            //Test output of the resulting matrices to the screen
            test.printMatrix();
            test90.printMatrix();
            test180.printMatrix();
            test270.printMatrix();

            //Each element is replaced by dividing it by the sum of two neighboring elements
            test90.modifyValues();
            test180.modifyValues();
            test270.modifyValues();

            StringBuilder fileMatrices = new StringBuilder();

            //file existing test (output)
            File file = new File ("C:\\Users\\Enipok\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\out.txt");
            if (!file.exists()) {
                throw new FileDontExistException("File " + file + " don't exist!");
            }

            FileWriter out = new FileWriter("C:\\Users\\Enipok\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\out.txt", false);

            //formatting the matrices
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (test90.getMatrix()[i][j] >= 0) {
                        fileMatrices.append(" ");
                    }
                    if (test90.getMatrix()[i][j] < 10 && test90.getMatrix()[i][j] > -10) {
                        fileMatrices.append(" ");
                    }
                    fileMatrices.append(String.format("%.2f", test90.getMatrix()[i][j]));
                    if (j != size-1) {
                        fileMatrices.append(" ");
                    }
                }
                fileMatrices.append("\n");
            }
            fileMatrices.append("\n");

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (test180.getMatrix()[i][j] >= 0) {
                        fileMatrices.append(" ");
                    }
                    if (test180.getMatrix()[i][j] < 10 && test180.getMatrix()[i][j] > -10) {
                        fileMatrices.append(" ");
                    }
                    fileMatrices.append(String.format("%.2f", test180.getMatrix()[i][j]));
                    if (j != size-1) {
                        fileMatrices.append(" ");
                    }
                }
                fileMatrices.append("\n");
            }
            fileMatrices.append("\n");

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (test270.getMatrix()[i][j] >= 0) {
                        fileMatrices.append(" ");
                    }
                    if (test270.getMatrix()[i][j] < 10 && test270.getMatrix()[i][j] > -10) {
                        fileMatrices.append(" ");
                    }
                    fileMatrices.append(String.format("%.2f", test270.getMatrix()[i][j]));
                    if (j != size-1) {
                        fileMatrices.append(" ");
                    }
                }
                fileMatrices.append("\n");
            }

            out.write(fileMatrices.toString());
            out.close();
        }
        catch (IOException ex) {
            System.out.print("IOException!!! ");
            System.out.println(ex.getMessage());
        }
        catch (LargeMatrixSizeException ex) {
            System.out.print("LargeMatrixSizeException!!! ");
            System.out.println(ex.getMessage());
        }
        catch (ArithmeticException ex) {
            System.out.print("ArithmeticException!!! ");
            System.out.println(ex.getMessage());
        }
        catch (FileDontExistException ex) {
            System.out.print("FileDontExistException!!! ");
            System.out.println(ex.getMessage());
        }
    }
}
