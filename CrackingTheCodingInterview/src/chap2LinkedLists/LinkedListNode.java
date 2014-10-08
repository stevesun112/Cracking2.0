

public class LinkedListNode{
		LinkedListNode next;
		char value;
		public LinkedListNode(char value){
			this.value = value;
			this.next = null;
		}
		public void add(char value){
			LinkedListNode temp = this;
			while(temp.next != null){
			temp = temp.next;
			}
			temp.value = value;
		}
	}
