/* Internet said this is a dp problem, I didn't code it out. */

/* Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. */
public class interleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()){
			return false;
		}
		else{
			char [] c1 = s1.toCharArray();
			char [] c2 = s2.toCharArray();
			char [] c3 = s3.toCharArray();
			int i = 0, j = 0, k = 0;
			while(k < c3.length){
				
			}
			
			
			return true;
		}
	}
	public static void main(String args[]){
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
//		String s3 = "aadbbbaccc";
	System.out.println(isInterleave(s1, s2, s3));
	System.out.println("Program finished.");
	}
}
