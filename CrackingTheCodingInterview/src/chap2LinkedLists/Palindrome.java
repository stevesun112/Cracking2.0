/*Check if a string is palindrome, for example "abcba", "abcccba* are
 * both palindrome.*/
/*This is the more difficult version: the input is the head of a singly
 * linked list, each node contains one character of this to be checked string.*/

/*For this problem, we use hare and tortoise algorithm to solve it.
 *Set two pointers: slow and fast.*/
public class Palindrome {

	
	public static boolean isPalindrome(LinkedListNode head){


		return false;
	}

	public static void main(String args[]){
		LinkedListNode head = new LinkedListNode('a');
		head.add('b');
		head.add('c');
		head.add('d');
		head.add('e');
		LinkedListNode temp = head;
		while(temp != null)
		{
		System.out.println(temp.value);
		temp = temp.next;
		}
		//System.out.println(isPalindrome(head));
	}
}
