package lab2.utilities;

import java.io.*;

import lab2.exceptions.*;

public class MatrixSizeReader {

    private final String path;

    public MatrixSizeReader(String filePath){
        path = filePath;
    }

    public int readSize(){
        int a;
        int size;

        try {

            File inputFile = new File(path);

            if (!inputFile.exists()){
                throw new FileNotFound("Input file not found!");
            }

        }catch (FileNotFound exception){
            exception.printStackTrace();
        }

        try(FileReader fileReader = new FileReader(path)){

            StringBuilder stringBuilder = new StringBuilder();

            while ((a = fileReader.read()) != -1){
                stringBuilder.append((char) a);
            }

            if (stringBuilder.isEmpty()){
                throw new EmptyFile("File is empty!");
            }

            size = Integer.parseInt(stringBuilder.toString());

           if(size > 1000000 | size <= 0){
               throw new InadmissibleMatrixSize("Inadmissible matrix size!");
           }

        }catch ( IOException | NumberFormatException | EmptyFile | InadmissibleMatrixSize exception) {
            exception.printStackTrace();
            return 0;
        }

        return size;

    }

}
