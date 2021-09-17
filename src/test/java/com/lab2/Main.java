package com.lab2;

import lab2.exceptions.DivideZero;
import lab2.exceptions.EmptyFile;
import lab2.exceptions.FileIsNotExist;
import lab2.exceptions.IllegalValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import static lab2.Main.*;

public class Main {

    public static String ERRORFILE = "/Users/evgenijsmirnov/IdeaProjects/OOP_2021/src/main/java/lab2/files/errorText.txt";

    @Test
    @DisplayName("Correct number")
    public void CorrectNumberInFILE() throws EmptyFile, IllegalValue, FileIsNotExist {
        int N = readFromFile(INPUT_FILE_NAME);
        Assertions.assertEquals(3, N);
    }

    @Test
    @DisplayName("File is not exist")
    public void FileIsNotExist() {
        Throwable throwable = catchThrowable(()->{
            int N = readFromFile(INPUT_FILE_NAME+"d");
        });
       assertThat(throwable).isInstanceOf(FileIsNotExist.class);
       assertThat(throwable.getMessage()).isNotBlank();
    }

    @Test
    @Deprecated
    @DisplayName("File is Empty")
    public void FileIsEmptyTest(){
        Throwable throwable = catchThrowable(()->{
            int N = readFromFile(INPUT_FILE_NAME);
        });
        assertThat(throwable).isInstanceOf(EmptyFile.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Char instead of integer number")
    public void IlleglaValueCharTests(){
        Throwable charValue = catchThrowable(()->{
            int N = readFromFile(ERRORFILE);
        });
        assertThat(charValue).isInstanceOf(IllegalValue.class);
        assertThat(charValue.getMessage()).isNotBlank();

        Throwable NotIntegerValue = catchThrowable(()->{
            int N = readFromFile(ERRORFILE);
        });
        assertThat(NotIntegerValue).isInstanceOf(IllegalValue.class);
        assertThat(NotIntegerValue.getMessage()).isNotBlank();
    }

    @Test
    @Deprecated
    @DisplayName("Not Integer instead of integer number")
    public void IlleglaValueDoubleTests(){

        Throwable NotIntegerValue = catchThrowable(()->{
            int N = readFromFile(ERRORFILE);
        });
        assertThat(NotIntegerValue).isInstanceOf(IllegalValue.class);
        assertThat(NotIntegerValue.getMessage()).isNotBlank();
    }

    @Test
    @DisplayName("Check predictable results")
    public void StableJob() throws DivideZero {

        int N = 3;

        double[][] matrix = new double[][]{
            {1d,2d,3d},
            {4d,5d,6d},
            {7d,8d,9d}
        };

        double[][] mergeMatrix = new double[][]{
                {0.17,0.22,0.38},
                {0.31,0.25,0.35},
                {0.58,0.38,0.64}
        };

        double[][] rotatedMatrix = new double[][]{
                {0.58,0.31,0.17},
                {0.38,0.25,0.22},
                {0.64,0.35,0.38}
        };

        matrix = mergeNeighbors(matrix);
        Assertions.assertArrayEquals(matrix[0], mergeMatrix[0]);
        Assertions.assertArrayEquals(matrix[1], mergeMatrix[1]);
        Assertions.assertArrayEquals(matrix[2], mergeMatrix[2]);

        matrix = rotate90Degrees(matrix);
        Assertions.assertArrayEquals(matrix[0], rotatedMatrix[0]);
        Assertions.assertArrayEquals(matrix[1], rotatedMatrix[1]);
        Assertions.assertArrayEquals(matrix[2], rotatedMatrix[2]);
    }

    @Test
    @Deprecated
    @DisplayName("Check predictable results")
    public void DivideZeroTest() {

        Throwable throwable = catchThrowable(()->{
            mergeNeighbors(new double[][]{
                    {1d,0d,3d},
                    {0d,5d,6d},
                    {7d,8d,9d}
            });
        });
        assertThat(throwable).isInstanceOf(DivideZero.class);
        assertThat(throwable.getMessage()).isNotBlank();
    }

}

