import java.util.*;
public class partitionList {
	public static ListNode partition(ListNode head, int x){
		if(head == null){
			return head;
		}
		else{
			ListNode bigEqual;/*use this ListNode as a header node to temporarily store all
			all nodes that are greater than or equal x until the end of the traversal,
			then append "temp" to the end of the other list which contains all nodes 
			that are smaller than the x */
			ListNode small;/* use this node to store all nodes that are smaller than the x */
			bigEqual = head;
			small = head;
			/* bigEqual and small must be initialized, although it doesn't make sense to do this here */
			
			ListNode smallNext, bigEqualNext;
			if(head.val >= x){/*if the first element is greater than or equal x, then assign
			cur to temp, otherwise go to else */ 
				bigEqual = head;
				bigEqualNext = head.next;

				while(bigEqualNext != null){
					if(bigEqual.val >= x){
						bigEqualNext = bigEqual.next;
					}
					else{
						small = bigEqual;
						smallNext = small.next;
						//break;
						while(smallNext != null){
							if(small.val < x){
								smallNext = small.next;
							}
							else{
								bigEqual = small;
								bigEqualNext = bigEqual.next;
								break;
							}
						}
					}
				}
				small.next = bigEqual;
				head = small;
			}
			else{/* if the first element is smaller than x, execute the else statement,
			traverse the list, until finds the element that is greater than or equal to x */
				small = head;
				smallNext = small.next;
				while(smallNext != null){
					if(small.val < x){
						smallNext = small.next;
					}
					else{
						bigEqual = small;
						bigEqualNext = bigEqual.next;
						while(bigEqualNext != null){
							if(bigEqual.val >= x){
								bigEqualNext = bigEqual.next;
							}
							else{
								small = bigEqual;
								smallNext = small.next;
								break;
							}
						}
					}
				}
				small.next = bigEqual;
				head = small;
			}
		}
		return head;
	}
	public static void main(String args[]){
		ListNode head = new ListNode(1);

		ListNode node1 = new ListNode(4);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		ListNode node3 = new ListNode(2);
		node2.next = node3;

		ListNode node4 = new ListNode(5);
		node3.next = node4;

		ListNode node5 = new ListNode(2);
		node4.next = node5;

		while( head!= null){
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println(partition(head, 3));
	}
}
