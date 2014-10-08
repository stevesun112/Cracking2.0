/* This is an unsuccessful program that fails to solve the desired problem, I'll implement
 * it in another class. */
import java.util.ArrayList;

/* Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. */

public class sumRootToLeafNumbersFollowUp {
	static ArrayList<Integer> a = new ArrayList();
	static int res = 0;
	public static int sumNumbers(TreeNode root) {
		if(root == null){
			return res;
		}
		else{
			a.add(root.val);
			sumNumbers(root.left);
			sumNumbers(root.right);
		}
		int oneRouteSum = 0;
		for(int i = 0; i < a.size(); i++){
			oneRouteSum += a.get(i)* (int)(Math.pow(10, a.size() - i - 1));
			System.out.println(Math.pow(10, a.size() - i - 1) + "\t" + a.get(i));
		}
		res += oneRouteSum;
		return res;
	}
	public static void main(String args[]){
//		TreeNode root = new TreeNode(1);
//		root.left = null;
//		root.right = new TreeNode(2);
//		root.right.right = null;
//		root.right.left = new TreeNode(3);

		//	TreeNode root = new TreeNode(1);
		//	root.right = null;
		//	root.left = new TreeNode(2);

					TreeNode root = new TreeNode(2);
					root.right = null;
					root.left = new TreeNode(3);
					root.left.left = null;
					root.left.right = new TreeNode(1);

		//			TreeNode root = new TreeNode(1);
		//			root.left = null;
		//			root.right = new TreeNode(2);

		System.out.println(sumNumbers(root));
		System.out.println("Program finished.");
	}
}
