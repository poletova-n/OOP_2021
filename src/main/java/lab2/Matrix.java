package lab2;

import lab2.exceptions.*;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Matrix 
{
	private int size;
	private double[][] matrix;

	public Matrix(String path) throws FileNotFound, InvalidSize
	{
		readSize(path);
		fillMatrix();
	}
	
	public void makeIteration()
	{
		divideElements();
		rotate();
	}
	
    public void printMatix(String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)))
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
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }	
	
	private void readSize(String path) throws FileNotFound, InvalidSize 
	{
		try 
		{
			File file = new File(path);

			if (!file.exists())
			{
				throw new FileNotFound("File not found!");
			}
		} 
		catch (FileNotFound ex) 
		{
			ex.printStackTrace();
		}
		
		try (Scanner sizeReader = new Scanner(new FileInputStream(path)))
		{
			int tempSize = 0;
			
			if (sizeReader.hasNextInt())
			{
				tempSize = sizeReader.nextInt();
			}
			else 
			{
				throw new InvalidSize("Size must be a positive integer");
			}
			
			if ((tempSize > 1_000_000) | (tempSize < 1))
			{
				throw new InvalidSize("Size must be less than 1_000_000 and greather than 0");
			}
			
			size = tempSize;
		}
		catch (InvalidSize | IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void fillMatrix()
	{
		double[][] tempMatrix = new double[size][size];
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				double elem = Math.round((Math.random() * (size * 2)) - size);
				tempMatrix[i][j] = elem;
			}
		}
		
		matrix = Arrays.copyOf(tempMatrix, size);
	}
	
	private void divideElements()
	{
		double[][] tempMatrix = new double[size][size];
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				double tempSum = getSumOfNeighbors(i, j);	
				
				try 
				{
					if (tempSum == 0)
					{
						throw new DivisionByZero("Division by zero!");
					}

					tempMatrix[i][j] = matrix[i][j] / tempSum;
				}
				catch (DivisionByZero ex)
				{
					tempMatrix[i][j] = Double.POSITIVE_INFINITY;
				}
				
			}		
		}
		
		matrix = Arrays.copyOf(tempMatrix, size);
	}
	
	private double getSumOfNeighbors(int i, int j)
	{
		double tempSum = 0;
		
		if (i - 1 >= 0)
		{
			tempSum += matrix[i - 1][j];
		}
		
		if (i + 1 <= size - 1)
		{
			tempSum += matrix[i + 1][j];
		}
		
		if (j - 1 >= 0)
		{
			tempSum += matrix[i][j - 1];
		}
		
		if (j + 1 <= size - 1)
		{
			tempSum += matrix[i][j + 1];
		}
		
		return tempSum;
	}
	
	private void rotate()
	{
		double[][] tempMatrix = new double[size][size];
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				tempMatrix[i][j] = matrix[j][size - i - 1];
			}
		}
		
		matrix = Arrays.copyOf(tempMatrix, size);
	}
}
	