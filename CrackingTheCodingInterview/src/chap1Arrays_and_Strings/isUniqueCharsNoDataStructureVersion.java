/* Same problem, but this time, no additional data structures are used. */

/* Two for loops to solve this problem, I coded and finished this mini-program all
 * by myself in less than 5 mins, very excited about this! */



/* This algorithm is very inefficient, but in order to meet the requirement that no
 * additional data structures used.
 * I traversed thru this string twice, each time compare the rest of the characters with one character,
 * to see if there's any duplicate. */

/* Actually this turned out to be really not optimal solution. The one that provided by the Cracking book
 * is that you use an boolean value array to store the info that if this char is unique or not in the array,
 * if it's not, then directly return false. 
 * 
 * I'll implement this in another .java file. */

/* Also, I need to ask in the first place, that if this problem is asking about ASCII chars or Unicode chars,
 * because ASCII code has only 256 unique characters while Unicode has 65536 unique characters. 
 * Then we need to check if the length of the string is shorter than 256 or 65536, because, after all, you cannot
 * have 280 unique characters if there are total 256 unique characters from the dictionary. */

public class isUniqueCharsNoDataStructureVersion {
public static boolean isUnique(String s){
	for( int i = 0; i < s.length(); i++){
		char temp = s.charAt(i);
		for( int j = 0; j < s.length(); j++){
			if(s.charAt(j) == temp && i != j)
				return false;
		}
	}
	return true;
}
	
	public static void main (String args[]){
		String s = "Steve Sun.";
		System.out.println(isUnique(s));
	}
}
