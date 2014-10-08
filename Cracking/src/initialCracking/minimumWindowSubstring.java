/* I copied this algorithm from online and it's accepted on Leetcode.
 * It uses a very smart way to record the times that each char appear in S, basically using arrays which
 * utilize ASCII as their index! This is amazing! I am shocked again! */

/* For example,
S = “ADOBECODEBANC”
T = “ABC”
Minimum window is “BANC”.
Thoughts:
The idea is from here. I try to rephrase it a little bit here. The general idea is that we find a window first, not necessarily the minimum, but it’s the first one we could find, traveling from the beginning of S. We could easily do this by keeping a count of the target characters we have found. After finding an candidate solution, we try to optimize it. We do this by going forward in S and trying to see if we could replace the first character of our candidate. If we find one, we then find a new candidate and we update our knowledge about the minimum. We keep doing this until we reach the end of S. For the giving example:

We start with our very first window: “ADOBEC”, windowSize = 6. We now have “A”:1, “B”:1, “C”:1 （保存在needToFind数组里）
We skip the following character “ODE” since none of them is in our target T. We then see another “B” so we update “B”:2. Our candidate solution starts with an “A” so getting another “B” cannot make us a “trade”. （体现在代码就是只有满足hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) 才能移动左指针start）
We then see another “A” so we update “A”:2. Now we have two “A”s and we know we only need 1. If we keep the new position of this “A” and disregard the old one, we could move forward of our starting position of window. We move from A->D->O->B. Can we keep moving? Yes, since we know we have 2 “B”s so we can also disregard this one. So keep moving until we hit “C”: we only have 1 “C” so we have to stop. Therefore, we have a new candidate solution, “CODEBA”. Our new map is updated to “A”:1, “B”:1, “C”:1.
We skip the next “N” （这里忽略所有不在T的字符：用needToFind[S.charAt(start)] == 0来判断） and we arrive at “C”. Now we have two “C”s so we can move forward the starting position of last candidate: we move along this path C->O->D->E until we hit “B”. We only have one “B” so we have to stop. We have yet another new candidate, “BANC”.
We have hit the end of S so we just output our best candidate, which is “BANC”. */

public class minimumWindowSubstring {
	public static String minWindow(String S, String T) {  
        /* Because we're dealing with characters, so we can use ASCII to store characters */
        int[] needToFind = new int[256]; 
        /* Once this array is initialized, it won't be changed any more.*/
        
        int[] hasFound = new int[256];     
        /* This array is used to store the chars that are found, it will be changing dynamically. */  
        
        for(int i=0; i<T.length(); i++){//initialize this array  
            needToFind[T.charAt(i)]++;  // e.g. if T = "ABC", then needToFind[65]=1, nTF[66]=2, nTF[67]=3  
        }  
          
        int count = 0;      // this is used to test the first substring that contains T 
        int minWindowSize = Integer.MAX_VALUE;  
        int start = 0, end = 0;       
        String window = "";         
          
        for(; end<S.length(); end++){        
            if(needToFind[S.charAt(end)] == 0){ // this means all other characters that are not in T 
                continue;  
            }  
            char c = S.charAt(end);  
            hasFound[c]++;      // one char in T is found  
              
            if(hasFound[c] <= needToFind[c]){
                count++;  
            }  
            if(count == T.length()){    
                while(needToFind[S.charAt(start)] == 0 ||     
                        hasFound[S.charAt(start)] > needToFind[S.charAt(start)]){   
                    if(hasFound[S.charAt(start)] > needToFind[S.charAt(start)]){  
                        hasFound[S.charAt(start)]--;        
                    }  
                    start++;   
                }  
                  
                if(end-start+1 < minWindowSize){     
                    minWindowSize = end-start+1;  
                    window = S.substring(start, end+1);  
                }  
            }  
        }  
        return window; 
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
		
		String s = "aa";
		String t = "aa";
		
//		String s = "cabwefgewcwaefgcf";
//		String t = "cae";
		
		System.out.println(minWindow(s, t));
		System.out.println("Program finished.");
	}
}
