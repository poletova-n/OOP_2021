package lab5;

import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		try 
		{
			List<Integer> array = new ArrayList<>();
			array.add(1);
			array.add(2);
			array.add(3);
			array.add(2);
			array.add(5);
			array.add(9);
			array.add(4);
			array.add(4);

			System.out.println(Utils.getAverage(array));
			
			List<String> strArray = new ArrayList<>();
			strArray.add("dfscvbvdfv");
			strArray.add("00000024edfzxcKjdsfCVi34");
			strArray.add("44zxcxzc20vr34vcxxASECXVd");
			strArray.add("XfsdfcDSfvx3212vFVF9");
			strArray.add("p32sVRWRFTV989v43rvrS");
			strArray.add("");
			strArray.add("mfscvdsFZREGfdvd");

			System.out.println(Utils.changeStrings(strArray));

			System.out.println(Utils.getUniqueSquared(array));

			System.out.println(Utils.getSatisfyingStrings(strArray, '4'));

			System.out.println(Utils.getTail(array));
			System.out.println(Utils.getTail(strArray));
			//List<String> emptyArray = new ArrayList<>();
			//System.out.println(Utils.getTail(emptyArray));
			
			int [] arrWithEven = {2, 5, 9, 0, 1, 22, 4, 7, 5, 3};
			int [] arrWithoutEven = {1, 9, 3, 7, 5};

			System.out.println(Utils.getSumEven(arrWithEven));
			System.out.println(Utils.getSumEven(arrWithoutEven));
			
			System.out.println(Utils.listToMap(strArray));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
