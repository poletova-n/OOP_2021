package lab2.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lab2.exceptions.*;

public class MatrixSizeReader {

    private final String path;

    public MatrixSizeReader(String filePath){
        path = filePath;
    }

    public int readSize(){
        int a = 0;
        int tempSize = 0;

        try(FileInputStream fis = new FileInputStream(path)){

            StringBuilder stringBuilder = new StringBuilder();

            while ((a = fis.read()) != -1){
                stringBuilder.append((char) a);
            }


            if (stringBuilder.isEmpty()){
                throw new EmptyFile("File is empty!");
            }

            tempSize = Integer.parseInt(stringBuilder.toString());

           if(tempSize > 1000000 | tempSize <= 0){
               throw new InadmissibleMatrixSize("Inadmissible matrix size!");
           }

        }catch ( IOException | NumberFormatException | EmptyFile | InadmissibleMatrixSize exception) {
            exception.printStackTrace();
            return 0;
        }

        return tempSize;

    }

}
