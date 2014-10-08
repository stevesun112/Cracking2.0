package ContinueCracking;
/*As a warm-up for myself (basically copied my own previous code) to 
 * continue practicing coding questions 
 * after a long break, yeah! Keep coding! Enjoy the fun!*/

public class isPalindrome {
	public static boolean isPalindrome(String s) {
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
	public static void main (String args[]){
		System.out.println(isPalindrome("ssjhhjss") + "\nProgram ended.");
	}
}
