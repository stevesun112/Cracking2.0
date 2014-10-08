/*Didn't finish this, just wrote a main function, I need to go back and finish this someday.*/
public class MergeSort {

	public static int [] mergeSort(int a[]){



		return a;
	}

	public static void main (String args[]){
		int a[] = {23, 13, 18, 1, 4, 99, 10001, 64, 7 ,23, 34, 47};
		System.out.println("After calling merge sort, the array becomes:");
		mergeSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
}
