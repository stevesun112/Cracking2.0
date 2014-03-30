/* Leetcode doesn't have this one, but this should be "reverse linked list I".
 * 
 *  Given a linked list, e.g. 1->2->3->4->5, reverse it into 5->4->3->2->1. */

public class reverseLinkedListI {
	public static ListNode reverseRec(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode reHead = reverseRec(head.next);
		head.next.next = head;// this line of code always assigns the current node which "head" points to, to the last place
		head.next = null;// after assigning it into the last place, assign null to its next pointer to prevent circles from happening

		/* print out each step for testing */
//		ListNode temp = reHead;
//		while(temp != null){
//			System.out.print(temp.val + "->");
//			temp = temp.next;
//		}
//		System.out.println();

		return reHead;//this reHead is always the head of the new linkedlist
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);

		ListNode node1 = new ListNode(2);
		head.next = node1;

//		ListNode node2 = new ListNode(3);
//		node1.next = node2;
//
//		ListNode node3 = new ListNode(4);
//		node2.next = node3;

//		ListNode node4 = new ListNode(5);
//		node3.next = node4;
//
//		ListNode node5 = new ListNode(6);
//		node4.next = node5;
//
//		ListNode node6 = new ListNode(7);
//		node5.next = node6;
//
//		ListNode node7 = new ListNode(8);
//		node6.next = node7;
//
//		ListNode node8 = new ListNode(9);
//		node7.next = node8;
//
//		ListNode node9 = new ListNode(10);
//		node8.next = node9;

		ListNode temp = reverseRec(head);
		while(temp != null){
			System.out.print(temp.val + "->");
			temp = temp.next;
		}

		System.out.println("Program finished.");
	}
}
