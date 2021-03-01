import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.exit(42);
		Integer[] list = {null, 10, null, null, 10, 20, 30, null, null};
		String[] listA = {"blah", null, null, "aaaaa", "demoknight tf2"};
	    System.out.println(Arrays.toString(list));
	    System.out.println(Arrays.toString((list)));
	    System.out.println(Arrays.toString(delete(3, listA)));
	    stats("input");
	}
	
	//as long as objects(Strings) are used to test these they will automatically infer the type needed so I won't add anything for primatives
	
	public static <T> T[] insert(T insertion, int index, T[] list)
	{
		@SuppressWarnings("unchecked")
		T[] newList = (T[]) new Object[list.length + 1];
		for (int i = list.length; i > index; i--)
		{
			newList[i] = list[i - 1];
		}
		newList[index] = insertion;
		
		for (int i = 0; i < index; i++)
		{
			newList[i] = list[i];
		}
		return newList;
	}
	
	public static <T> T[] delete(int index, T[] list)
	{
		@SuppressWarnings("unchecked")
		T[] newList = (T[]) new Object[list.length - 1];
		for (int i = 0; i < index; i++)
		{
			newList[i] = list[i];
		}
		
		for (int i = index; i < newList.length; i++)
		{
			newList[i] = list[i + 1];
		}
		return newList;
	}
	
	public static void stats(String filename) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File(filename));
		double mean;
		double median;
		double stddev;
		double sum = 0;
		double medianIndex;
		
		double[] list = new double[5000];
		int i = 0;
		while (reader.hasNext())
		{
			double next = reader.nextDouble();
			list[i] = next;
			sum += next;
			i++;
		}
		mean = sum / i;
		medianIndex = i / 2;
		list = Arrays.copyOf(list, i);
		Arrays.sort(list);
		if (medianIndex%2 == 0)
		{
			median = list[(int)(medianIndex)];
		} else
		{
			median = (list[(int)(medianIndex)] + list[(int)(medianIndex + 1)]) / 2;
		}
		
		stddev = stdev(list, mean);
		
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		writer.println("Mean: "+mean);
		writer.println("Median: "+median);
		writer.println("Standard Deviation: "+stddev);
		writer.close();
	}
	
	public static <T> T[] removeNulls(T[] list)
	{
		int j = 0;
		@SuppressWarnings("unchecked")
		T[] newList = (T[])new Object[list.length];
		
		for (int i = 0; i < list.length; i++)
		{
			T item = list[i];
			if (item != null)
			{
				newList[j] = item;
				j++;
			}
		}
		return newList;
	}
	
	private static double stdev(double[] list, double mean) {
		double sum = 0;
		for (int i = 0; i < list.length; i++)
		{
			sum += Math.pow(list[i] - mean, 2);
		}
		sum /= list.length - 1;
		sum = Math.sqrt(sum);
		return sum;
	}

}
