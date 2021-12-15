package lab2;

import lab2.Exceptions.DivideZeroException;
import lab2.Exceptions.FileOpeningException;
import lab2.Exceptions.WrongValueException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\Users\\user.v2.0\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\files\\inputFile.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\user.v2.0\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\files\\outputFile.txt")){//
            File readFile = new File("C:\\Users\\user.v2.0\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\files\\inputFile.txt");
            File writeFile = new File("C:\\Users\\user.v2.0\\IdeaProjects\\OOP_2021\\src\\main\\java\\lab2\\files\\outputFile.txt");
            if(!readFile.exists() || !writeFile.exists())
                throw new FileOpeningException("file not opened or doesn't exists");
            //fileReader = new FileReader(readFile);
            //fileWriter = new FileWriter(writeFile);
            char[] buff = new char[200];
            fileReader.read(buff);
            String temp = "";
            for (int i = 0; i < 200; i++) {
                if (buff[i]<'0' || buff[i] > '9')
                    break;
                temp += buff[i];
            }
            int size = Integer.parseInt(temp);
            if (size > 1_000_000)
                throw new WrongValueException("Size of array is too big");
            System.out.println(size);
            Matrix matrix = new Matrix(size);
            //matrix.fillCounting();
            matrix.printMatrix();
            System.out.println();
            matrix.rotate(270);
            matrix.printMatrix();
            matrix.writeIntoFile(fileWriter);
        }catch (FileOpeningException|IOException e ){
            System.out.println(e.getMessage());
            System.out.println("IOException");
        }catch (DivideZeroException e){
            System.out.println(e.getMessage());
            System.out.println("Your program try divide on zero");
        } catch (WrongValueException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Program finished with unknown error");
        }
    }
}
