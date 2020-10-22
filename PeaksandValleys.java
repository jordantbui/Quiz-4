/*
 Jordan Bui
 011821368
 Fall 2020
 CS 3310
 Quiz 4
 Peaks and Valleys
 
 This program sorts an array by peaks and valleys by checking every two array
 indexes. 
 - Starts at array index 1, second element, and checks in the previous
 element is smaller than the current. If it is smaller, swap the current
 element with the previous element, which becomes the new current element.
  
 - Then check if the current element is smaller than the element to the
 right. If it is larger than the element on the right, swap the elements.
 
 - Prints initial array and size then sorts and prints sorted array and sorting time
 in nanoseconds
 
 
 Time Complexity:
 T(n) = O(n)
 Since the sort algorithm contains one for loop that searches all elements in the 
 array, the time complexity is O(n).
 As the size of the array increases, the program will have more array elements to sort 
 through, increasing runtime.
 
 
Sample Test run:

CS 3310 Quiz 4 Peaks and Valleys
Jordan Bui
-----------------------------------

Array Size 5:
  5   3   1   2   3 

Sorted Peaks and Valleys Array:
  5   1   3   2   3 

Time Elapsed to Sort: 980ns
-----------------------------------

Array Size 100:
 39  72  74  76  36   1  89  10  59  19 
 49  57  48  35  37  82   4  35  57  93 
 25  76  80  33  56  74   1  64  45  30 
 94  43  24  81  26  42   3  39  86  80 
 53  64  71  68  13  22  18  73  72  93 
 76  61  65  56  45  46  75  52  33  83 
 14  28  19  33   6  47  10  73  42  95 
 21  85  77  99   2  20  79  88  66  99 
 46  73  73  46  60   9  94  77  37  42 
 11  11  95  75  68  97   2  39  93  24 

Sorted Peaks and Valleys Array:
 72  39  76  36  74   1  89  10  59  19 
 57  48  49  35  82   4  37  35  93  25 
 76  57  80  33  74   1  64  45  56  30 
 94  24  81  26  43   3  42  39  86  53 
 80  64  71  13  68  18  73  22  93  72 
 76  61  65  45  56  46  75  33  83  14 
 52  19  33   6  47  10  73  28  95  21 
 85  42  99   2  77  20  88  66  99  46 
 79  73  73  46  60   9  94  37  77  11 
 42  11  95  68  97   2  75  39  93  24 

Time Elapsed to Sort: 4687ns
-----------------------------------
 
 */
import java.util.Random;

public class PeaksandValleys
{
	
	// Print Array Function
	private static void printArray(int arr[])
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (i % 10 == 0 && i > 0)
				System.out.println();
			System.out.printf("%3d" + " ", arr[i]);
		}
		System.out.println('\n');
	}
	
	
	// Peaks And Valleys Sort
	public static void sortPeaksandValleys(int arr[])
	{
		// Prints initial array
		System.out.println("Array Size " + arr.length + ":");
		printArray(arr);
		
		// Sorts array in alternating peaks and valleys
		long startTime = System.nanoTime();
		for (int i = 1; i < arr.length; i += 2)
		{
			if (arr[i - 1] < arr[i])
			{
				int tmp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = tmp;
			}
			if (i + 1 < arr.length && arr[i + 1] < arr[i])
			{
				int tmp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = tmp;
			}
		}
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		
		// Prints Peaks and Valleys Array
		System.out.println("Sorted Peaks and Valleys Array:");
		printArray(arr);
		System.out.println("Time Elapsed to Sort: " + time + "ns");
		System.out.println("-----------------------------------\n");
	}

	
// Test Program
	public static void main(String[] args)
	{
		System.out.println("CS 3310 Quiz 4 Peaks and Valleys");
		System.out.println("Jordan Bui");
		System.out.println("-----------------------------------\n");
		Random rand = new Random();
		
		// Tests example array
		int nums[] = new int[] {5, 3, 1, 2, 3};
		sortPeaksandValleys(nums);
		
		// Tests random array size 100
		int nums100[] = new int[100];
		for (int i = 0; i < nums100.length; i++)
		{
			nums100[i] = rand.nextInt(100);
		}
		sortPeaksandValleys(nums100);

	}
}
