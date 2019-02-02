/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d->e->f 
** Approach: if given node is null or last node return false, else delete node and return true
* Time Complexity: O(1)
* Space Complexity: O(1)
*/
package CTCILinked;


public class DeleteMiddleNode {
	private static Node head;
	
	public static boolean deletemiddle(Node n)
	{
		if(n == null || n.next == null) return false;  // if node is null or last node return false
		n.data = n.next.data;
		n.next = n.next.next;  // else remove the node, return true
		return true;
	}
	
    public static class Node  // class Node
    {
	    private int data;
	    private Node next;
        Node(int data)  // constructor
        {
        	this.data = data;
        	this.next = null;
        }
    }

	public static void main(String[] args) {
		DeleteMiddleNode l1 = new DeleteMiddleNode();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(l1.deletemiddle(l1.head.next.next));
	}
}
