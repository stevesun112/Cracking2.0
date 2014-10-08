/*This is the easy version of checking a palindrome, the input is just
 *a string of characters.*/

public class easyVersionPalindrome {

	public static boolean isPalindrome(String s){
		if(s.length() == 0)
			return false;
		else if(s.length() == 1)
			return true;
		else if(s.length()/2 == 0)/*this means there are even numbers of chars*/{
			for(int i = 0; i < s.length()/2; i++){
				if(s.charAt(i) != s.charAt(s.length()-i-1)){
					return false;
				}
				else 
					return true;
			}
		}
		else /*indicates all other situations: length is odd and minimum is 3*/{
			for(int i = 0; i < s.length()/2; i++){
				if(s.charAt(i) != s.charAt(s.length()-i-1)){
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
		String s = "aaabbbaaa";
		System.out.println(isPalindrome(s));
	}
}
