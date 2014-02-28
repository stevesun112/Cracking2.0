/* I copied this program from online, it's DFS, but I'm still processing it, not fully understood it. */
/* Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] */
import java.util.*;
public class subsetsDfsVersion {
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(temp);
		dfs(res, temp, S, 0);
		return res;
	}
	public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int [] S, int pos){
		for(int i = pos; i <= S.length-1; i++){
			temp.add(S[i]);
			res.add(new ArrayList<Integer>(temp));
			System.out.println("Place 1");
			dfs(res, temp, S, i+1);
			temp.remove(temp.size()-1);
			System.out.println("Place 2");
		}
	}
	public static void main(String args[]){
		int [] S = new int[]{1, 2, 3};
//		int [] S= new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
		System.out.println(subsets(S));
		System.out.println("Program finished.");
	}
}
