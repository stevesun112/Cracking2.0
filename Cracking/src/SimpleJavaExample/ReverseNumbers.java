package SimpleJavaExample;
/*After help from Raoyin Chen, finally made this program runnable, 
 * very excited! But it doesn't produce result as expected,
 * then there must be something wrong with my algorithm. 
 * But still excited though.*/

public class ReverseNumbers {

	int[] array1;	
	
	public void reverseNumbers(int[] array1){
		int size = array1.length;
		int temp = 0;
		if(size%2 != 0){
			for(int i = 0; i < (size-1)/2; i++){
				temp = array1[size-1];
				array1[size-1] = array1[i];
				array1[i] = temp;
			}
			System.out.println("After reversing, now the array a[size] is ");
			for(int i = 0; i < size; i++){
				System.out.print(array1[i] + " ");
			}
		}
		else{
			for(int i = 0; i < size/2; i++){
				temp = array1[size-1];
				array1[size-1] = array1[i];
				array1[i] = temp;
			}
			System.out.println("After reversing, now the array a[size] is ");
			for(int i = 0; i < size; i++){
				System.out.print(array1[i] + " ");
			}
		}
//		return a[size];
	}	
	
public static void main (String [] args){
		
		int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		ReverseNumbers myArray = new ReverseNumbers();
		myArray.array1 = array2;
		myArray.reverseNumbers(array2);
		
	}
}
