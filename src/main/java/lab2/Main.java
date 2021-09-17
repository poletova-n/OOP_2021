package lab2;

import lab2.exceptions.*;

public class Main {
	public static void main(String[] args) throws FileNotFound, InvalidSize
	{
		Matrix matrix = new Matrix("/home/dstakheev/input.txt");
		matrix.printMatix("/home/dstakheev/output.txt");
		
		for (int i = 0; i < 3; i++)
		{
			matrix.makeIteration();
			matrix.printMatix("/home/dstakheev/output.txt");
		}
		
		System.out.println("The matrices are printed in output.txt");
	}
}
