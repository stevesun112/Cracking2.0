package ContinueCracking;
/*
 * Leetcode problem:
 * Given a binary tree, flatten it to a linked list in-place.
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
             6
 * */

public class FlattenBinaryTreeToLinkedList {

	/*Non-recursive solution from online: 
	 * http://yucoding.blogspot.com/2013/01/leetcode-question-30-flatten-binary.html
	 * 
	 * The flatten procedure is like:  cut the left child and set to right, 
	 * the right child is then linked to somewhere behind the left child. 
	 * Where should it be then?  Actually the right child should be linked to 
	 * the most-right node of the left node. So the algorithm is as follows:
(1) store the right child (we call R)
(2) find the right-most node of left child
(3) set R as the right-most node's right child.
(4) set left child as the right child
(5) set the left child NULL
(6) set current node to current node's right child.
(7) iterate these steps until all node are flattened. */
	
	public static void flatten (TreeNode root){
		while(root != null){
			if(root.left != null){
				TreeNode previousNode = root.left;
				while(previousNode.right != null){
					previousNode = previousNode.right;
				}
				previousNode.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
	
	public static void main (String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flatten(root);
		while(null != root){
			System.out.print(root.val);
			root = root.right;
		}
		System.out.println("\nProgram ended.");
	}
}
