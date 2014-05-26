import java.util.ArrayList;

/* Given an array of words and a length L, format the text such 
 * that each line has exactly L characters and is fully (left and right) justified. 
 * You should pack your words in a greedy approach; 
 * that is, pack as many words as you can in each line. Pad extra spaces ' ' 
 * when necessary so that each line has exactly L characters. 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right. 
 * For the last line of text, it should be left justified and 
 * no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length. */

public class textJustification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		for(int k = 0; k < words.length; k++){
			System.out.print(words[k] + " ");
		}
		System.out.println("words.length = " + words.length);
		ArrayList<String> res = new ArrayList();
		if(words.length == 0 && L == 0){
			return res;
		}
		else if(words.length == 1 && words[0] == ""){
			String s = "";
			while(L != 0){
				s += " ";
				L--;
			}
			System.out.println("s.length() = " + s.length());
			res.add(s);
			return res;
		}
		int len = words.length;
		int lineLen = 0;
		int i = 0;
		for(; i < len; ){
			lineLen = 0;
			int spaces = -1;
			/* initialize the variable "spaces" to -1, because one string forms
			 * zero spaces, two strings form one space, three strings form two spaces, etc. */
			System.out.println("i = " + i);
			int tempi = i;
			while(lineLen <= L){ 
				lineLen += words[i].length() + 1;// is means the space between every string
				i++;
				spaces++;
				System.out.println("inside while lineLen = " + lineLen + "\ti = " + i);
			}
			/* when it jumps out of the while loop, we need to get rid of the last string that gets
			 * added to it to get the correct number of strings that should be lined up in this line. */
			i--;
			spaces--;
			lineLen = lineLen - (words[i].length() + 1) - 1;
			/* subtract one in the end of the above statement to get rid of the space after the last
			 * string, because the last string in each line doesn't need one space after it. */
			System.out.println("lineLen = " + lineLen + "\ti = " + i + "\tspaces = " + spaces);

			/* Now we need to consider how to average the spaces in between the strings in one line */
			int aveSpaces = (L - lineLen + spaces)/spaces;
			int tempaveSpaces = aveSpaces;
			System.out.println("aveSpaces = " + aveSpaces);
			String s = "";
			/* consider the situation when aveSpaces is not a precise number because Java truncates
			 * the fractional part */
			if(aveSpaces * spaces == L - lineLen + spaces){
				for(int j = tempi; j < i; j++){
					s += words[j];
					tempaveSpaces = aveSpaces;
					if(j + 1 == i){
						break;
					}
					while(tempaveSpaces != 0){
						s += " ";
						tempaveSpaces--;
					}
				}
			}
			else{
				int remainder = (L - lineLen + spaces) - (aveSpaces*spaces);
				System.out.println("remainder = " + remainder);
				int j = tempi;
				
					for(; j < i && remainder != 0; j++){
						s += words[j];
						tempaveSpaces = aveSpaces + 1;
						if(j + 1 == i){
							break;
						}
						while(tempaveSpaces != 0){
							s += " ";
							tempaveSpaces--;
						}
						remainder--;
					}	
				
				for(; j < i; j++){
					s += words[j];
					tempaveSpaces = aveSpaces;
					if(j + 1 == i){
						break;
					}
					while(tempaveSpaces != 0){
						s += " ";
						tempaveSpaces--;
					}
				}
			}
			System.out.println("s = " + s + "\ts.length() = " + s.length());
			res.add(s);

			if(i + 1 == len){
				break;
			}
		}

		/* here we need to deal with the last line situation. */
		lineLen -= 1;
		int padSpaces = L - lineLen;
		String s = words[i];
		while(padSpaces != 0){
			s += " ";
			padSpaces--;
		}
		System.out.println("s = " + s + "\ts.length() = " + s.length());
		res.add(s);
		return res;
	}
	public static void main(String args[]){
		//String [] s = {"This", "is", "an", "example", "of", "text", "justification."};
		String [] s = {"a"};
		System.out.println(fullJustify(s, 2));
	}
}
