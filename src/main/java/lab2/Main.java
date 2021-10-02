package lab2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size=0;
        File file = new File("C:/Users/User/IdeaProjects/OOP_2021/src/main/java/lab2/MatrixIn.txt");

        try  { if(!file.exists()){
            throw new FilenotFound("File not Found", 2);
        }
        } catch (FilenotFound e) {
            System.out.print(e.getMessage());
            System.out.print(e.getNumber());
        }

        try(Scanner scanner = new Scanner("C:/Users/User/IdeaProjects/OOP_2021/src/main/java/lab2/MatrixIn.txt")){
            //System.out.print(scanner.nextInt());
            /*if(!(scanner.hasNext())){
                throw new IOException("File is empty");
            }*/
            if(!(scanner.hasNextInt())){
                throw new IOException("File hasn't int types");
            }
            else{
                size = 1;
                scanner.nextInt();
                while (scanner.hasNextInt()){
                    size++;
                    scanner.nextInt();
                }
                if(size>1000000){
                    throw new LargeMatrix("Huge size Matrix",3);
                }
                scanner.close();
            }
        }
        catch (IOException e){
            System.out.print(e.getMessage());
        }
        catch (LargeMatrix e) {
            System.out.print(e.getMessage());
            System.out.print(e.getNumber());
        }

        try{
            file = new File("C:\\Users\\User\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\MatrixOut.txt");
            if(!file.exists()){
                throw new FilenotFound("Output File not found", 2);
            }

            FileWriter fileWriter = new FileWriter("C:\\Users\\User\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\MatrixOut.txt");

            WorkWithMatrix workWithMatrix = new WorkWithMatrix(size);
            WorkWithMatrix workWithMatrix1 = new WorkWithMatrix(workWithMatrix.turn90());
            WorkWithMatrix workWithMatrix2 = new WorkWithMatrix(workWithMatrix.turn180());
            WorkWithMatrix workWithMatrix3 = new WorkWithMatrix(workWithMatrix.turn270());

            workWithMatrix.div();
            workWithMatrix1.div();
            workWithMatrix2.div();
            workWithMatrix3.div();

            workWithMatrix.Print();
            System.out.print("\n\n\n");
            workWithMatrix1.Print();
            System.out.print("\n\n\n");
            workWithMatrix2.Print();
            System.out.print("\n\n\n");
            workWithMatrix3.Print();

            workWithMatrix.OutOfFile(fileWriter);
            fileWriter.write("\n\n\n");
            workWithMatrix1.OutOfFile(fileWriter);
            fileWriter.write("\n\n\n");
            workWithMatrix2.OutOfFile(fileWriter);
            fileWriter.write("\n\n\n");
            workWithMatrix3.OutOfFile(fileWriter);
            fileWriter.write("\n\n\n");
            fileWriter.close();
        }
        catch (IOException | ArithmeticException e){
            System.out.print(e.getMessage());
        }
        catch (FilenotFound e){
            System.out.print(e.getMessage());
            System.out.print(e.getNumber());
        }
    }
}
