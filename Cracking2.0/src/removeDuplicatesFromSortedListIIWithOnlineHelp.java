/* In the previous program, I tried to code this out all by myself, but still,
 * I failed, so I got this program from converting a C++ program online. */

public class removeDuplicatesFromSortedListIIWithOnlineHelp {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		/* We construct a node called myHead, set it in front of the very first node, because even
		 * the first node is possible to be a duplicate and therefore needs to be deleted. */
		ListNode myHead = new ListNode(Integer.MIN_VALUE);
		myHead.next = head;
		/* Then we set two pointers, pre and now to traverse this linked list. */
		ListNode pre = myHead, now = head;
		while(now != null && now.next != null){
			if(now.val == now.next.val){
				while(now.next != null && now.val == now.next.val){
					now = now.next;
				}
				pre.next = now.next;
				now = now.next;
			}
			else{
				pre = now;
				now = now.next;
			}
		}

		/* The following statement is very important, it gets rid of the initial value we put
		 * in the myHead.val. */
		head = myHead.next;

		System.out.print("\nThe final linked list is: ");
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		return head;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);

		ListNode node1 = new ListNode(1);
		head.next = node1;

//		ListNode node2 = new ListNode(3);
//		node1.next = node2;
//
//		ListNode node3 = new ListNode(3);
//		node2.next = node3;
//
//		ListNode node4 = new ListNode(3);
//		node3.next = node4;
//
//		ListNode node5 = new ListNode(3);
//		node4.next = node5;
//
//		ListNode node6 = new ListNode(3);
//		node5.next = node6;
//
//		ListNode node7 = new ListNode(4);
//		node6.next = node7;
//
//		ListNode node8 = new ListNode(5);
//		node7.next = node8;
//
//		ListNode node9 = new ListNode(5);
//		node8.next = node9;
//
//		ListNode node10 = new ListNode(6);
//		node9.next = node10;

		ListNode temp = head;
		System.out.print("The input linked list is: ");
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();
		deleteDuplicates(head);
		System.out.println("\nProgram finished");
	}
}
