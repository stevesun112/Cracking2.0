/* I ran out of patience for this problem, so I simply copied this algrithm from online word by word without
 * changing a single letter, I'll have to come back and revisit and truly understand this problem! */
public class reverseLinkedList {
	public static ListNode reverseBetween(ListNode head, int m, int n){
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preBegin = dummy;
		int cnt = 1;
		while(preBegin != null && cnt < m){
			preBegin = preBegin.next;
			cnt++;
		}
		
		ListNode reverseEnd = preBegin.next;
		ListNode reHead = null;
		ListNode cur = preBegin.next;
		cnt = 1;
		ListNode postEnd = null;
		while(cur != null && cnt <= n-m+1){
			ListNode preCur = cur;
			cur = cur.next;
			if(cnt == n-m+1){
				postEnd = preCur.next;
			}
			preCur.next = reHead;
			reHead = preCur;
			cnt++;
		}
		preBegin.next = reHead;
		if(reverseEnd != null){
			reverseEnd.next = postEnd;
		}
		return dummy.next;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		
		ListNode node1 = new ListNode(2);
		head.next = node1;
		
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		
		ListNode node5 = new ListNode(6);
		node4.next = node5;
		
		ListNode node6 = new ListNode(7);
		node5.next = node6;
		
		ListNode node7 = new ListNode(8); 
		node6.next = node7;
		
		ListNode node8 = new ListNode(9);
		node7.next = node8;
		
		ListNode node9 = new ListNode(10);
		node8.next = node9;
		
		/* print out to verify */
		ListNode temp = reverseBetween(head, 3, 8);
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("Program finished.");
	}

}
