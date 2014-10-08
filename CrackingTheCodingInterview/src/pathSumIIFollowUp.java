/* This is a failed program, I implemented it from scratch, but it falls into indefinite loop,
 * this is my attempts to try to master DFS. 
 * After consulting Xi Huang, I decide to write a completely new program, so rename this
 * program as FollowUp. */

/* Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.

For example:

Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
] 
 */

import java.util.ArrayList;
public class pathSumIIFollowUp {
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		ArrayList<Integer> a = new ArrayList<Integer>();
		return res = recurs(root, 0, a, sum);
	}
	
	static ArrayList<ArrayList<Integer>> res = new ArrayList();
	public static ArrayList<ArrayList<Integer>> recurs(TreeNode root, int n, ArrayList<Integer> a, int sum){

		a.add(root.val);
		System.out.println("a:" + a);
		n += root.val;
		System.out.println("n = " + n);
		if(root.left != null){
			recurs(root.left, n, a, sum);
		}
		if(root.right != null){
			recurs(root.right, n, a, sum);
		}
		if(root.left == null && root.right == null){
			if(n == sum){
				res.add(a);
			}
			a.remove(a.size()-1);
			n -= root.val;
			recurs(root, n, a, sum);
		}
		return res;
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root, 22));
	}
}
