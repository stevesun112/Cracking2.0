/*Cracking 1.8: 
  
  Check if one string is a rotated version of a given string.
 *Example: bcdea is a rotated version of abcde,
 *also, deabc is also a rotated version of abcde.*/


/*This program utilizes a very handy and smart algorithm:
 *First, check if these two strings have equal lengths or not.
 *Then, concatenate the original string with itself,
 *say abcde, concatenate itself, we get abcdeabcde,
 *then any rotated version should be contained in this string,
 *using Java contains method!*/

public class RotationCheck {

	public static boolean isRotation(String s1, String s2){
		return (s1.length() == s2.length()) && (s1+s1).contains(s2);
	}
	
	public static void main(String args[]){
		RotationCheck test = new RotationCheck();
		String s1 = "abcde";
		String s2 = "eabc";
		System.out.print(test.isRotation(s1, s2));
	}
}
