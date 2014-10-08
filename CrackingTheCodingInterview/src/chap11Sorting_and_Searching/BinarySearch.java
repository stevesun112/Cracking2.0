/*I almost figured this one out all by myself, very excited, went thru the
 *debugging process! Fruitful!*/


/*This small program does the following:
 * it returns the index that half of the target number is in your given
 * array if target/2 exists in this array, if not, it returns the index
 * of the array element that is nearest to target/2.*/

public class BinarySearch {
	public static int binarySearch(int array[], int left, int right, int target)
	{ 
		int middle = (left + right)/2;
		/*This middle is the middle index in the array*/
		
		if(target/2 == array[middle])
			return middle;
		else
			if (target/2 < array[middle] && left < right - 1)
				/* Have the second condition "left < right - 1"
				 * is very important, it controls the scenario that
				 * when this target/2 doesn't exist in the array,
				 * it searches to the point that it won't be able to
				 * further divide into half, at this scenario, we just
				 * exit this recursive function and return middle.*/
			{
				right = middle;
				return  binarySearch(array, left, right, target);
			}
			else if (target/2 > array[middle] && left < right - 1)
			{
				left = middle;
				return 	binarySearch(array, left, right, target);
			}
			else 
				return middle;}


	public static void main(String args[]){
		BinarySearch test0 = new BinarySearch();
		int array[] = {1, 3, 4, 6, 8, 9, 10, 13, 18, 20, 23, 32, 45};
		int left = 0;
		int right = 13;
		int target = 22;
		System.out.println(test0.binarySearch(array, left, right, target));
	}
}
