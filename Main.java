import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
	    for(int i = 0; i < 10; i++)
	    {
	      a[i] = (int)(Math.random()*100);
	    }
	    System.out.println(Arrays.toString(a));
	    System.out.println(Arrays.toString(insert((Integer)100, 2, a, 10)));
	}
	
	public static <T> T[] insert(T insertion, int index, T[] list, int logicalSize)
	{
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

}
