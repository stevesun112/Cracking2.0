/* Cracking 1.4: 
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation in place. 
 * 
 * EXAMPLE:
 * Input:  "Mr John Smith    "
 * Output: "Mr%20John%20Smith" 
 * 
 * */

/* I figured this out and implemented and made it run correctly 
 * in less than 20 mins, hooray! Very excited! */

/* But after checking the solution provided by the Cracking book,
 * this turned out not to be the answer that this problem is looking for,
 * b/c it wants to sort into place, instead of using an additional array. 
 * 
 * So, what they did is:
 * first traverse this string and count how many spaces there are in this string;
 * second, go backwards, whenever you encounter a space, you write '0', '2', '%' into
 * them sequentially, in this way, you won't overwrite characters. 
 * 
 * But after a second thought and detailed look into the code it provided, I thought
 * it also used an additional array, if this is true, my answer is even better and more concise. */

public class replaceSpace {

	public static String replacespace(String s){

		String result = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ')
				result = result + "%20";
			else
				result = result + s.charAt(i);
			/* char and String can add up together! I don't need to use any other methods! */
		}

		return result;
	}
	
	public static void main (String args[]){
		String s = "Cool, isn't it?";
		System.out.println(replacespace(s));
	}
}
