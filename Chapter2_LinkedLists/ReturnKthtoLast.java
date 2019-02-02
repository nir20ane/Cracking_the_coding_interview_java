/* Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list. 
 * Approach:
 * Have fast and slow pointer, moving fast till k and moving both till fast != null
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package CTCILinked;

public class ReturnKthtoLast {
	
	private static Node head;
	
	public static Node returnkth(Node head, int k)
	{
		Node fast = head;
		Node slow = head;
		int i =0;
		while(i<=k)
		{
			fast = fast.next;  // move fast till K
			i++;
		}
		while(fast != null)
		{
			slow = slow.next;  // move and slow till fast is not null
			fast = fast.next;  // so that the difference between slow and fast is k nodes always
		}
		return slow.next;  // slow.next gives kth from last
	}

	public static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		ReturnKthtoLast l1 = new ReturnKthtoLast();
        l1.head = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(7);
        Node n5 = new Node(8);
        Node n6 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        System.out.println(returnkth(l1.head, 4).data);
	}
}
