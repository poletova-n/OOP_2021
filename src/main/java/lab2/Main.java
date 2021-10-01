package lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void rotateMatrix90(double[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) {

            int top = i;
            int bottom = matrix.length - 1 - i;

            for (int j = top; j < bottom; j++) {
                double temp = matrix[top][j];
                matrix[top][j] = matrix[j][bottom];
                matrix[j][bottom] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = temp;
            }

            for (i = 0; i <= matrix.length - 1; i++) {
                for (int j = 0; j <= matrix.length - 1; j++) {
                    double neigbors = 1;
                    if (i != 0 && j != 0 && i != matrix.length - 1 && j != matrix.length - 1) {
                        neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] + matrix[i][j + 1] +
                                matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                    } else {
                        if (i == 0 && j == 0) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1];
                        } else if (j == 0 && i == matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (j == 0 && i != 0 && i != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1] +
                                    matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (i == 0 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        } else if (i == 0 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] +
                                    matrix[i][j + 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                        } else if (i != 0 && i != matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] +
                                    matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        }
                    }
                    try {
                        if (neigbors == 0 || matrix[i][j] / neigbors==Double.POSITIVE_INFINITY ||
                                matrix[i][j] / neigbors==Double.NEGATIVE_INFINITY) throw new ActionWithNull("You can't divide by zero!");
                    }
                    catch (ActionWithNull ex) {

                        System.out.println(ex.getMessage());
                    }

                    matrix[i][j] = matrix[i][j] / neigbors;
                }
            }
        }

    }

    public static void rotateMatrix180(double[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) {

            int top = i;
            int bottom = matrix.length - 1 - i;

            for (int j = top; j < bottom; j++) {
                double temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = temp;
                temp = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = matrix[j][bottom];
                matrix[j][bottom] = temp;
            }

            for (i = 0; i <= matrix.length - 1; i++) {
                for (int j = 0; j <= matrix.length - 1; j++) {
                    double neigbors = 1;
                    if (i != 0 && j != 0 && i != matrix.length - 1 && j != matrix.length - 1) {
                        neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] + matrix[i][j + 1] +
                                matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                    } else {
                        if (i == 0 && j == 0) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1];
                        } else if (j == 0 && i == matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (j == 0 && i != 0 && i != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1] +
                                    matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (i == 0 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        } else if (i == 0 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] +
                                    matrix[i][j + 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                        } else if (i != 0 && i != matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] +
                                    matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        }
                    }
                    try {
                        if (neigbors == 0 || matrix[i][j] / neigbors==Double.POSITIVE_INFINITY ||
                                matrix[i][j] / neigbors==Double.NEGATIVE_INFINITY) throw new ActionWithNull("You can't divide by zero!");
                    }
                    catch (ActionWithNull ex) {

                        System.out.println(ex.getMessage());
                    }

                    matrix[i][j] = matrix[i][j] / neigbors;
                }
            }
        }

    }

    public static void rotateMatrix270(double[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        for (int i = 0; i < matrix.length / 2; i++) {

            int top = i;
            int bottom = matrix.length - 1 - i;

            for (int j = top; j < bottom; j++) {
                double temp = matrix[top][j];
                matrix[top][j] = matrix[bottom - (j - top)][top];
                matrix[bottom - (j - top)][top] = matrix[bottom][bottom - (j - top)];
                matrix[bottom][bottom - (j - top)] = matrix[j][bottom];
                matrix[j][bottom] = temp;
            }

            for (i = 0; i <= matrix.length - 1; i++) {
                for (int j = 0; j <= matrix.length - 1; j++) {
                    double neigbors = 1;
                    if (i != 0 && j != 0 && i != matrix.length - 1 && j != matrix.length - 1) {
                        neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] + matrix[i][j + 1] +
                                matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                    } else {
                        if (i == 0 && j == 0) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1];
                        } else if (j == 0 && i == matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (j == 0 && i != 0 && i != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i][j + 1] +
                                    matrix[i - 1][j] + matrix[i - 1][j + 1];
                        } else if (i == 0 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        } else if (i == 0 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j - 1] +
                                    matrix[i][j + 1] + matrix[i][j - 1];
                        } else if (i == matrix.length - 1 && j != 0 && j != matrix.length - 1) {
                            neigbors = matrix[i][j + 1] + matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1] + matrix[i - 1][j + 1];
                        } else if (i != 0 && i != matrix.length - 1 && j == matrix.length - 1) {
                            neigbors = matrix[i + 1][j] + matrix[i + 1][j - 1] +
                                    matrix[i][j - 1] + matrix[i - 1][j] + matrix[i - 1][j - 1];
                        }
                    }
                    try {
                        if (neigbors == 0 || matrix[i][j] / neigbors==Double.POSITIVE_INFINITY ||
                                matrix[i][j] / neigbors==Double.NEGATIVE_INFINITY) throw new ActionWithNull("You can't divide by zero!");
                    }
                    catch (ActionWithNull ex) {

                        System.out.println(ex.getMessage());
                    }

                    matrix[i][j] = matrix[i][j] / neigbors;
                }
            }
        }

    }

    public static void main(String args[]) throws IOException {

        try {
            File file = new File("C:\\javaWorks\\test.txt");
            File file2 = new File("C:\\javaWorks\\test2.txt");

            if(!file.exists()) {
                throw new FileNotExist("File not exist!");
            }
            if (file.length()==0) {
                throw new EmptyFile("File 1 is empty!");
            }
            FileInputStream inFile = new FileInputStream(file);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            String text = new String(str);

            //String[] numbers = text.split("\\D");
            int i, j;
            int n = Integer.parseInt(text,10);
            if (n>1000000 || n<=0){
                throw new WrongSize ("Invalid argument for size!");
            }
            double matr[][] = new double[n][n];

            for (i = 0; i < n; i++)
                for (j = 0; j < n; j++)
                    matr[i][j] = (int) Math.round((Math.random() * (n + n + 1)) - n);

            if(!file2.exists()) {
                file2.createNewFile();
            }
            try (FileWriter writer = new FileWriter("C:\\javaWorks\\test2.txt", false)) {

                writer.write("Matrix\n");

                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        writer.write(matr[i][j] + " ");
                    }
                    writer.append('\n');
                }

                rotateMatrix90(matr);

                writer.write("New matrix 90\n");

                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        writer.write(matr[i][j] + " ");
                    }
                    writer.append('\n');
                }

                rotateMatrix180(matr);

                writer.write("New matrix 180\n");

                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        writer.write(matr[i][j] + " ");
                    }
                    writer.append('\n');
                }

                rotateMatrix270(matr);

                writer.write("New matrix 270\n");

                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        writer.write(matr[i][j] + " ");
                    }
                    writer.append('\n');
                }

                writer.flush();

                if (file2.length()==0) {
                    throw new EmptyFile("File2 is empty!");
                }

            }
        }catch (IOException | WrongSize | FileNotExist | EmptyFile ex  ) {

            System.out.println(ex.getMessage());
        }

    }
}