/* This is the solution from the Cracking book: 

 * I need to ask in the first place, that if this problem is asking about ASCII chars or 
 * Unicode chars, because ASCII code has only 256 unique characters while Unicode has 65536 
 * unique characters. 
 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, 
 * you cannot have 280 unique characters if there are total 256 unique characters from the dictionary. 
 * 
 * Then use an array of boolean values to hold the result if any of the chars in the string had 
 * appeared already, if so, return directly. */

/* It's not easy to implement this algorithm, however tiny it is. See comments in the code. */

public class isUniqueCharsStandardSolution {

	public static boolean isUnique(String s){
		if(s.length() > 256)
			/* We assume this problem is asking about ASCII code rather than Unicode. */
			return false;
		else
		{
			boolean [] char_set = new boolean[256];
/* Here's the first trick: I must set the range of the boolean array to 256, b/c we'll use the ASCII value of each
 * character as index, its maximum value is 256. */
			char_set[0] = true;//initialize this array.

			for(int i = 1; i < s.length(); i++){
				int value = s.charAt(i);/*Here's the second trick, what we need is the numeric value of this character,
				namely its ASCII value. */
				if(char_set[value])
					return false;
				else
					char_set[value] = true;
			}
		}
		return true;
	}

	public static void main (String args[]){
		String s = "Steve Sun.";
		System.out.println(isUnique(s));
	}
}
