/* I copied the solution from CTCI for Cracking 9.5 */

/* Cracking 9.5: Write a method to compute all permutations of a string */

import java.util.ArrayList;

public class Cracking9_5 {
	public static ArrayList<String> getPerms(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word: words){
			for(int j = 0; j <= word.length(); j++){
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	public static void main(String args[]){
		String s = "abcd";
		System.out.println(getPerms(s));
		System.out.println("Program finished.");
	}
}
