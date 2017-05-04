import java.util.Random;

public class sortApp {
	private static final int NUM_ELEMS = 99;
	private static final int MAX_VALUE = 999;
	private static long[] A; // the array to be sorted

	public static void main(String[] args) {
		
		A = new long[NUM_ELEMS];
		initArray();
		for (int i=0; i<NUM_ELEMS; i++) System.out.print(A[i] + " ");
		System.out.println("");
		
		Tree234 theTree = new Tree234();
		for(int i=0; i<NUM_ELEMS; i++)
			theTree.insert(A[i]);//method on tree234.java
		theTree.displayTree();//method on tree234.java
		// not sorted though ???
	}
	
	public static void initArray()//random numbers
	{
		Random rng = new Random();
		for(int i=0; i<NUM_ELEMS; i++)
			A[i] = Math.abs(rng.nextLong() % (MAX_VALUE + 1));
	}

}
