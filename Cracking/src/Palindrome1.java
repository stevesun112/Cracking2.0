/* Leetcode:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/


/* This is a problem that I solved before, but in order to cater to Leetcode submission
 * requirements, it works perfectly fine, but this one is not efficient enough, 
 * rejected on Leetcode because exceeded time limit, so I wrote Palindrome2.java */

public class Palindrome1 {

	public static boolean isPalindrome(String s){
		String newStr = "";
		int len = s.length();
		for(int i = 0; i < len; i++){
			if((s.charAt(i) >= '0' && s.charAt(i) <= '9')
			    || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') 
			    || (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')) {
				if(s.charAt(i) >= 'A' &&
						s.charAt(i) <= 'Z'){
					newStr = newStr + Character.toLowerCase(s.charAt(i));
				}
				else{
					newStr = newStr + s.charAt(i);
				}
				
			}

		}
		len = newStr.length();
		System.out.print(newStr);
		System.out.println();
		if(len == 0)
			return false;
		else if(len == 1)
			return true;
		else /*indicates all other situations: length is odd and minimum is 3*/{
			for(int i = 0; i < len/2; i++){
				if(newStr.charAt(i) != newStr.charAt(len-i-1)){
					return false;
				}
				else 
					return true;
			}
		}
		/*Actually, no matter it's odd or even, there's no difference in dealing 
		 *with them.*/
		return false;
	}

	public static void main(String args[]){
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}