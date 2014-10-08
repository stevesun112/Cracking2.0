/* Leetcode:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/

/* This is a problem that I solved before, but in order to cater to Leetcode submission
 * requirements, but this one is not efficient enough, rejected on Leetcode because exceeded
 * time limit, so I wrote Palindrome2.java */

/* I coded this out out alone again! And finally it passed the time constraint on Leetcode and
 * got accepted! I was to the brink of desperation a couple times but eventually made it there!
 * 
 * It took me quite a while to organize this logic straight after frustrating debugging line by line. */

public class Palindrome2 {

	public static boolean isPalindrome(String s){
		int len = s.length();
		char tempi, tempj;
		int i = 0, j = len-1;
		if(len == 0 || len == 1 )
			return true;
		else /*indicates all other situations: length is even, odd and minimum is 3*/{
			while(i < j){
				if(s.charAt(i) != s.charAt(j)){
					if(Character.isLetterOrDigit(s.charAt(i))){
						if(Character.isLetterOrDigit(s.charAt(j))){
							if(s.charAt(i) != s.charAt(j)){
								if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A'){
									tempi = Character.toLowerCase(s.charAt(i));
									if(tempi != s.charAt(j)){
										tempj = Character.toLowerCase(s.charAt(j));
										if(tempi != tempj){
											return false;
										}
									}
									else {
										i++;
										j--;
									}
								}
								else if(s.charAt(i) == Character.toLowerCase(s.charAt(j))){
									i++;j--;
								}
								else
									return false;
							}
						}
						else j--;
					}
					else i++;
				}
				else{
					i++; 
					j--;
				}

			}
		}
		/*Actually, no matter it's odd or even, there's no difference in dealing 
		 *with them.*/
		return true;
	}
	public static void main(String args[]){
		String s = "12 ,!@A man, a plan,   ?!     a canal: Panama21";
		System.out.println(isPalindrome(s));
	}
}