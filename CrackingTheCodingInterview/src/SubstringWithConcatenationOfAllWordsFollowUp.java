import java.util.ArrayList;
import java.util.HashMap;
/* This code runs fairly well, although it's very lengthy.
 * But it gets rejected on Leetcode b/c it takes too long. 
 * So I'll write a new program from scratch to implement this problem! */

/* The trick here is not to use HashMap.containsValue() or HashMap.containsKey() methods,
 * because both methods run in O(n) time instead of O(1) time! 
 * What we should do is to use HashMap.get() method to take the value out and assign it into a temp
 * variable and then use this temp variable to run programs, since HashMap.get() runs O(1) time. */

/* You are given a string, S, and a list of words, 
 * L, that are all of the same length. 
 * Find all starting indices of substring(s) in S 
 * that is a concatenation of each word in L exactly 
 * once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). */

public class SubstringWithConcatenationOfAllWordsFollowUp {
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		long startTime = System.nanoTime();
		ArrayList<Integer> res = new ArrayList();
		if(L.length == 0){
			return res;
		}
		int wordLen = L[0].length();
		int i = 0;//used to count how many strings there are in this string array
		int wholeWordLen, counter = 0;
		if(L.length > 1){
 			for(i = 0; i < L.length; i++){
				//do nothing here
				System.out.println("i = " + i);
			}
			counter = i;
			wholeWordLen = wordLen * counter;//this is the length of all the words combined
		}
		else{//here it means there's only one element in the string array of L
			wholeWordLen = wordLen;
			counter = 1;
		}
		if(wholeWordLen > S.length()){
			return res;
		}

		HashMap<String, Integer> map = new HashMap();/*integer is used to indicate how many times
		this string appears in L. */
		for(int k = 0; k < L.length; k++){
			Integer val = map.get(L[k]);//here, you must declare the type of val to be "Integer", this wrapper class, b/c it contains "null"
			if(val == null){
				map.put(L[k], 1);
			}
			else{
				map.put(L[k], map.get(L[k]) + 1);
			}
		}
		/* make a copy here, before we contaminate "map", then inside this for loop, we
		 * don't need to "new" a HashMap every single time, this can SIGNIFICANTLY reduce
		 * the time costs because "new" requires memory management and consumes lots of time! */
		HashMap<String, Integer> original = new HashMap();
		/* although we define "original" to be of type HashMap<String, Integer>, but .clone() method
		 * is part of Object class, it's not overriden, so, after calling .clone(), we must cast Object
		 * back to HashMap<String, Integer> type! */
		original = (HashMap<String, Integer>) map.clone();
		
		for(int start = 0; start < S.length();){
			map.clear();
			map = (HashMap<String, Integer>) original.clone();
			System.out.println(map);
			System.out.println("counter = " + counter);
			
			if(wordLen == 1){
				if(S.length() == 1){
					if(S.equals(L[0])){
						res.add(0);
						return res;
					}
					else{
						return res;
					}
				}

				/* for all situations where wordLen is one and S.length is greater than one */
				int tempStart = start;
				System.out.println("start = " + start);
				while(tempStart < S.length() && ((tempStart + wordLen) < S.length())){
					Integer val0 = map.get(S.substring(tempStart, tempStart + wordLen));
					if(val0 != null){
						System.out.println("tempStart = " + tempStart);
						System.out.println("S.substring(tempStart, tempStart + wordLen) = " + S.substring(tempStart, tempStart + wordLen));
						while(val0 != null && !map.isEmpty()){
							if((val0) != 1){
								map.put(S.substring(tempStart, tempStart + wordLen), val0 - 1);
							}
							else{
								map.remove(S.substring(tempStart, tempStart + wordLen));
							}
							tempStart += wordLen;
							System.out.println("tempStart = " + tempStart + "\twordLen = " + wordLen + "\tS.length = " + S.length());
							if(tempStart + wordLen > S.length()){
								break;
							}
							else
								val0 = map.get(S.substring(tempStart, tempStart + wordLen));
						}
						System.out.println(map);
						if(map.isEmpty()){
							res.add(start);
							System.out.println("start = " + start);
							
							/* check if the String s is a string formed of ONE repeating char, if so, set the tempStart to the start + 1,
							 * if not, assign tempStart to start */
//							int q;
//							System.out.println("original.size() = " + original.size());
//							if(original.size() == 1){
//								wholeWordLen = wordLen;
//							}
//							else{
//								wholeWordLen = wordLen*original.size();
//								System.out.println("wholeWordLen = " + wholeWordLen);
//							}
//							System.out.println("S.length = " + S.length() + "\twholeWordLen = " + wholeWordLen);
//							for(q = 0; q <= S.length() - 2*wholeWordLen; q += wholeWordLen){
//								if(S.substring(q, q + wholeWordLen).equals(S.substring(q + wholeWordLen, q + 2*wholeWordLen))){
//									//do nothing
//									System.out.println("q = " + q + "\tq + wholeWordLen = " + (q + wholeWordLen));
//								}
//								else{
//									break;
//								}
//							}
//							System.out.println("q = " + q);
//							if(q == S.length() - wholeWordLen){/* this means are the chars in S are the same */
//								start += wholeWordLen;
//								tempStart = start;
//							}
//							else{
//							start = tempStart;
//							}
//							System.out.println("start = " + start);

							start++;
							tempStart = start;
							
							/* construct a new HashMap again to continue to check */
							map.clear();
							map = (HashMap<String, Integer>) original.clone();
							System.out.println(map);
						}
						else{
							tempStart = tempStart - wordLen;
							System.out.println("tempStart = " + tempStart);
							start = tempStart;
							/* here we also need to reconstruct a new HashMap to begin a new check */
							map.clear();//we must remove all elements in this USED HashMap to make it clean and then create a new one
							map = (HashMap<String, Integer>) original.clone();
							System.out.println(map);
						}
					}
					else{
						tempStart++;
						start++;
					}
				}
				System.out.println(map);
				if(map.isEmpty()){
					res.add(start);
					System.out.println("start = " + start);
					start = tempStart;
					System.out.println("start = " + start);
				}
				else{
					start += 1;
				}
			}
			else{/* for all situations where wordLen is greater than one */
				int tempStart = start;
				System.out.println("start = " + start);
				while(tempStart < S.length() && ((tempStart + wordLen) < S.length())){
					Integer val0 = map.get(S.substring(tempStart, tempStart + wordLen));
					if(val0 != null){
						System.out.println("tempStart = " + tempStart);
						System.out.println("S.substring(tempStart, tempStart + wordLen) = " + S.substring(tempStart, tempStart + wordLen));
						while(val0 != null && !map.isEmpty()){
							if((val0) != 1){
								map.put(S.substring(tempStart, tempStart + wordLen), val0 - 1);
							}
							else{
								map.remove(S.substring(tempStart, tempStart + wordLen));
							}
							tempStart += wordLen;
							System.out.println("tempStart = " + tempStart + "\twordLen = " + wordLen + "\tS.length = " + S.length());
							if(tempStart + wordLen > S.length()){
								break;
							}
							else
								val0 = map.get(S.substring(tempStart, tempStart + wordLen));
						}
						System.out.println(map);
						if(map.isEmpty()){
							res.add(start);
							System.out.println("start = " + start);
							start = tempStart;
							System.out.println("start = " + start);

							map.clear();
							map = (HashMap<String, Integer>) original.clone();
							System.out.println(map);
						}
						else{
							tempStart = tempStart - wordLen + 1;
							System.out.println("tempStart = " + tempStart);
							start = tempStart;
							/* here we also need to reconstruct a new HashMap to begin a new check */
							map.clear();//we must remove all elements in this USED HashMap to make it clean and then create a new one
							map = (HashMap<String, Integer>) original.clone();
							System.out.println(map);
						}
					}
					else{
						tempStart++;
						start++;
					}
				}
				System.out.println(map);
				if(map.isEmpty()){
					res.add(start);
					System.out.println("start = " + start);
					start = tempStart;
					System.out.println("start = " + start);
				}
				else{
					start += 1;
				}
			}
		}
		System.out.println("S.length() = " + S.length() + "\tcounter = " + counter);
		long endTime = System.nanoTime();
		System.out.println("Time elapse is: " + (endTime - startTime));
		return res;
	}
	public static void main(String args[]){
		//String s = "barfoothefoobarman";
		//String [] L = new String[]{"foo", "bar"};
//
//			String s = "aaaccccaab";
//				String [] L = new String[]{"cc", "cc"};

		//String s = "acaacc";
		//String [] L = new String[]{"ca", "ac"};

			//String s = "mississippi";
		//String [] L = new String[]{"si", "is"};

			//String s = "mississippi";
		//	String [] L = new String[]{"is"};

//		 String s = "aaa";
//		String [] L = new String[]{"a", "b"};

//		String s = "aaa";
//		String [] L = new String[]{"a", "a"};

//				String s = "a";
//				String [] L = new String[]{"a"};
				

//		String s = "abababab";
//		String [] L = new String[]{"a", "b"};
		
//		String s = "cccbcacaa";
//		String [] L = new Strin[]{"cc", "bc"};
		
//		String s = "abababab";
//	String [] L = new String[]{"a", "b", "a"};
		
		/* The following string "s" cannot be seen, but it's actually there, this is a test case from Leetcode,
		 * but program can get the correct result, but it just takes too long and exceeded the time
		 * limit on Leetcode! */
				String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
	  	String L [] = new String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};		

		System.out.println("s.length() = " + s.length());
		System.out.println(findSubstring(s, L));
		System.out.println("Program finished.");
	}
}
