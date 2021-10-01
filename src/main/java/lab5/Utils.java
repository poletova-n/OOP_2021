package lab5;

import java.util.*;
import java.util.stream.*;


public class Utils
{
	public static double getAverage(List<Integer> arr)
	{
		return arr.stream()
				.reduce((n1, n2) -> n1 +n2)
				.orElse(0)
				.doubleValue() / arr.stream().count();
	}
	
	public static List<String> changeStrings(List<String> arr)
	{
		return arr.stream()
				.map(n -> n.toUpperCase())
				.map(n -> ("_new_" + n))
				.toList();
	}
	
	public static List<Integer> getUniqueSquared(List<Integer> arr)
	{
		return arr.stream()
				.distinct()
				.map(n -> n * n)
				.toList();
	}
	
	public static Collection<String> getSatisfyingStrings(Collection<String> arr, char letter)
	{
		return arr.stream()
				.filter(n -> !n.isEmpty())
				.filter(n -> n.charAt(0) == letter)
				.sorted()
				.toList();
	}
	
	public static <T> T getTail(Collection<T> arr)
	{
		return arr.stream()
				.skip(arr.size() - 1)
				.findAny()
				.orElseThrow();
	}
	
	public static int getSumEven(int[] arr)
	{
		return Arrays.stream(arr)
				.filter(n -> n % 2 == 0)
				.reduce((n1, n2) -> n1 + n2)
				.orElse(0);
	}
	
	public static Map<Character, String> listToMap(List<String> arr)
	{
		return arr.stream()
				.filter(n -> n.length() > 2)
				.collect(Collectors.toMap((n) -> n.charAt(0) , (n) -> n.substring(1)));
	}
}
