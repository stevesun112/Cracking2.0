
public class SinglyLinkedListNode {
	String data;
	SinglyLinkedListNode next = null;
	public SinglyLinkedListNode(String data){
		this.data = data;
	}
	public void appendToTail(String data){
		SinglyLinkedListNode end = new SinglyLinkedListNode(data);
		SinglyLinkedListNode temp = this;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = end;
	}
}
