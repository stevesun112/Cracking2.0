/* I was trying to implement the algorithm inspired from online, but I used HashMap,
 * everything works fine, it's just not efficient enough, it's not accepted because it
 * exceeded time limit, so I'll just copy the online algorithm in a new class. */

/* Given a string S and a string T, 
 * find the minimum window in S which will contain 
 * all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, 
return the empty string "".

If there are multiple such windows, you are guaranteed that 
there will always be only one unique minimum window in S. */

import java.util.*;
public class minimumWindowSubstringFollowUp {
	public static String minWindow(String S, String T) {
		int start = 0;//used as an index to keep track of the starting position of the current substring
		int end;
		/* first we construct this hashtable for target string T */
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
		for(int i = 0; i < T.length(); i++){
			Integer count = table.get(T.charAt(i));
			if(count != null){
				table.put(T.charAt(i), table.get(T.charAt(i))+1);
			}
			else{
				table.put(T.charAt(i), 1);
			}
		}
		
		String res = "";
		int len = 0;
		
		/* let's first find the very first substring that contains all characters of T, no matter how long it is */
		Hashtable<Character, Integer> temp = new Hashtable(table);
		int i = 0;
		/* we use this queue to store the indices of all chars in T in the current substring */
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		for(;!temp.isEmpty() && i < S.length(); i++){
			if(temp.containsKey(S.charAt(i))){
				while((i+1) < S.length() && temp.get(S.charAt(i)) == 1 && S.charAt(i) == S.charAt(i+1)){
					i++;
				}
				if(count == 0){
					
					start = i;
				}
				count++;
				q.add(i);
				if(temp.get(S.charAt(i)) != 1){
					temp.put(S.charAt(i), temp.get(S.charAt(i))-1);
				}
				else{
					temp.remove(S.charAt(i));
				}
			}
		}
		if(temp.isEmpty()){
			 end = i-1;
		}
		else{
			return "";
		}
		/* if there's the following case, then that means this is already the best solution, so we return directly. */
		if(end - start + 1 == T.length()){
			return S.substring(start, end+1);
		}
		else{
			res = S.substring(start, end+1);
			len = res.length();
		}
		
		/* now we start to traverse the rest of the string */
		Hashtable<Character, Integer> temp2 = new Hashtable(table);
		for(int k = end + 1; k < S.length(); k++){
			if(temp2.containsKey(S.charAt(k))){
				end = k;
				q.add(k);
				if(S.charAt(k) == S.charAt(q.peek())){
					q.remove();
					start = q.peek();
				}
				else{
					temp2.put(S.charAt(k), temp2.get(S.charAt(k))+1);
				}
				
				while(temp2.get(S.charAt(start)) > table.get(S.charAt(start))){
					q.remove();
					temp2.put(S.charAt(start), temp2.get(S.charAt(start))-1);
					start = q.peek();
				}
				
				if(len == T.length()){
					return res;
				}
				else if(len > S.substring(start, end+1).length()){
					res = S.substring(start, end+1);
					len = res.length();
				}
			}
		}
		return res;
	}
	public static void main(String args[]){
//		String s = "ADOBECODEBANC";
//		String t = "ABC";
		
//		String s = "ADOBECODEBANAJHABDDC";
//		String t = "ABCD";
		
//		String s = "A";
//		String t = "AA";
		
//		String s = "baBBba";
//		String t = "aB";
		
//		String s = "bba";
//		String t = "ab";
		
//		String s = "aa";
//		String t = "aa";
		
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		
		System.out.println(minWindow(s, t));
		System.out.println("Program finished.");
	}
}
