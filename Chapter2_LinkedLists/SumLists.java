/*Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
*/
package CTCILinked;

public class SumLists {
	
	private Node head;
	
	public static Node sumlists(Node head1, Node head2)
	{
		Node dummy = new Node(0);
		Node p = head1;
		Node q = head2;
		int carry = 0;
		int sum = 0;
		Node curr = dummy;
		while(p != null || q != null)
		{
			int x,y;
			if(p != null) x = p.data;
			else x = 0;
			if(q != null) y = q.data;
			else y = 0;
			sum = x + y + carry;
			carry = sum/10;
			curr.next = new Node(sum%10); 
			curr = curr.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(carry>0)
		{
			curr.next = new Node(carry);
		}
		while(dummy.next != null) 
		{
			System.out.println(dummy.next.data);
			dummy.next = dummy.next.next;
		}
		return dummy.next;
	}
	
	public static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		SumLists a = new SumLists();
		SumLists l1 = new SumLists();
		l1.head = new Node(7);
        	Node n2 = new Node(1);
        	Node n3 = new Node(6);
        	l1.head.next = n2;
        	n2.next = n3;
        	n3.next = null;

        	SumLists l2 = new SumLists();
        	l2.head = new Node(5);
        	Node n22 = new Node(9);
        	Node n23 = new Node(2);
        	l2.head.next = n22;
        	n22.next = n23;
        	n23.next = null;
        	a.sumlists(l1.head, l2.head);
	}
}
