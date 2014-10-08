/* I was going to steal the algorithm from Permuations.java and use HashSet in the end
 * to filter the duplicates, but it didn't get accepted, because it's too time-consuming.
 * 
 * Xi Huang said, "this is obviously a DFS problem, you can use HashSet to trim the DFS code in order
 * to get rid of the duplicates
 * 
 * I'll write a new program instead and name this one FollowUp. */


/* Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. */

import java.util.*;
public class PermutationsIIFollowUp {
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if(len == 0){
			return res;
		}
		else if(len == 1){
			ArrayList<Integer> newPerm1 = new ArrayList<Integer>();
			newPerm1.add(num[0]);
			res.add(newPerm1);
			return res;
		}
		else if(len == 2){
			if(num[0] != num[1]){
				ArrayList<Integer> newPerm1 = new ArrayList<Integer>();
				newPerm1.add(num[0]);
				newPerm1.add(num[1]);
				res.add(newPerm1);

				ArrayList<Integer> newPerm2 = new ArrayList<Integer>();
				newPerm2.add(num[1]);
				newPerm2.add(num[0]);
				res.add(newPerm2);

				return res;
			}
			else{
				ArrayList<Integer> newPerm1 = new ArrayList<Integer>();
				newPerm1.add(num[0]);
				newPerm1.add(num[1]);
				res.add(newPerm1);
				return res;
			}
		}
		else{
			Arrays.sort(num);
			ArrayList<Integer> newPerm1 = new ArrayList<Integer>();
			newPerm1.add(num[0]);
			newPerm1.add(num[1]);
			res.add(newPerm1);

			ArrayList<Integer> newPerm2 = new ArrayList<Integer>();
			newPerm2.add(num[1]);
			newPerm2.add(num[0]);
			res.add(newPerm2);

			for(int i = 2; i < len; i++){
				int tempSize = res.size();
				for(int j = 0; j < tempSize; j++){
					ArrayList<ArrayList<Integer>> newPerm = new ArrayList<ArrayList<Integer>>();
					newPerm = insertNumber(res.get(0), num[i]);
					res.remove(0);
					res.addAll(new ArrayList<ArrayList<Integer>>(newPerm));
				}
			}
		}
		System.out.println(res.size());
		
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		for(int i = 0; i < res.size(); i++){
			set.add(res.get(i));
		}
		res.clear();
		Iterator it = set.iterator();
		while(it.hasNext()){
			res.add((ArrayList<Integer>) it.next());
		}
		System.out.println(res.size());
		return res;
	}
	public static ArrayList<ArrayList<Integer>> insertNumber(ArrayList<Integer> a, int number){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int pos = 0; pos <= a.size(); pos++){
			ArrayList<Integer> newPerm = new ArrayList<Integer>();
			int i;
			for(i = 0; i < a.size(); i++){
				if(i != pos){
					newPerm.add(a.get(i));
				}
				else{
					newPerm.add(number);
					newPerm.add(a.get(i));
				}
			}
			if(pos == i){//this is for the last case when "number" should be inserted at the end position
				//all other cases won't execute this code
				newPerm.add(number);
			}
			res.add(newPerm);
		}
		return res;
	}
	public static void main(String args[]){
		//		ArrayList<Integer> a = new ArrayList<Integer>();
		//		a.add(1);
		//		a.add(2);
		//		a.add(3);
		//		a.add(5);
		//		System.out.println(insertNumber(a, 4));
		long start = System.currentTimeMillis();
		int[] num = new int[]{3, 3, 0, 0, 2, 3, 2};
		System.out.println(permuteUnique(num));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("Program finished.");
	}
}
