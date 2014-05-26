/* I wrote this program all by myself, it can run any cases that I entered and produced the expected
 * correct result, but it got rejected on Leetcode because it exceeded time limit, I'm racking
 * my brains but couldn't figure out why. */

/*  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6 */
import java.util.*;
public class flattenBinaryTreeIntoLinkedList {
	public static void flatten(TreeNode root) {
		if(root == null){
			
		}
		else{
			Queue<TreeNode> ls = new LinkedList();
			ls = preorderTraversal(root);


			/* for the original tree, cut all the rest of the tree, only keep the root node */
			root.left = null;
			root.right = null;

			/* for the sorted queue, get rid of the root element */
			ls.remove();

			/* assign root to a temp, use temp to add all the elements in the queue as the right
			 * node for the original tree */
			TreeNode temp = root;
			while(ls.size() != 0){
				temp.right = ls.poll();
				temp = temp.right;
			}

			/* now assign the new root (leading a linkedlist) to another temp to print them out for testing */
			TreeNode temp2 = root;
			while(temp2 != null){
				System.out.print(temp2.val + " ");
				temp2 = temp2.right;
			}
		}
	}
	static Queue<TreeNode> list = new LinkedList();
	public static Queue<TreeNode> preorderTraversal(TreeNode root){/* return type is a queue(LinkedList)*/
		if(root == null){
			return list;
		}
		else{
			list.add(root);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return list;
	}
	public static void main(String args[]){
		System.out.println("Program started.");
		//		TreeNode root = new TreeNode(1);
		//		root.left = null;
		//		root.right = new TreeNode(2);
		//		root.right.right = null;
		//		root.right.left = new TreeNode(3);

		//			TreeNode root = new TreeNode(1);
		//			root.right = null;
		//			root.left = new TreeNode(2);

//		TreeNode root = null;

						TreeNode root = new TreeNode(1);
						root.right = new TreeNode(5);
						root.left = new TreeNode(2);
						root.left.left = new TreeNode(3);
						root.left.right = new TreeNode(4);
						root.right.left = new TreeNode(6);
						root.right.left.right = new TreeNode(7);
						root.right.left.right.left = new TreeNode(8);
						root.right.right = new TreeNode(9);
						root.right.right.left = new TreeNode(10);
						root.right.right.left.left = new TreeNode(11);
						root.right.right.left.right = new TreeNode(12);
						root.right.right.right = new TreeNode(13);
						root.right.right.right.right = new TreeNode(14);
						root.right.right.right.right.left = new TreeNode(15);
						root.right.right.right.right.left.left = new TreeNode(16);
						root.right.right.right.right.left.left.left = new TreeNode(17);
						root.right.right.right.right.left.right = new TreeNode(18);
						root.right.right.right.right.right = new TreeNode(19);
						
		//			TreeNode root = new TreeNode(1);
		//			root.left = null;
		//			root.right = new TreeNode(2);

		flatten(root);
		System.out.println();
		System.out.println("Program finished.");
	}
}
