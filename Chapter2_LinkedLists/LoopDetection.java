/*Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input:
Output:
SOLUTION
A -> B -> C -> D -> E -> C [the same C as earlier]
C 
** Approach: Use fast and and slow runners, have while for slow != fast
* Time Complexity: O(N)
* Space Complexity: O(1)
*/
package CTCILinked;

public class LoopDetection {

	private Node head;
	
	public  boolean loopdetect(Node head)
	{
		if(head == null || head.next == null) return false;
		Node fast = head.next;
		Node slow = head;
		
		while(slow != fast)
		{
			if(fast == null || fast.next == null) return false;  // when slow is equal to fast, return true
			fast = fast.next.next;
			slow = slow.next;
		}
		return true;
	}
	public static class Node
	{
		private char data;
		private Node next;
		
	    Node(char data)
	    {
	    	this.data = data;
	    	this.next = null;
	    }
	}
	public static void main(String[] args) {
		LoopDetection l1 = new LoopDetection();
        l1.head = new Node('A');
        Node n2 = new Node('B');
        Node n3 = new Node('C');
        Node n4 = new Node('D');
        Node n5 = new Node('E');
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        System.out.println(l1.loopdetect(l1.head));
	}
}
