/*This is the same question as in twoSum.java,
 * but this time we used HashMap to solve it, it's much more efficient!
 *
 *It was right thru this example did I TRUELY realize the O(1) access time
 *in HashMap! It's really amazing!*/
import java.util.HashMap;

/*The KEY thing to bare in mind is that in HashMap, 
 *you can only get values using key, NOT the other way around!*/

/*Using HashMap.get(key) method, you can only put key inside the parenthesis to get its corresponding value,
 *never the other way around!
 *
 *So if you want to traverse all the keys in the HashMap, you need to use a for loop as follows:
 *
 *for(int key : HashMap.keySet())
 *System.out.print(key);
 *
 *to print out all its keys in this HashMap.*/


/*Difference between ASCII code and Unicode:
 * 
 *They're two different ways of giving code to each symbol, including metacharacters, numbers, chars, etc.
 *ASCII: 2 to the power of 8: 256 , means there're possibly 256 unique addresses that can be used to represent stuff.
 *Unicode: 2 to the power of 16: 65536, means there're possibly 65536 unique address that can be used to represent stuff.*/



public class twoSumHashMapVersion {
	public static boolean findTwoNum(int []a, int target)
	{
		HashMap<Integer, Integer> intHashMap = new HashMap();
		/*First Integer is the element value in this array, second Integer is the index of that element.*/
		for(int i = 0; i < a.length; i++){
			intHashMap.put(a[i], i);
		}

		//		for(int i = 0; i < a.length; i++){
		//			System.out.print(intHashMap.get(a[i]) + " ");
		//		}
		//		System.out.print("\n");
		//		for(int key: intHashMap.keySet()){
		//			System.out.print(key + ":" + intHashMap.get(key) + " ");
		//		}
		//		System.out.print("\n");

		for(int i = 0; i < a.length; i++)
		{		
			if(intHashMap.containsKey(target - a[i]) && i != intHashMap.get(target - a[i])){
				/*We have the second condition there to test that it's not adding itself to find the target,
				 *because we first put all values in the array into the HashMap, and then we try to find
				 *such a pair, for example, if target is 30, there's only one 15 in the array, it's possible that
				 *15 added itself to get the target value, but there's actually no other 15 in the array, so
				 *we need to prevent such situations from happening.*/
				System.out.println("index1 = " + (i+1));
				/*The problem requires the index starts from 1, so we added 1 to it.*/
				System.out.println("index2 = " + (intHashMap.get(target - a[i]) + 1));
				return true ;

			}
		}
		{
			System.out.println("No such two elements exist in the array that can add up to the target.");
			return false;
		}
	}
	public static void main(String args[]){
		int [] a = {2, 7, 11, 15, 17, 19, 32, 34, 45, 56, 58, 63, 76, 78, 93};
		int target = 17;
		findTwoNum(a, target);
	}
}