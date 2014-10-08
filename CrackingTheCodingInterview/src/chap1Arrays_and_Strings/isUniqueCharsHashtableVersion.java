import java.util.Hashtable;

/* Cracking 1.1: 
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures? */


/* First, I used additional data structures to solve this: 
 * I'm very excited that I coded, debugged and finished this small program all by myself in 10 mins.
 * Cool! I love this feeling!*/

/* Use HashTable to implement this: 
 * put each character into the HashTable, before putting every 
 * element into it, compare if there is already a same one in the HashTable,
 * if there is, return false, directly. */

/* Afer checking the solution, I found that I was not thinking in an all-round way, 
 * I need to ask in the first place, that if this problem is asking about ASCII chars or Unicode chars,
 * because ASCII code has only 256 unique characters while Unicode has 65536 unique characters. 
 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, 
 * you cannot have 280 unique characters if there are total 256 unique characters from the dictionary. */

public class isUniqueCharsHashtableVersion {

	public static boolean isUnique(String s){
		Hashtable<Integer, Character> charHashtable = new Hashtable();

		for(int i = 0; i < s.length(); i++){
			if(charHashtable.contains(s.charAt(i)))
				/* Hashtable.contains() methods checks if it contains the VALUES
				 * rather than the keys, keep this in mind! */
				return false;
			else
				charHashtable.put(i, s.charAt(i));
		}
		return true;
	}

	public static void main (String args[]){
		String s = "Steve Sun.";	
		System.out.println(isUnique(s));
	}
}