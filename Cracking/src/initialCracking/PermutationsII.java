/* Xi Huang said, this is definitely a DFS problem, so I'll use DFS to resolve this problem, combing with
 * a HashSet inside the DFS to get rid of the duplicates. */

import java.util.ArrayList;


public class PermutationsII {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
	}
	public static void main(String args[]){
		//		ArrayList<Integer> a = new ArrayList<Integer>();
		//		a.add(1);
		//		a.add(2);
		//		a.add(3);
		//		a.add(5);
		//		System.out.println(insertNumber(a, 4));
		int[] num = new int[]{3, 3, 0, 0, 2, 3, 2};
		System.out.println(permuteUnique(num));
		System.out.println("Program finished.");
	}
}
