/*Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting. 
** Approach: get the length of lists, adjust length to be equal, compare to find intersection
* Time O(n); Space O(1)
*/
package CTCILinked;

public class IntersectionofLinkedList {
	private Node head;
	
	public static Node intersection(Node head1, Node head2)
	{
		int len1 = calclength(head1);
		int len2 = calclength(head2);  // calculate length of both lists
		while(len1 > len2)
		{
			head1 = head1.next;
			len1 -= 1;   // adjust lists based on length of nodes
		}
		while(len2 > len1)
		{
			head2 = head2.next; 
			len2 -= 1;  // adjust lists based on length of nodes
		}
		while(head1 != head2)
		{
			head1 = head1.next;
			head2 = head2.next;  // increment both until they are equal
		}
	    return head1;
	}
    
    public static int calclength(Node head)
    {
    	int i =0;
    	Node curr = head;
    	while(curr != null)
    	{
    		curr = curr.next;
    		i++;
    	}
    	return i;
    }
	
	public static class Node{  // class Node
		private int data;
		private Node next;
		Node(int data)
		{
			this.data = data;  // constructor Node
			this.next = null;
		}
	}
	public static void main(String[] args) {
		IntersectionofLinkedList l1 = new IntersectionofLinkedList();
		l1.head = new Node(3);
        Node n2 = new Node(1);
        Node n3 = new Node(5);
        Node n4 = new Node(9);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(7);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
		
        IntersectionofLinkedList l2 = new IntersectionofLinkedList();
        l2.head = new Node(4);
        Node n22 = new Node(6);
        l2.head.next = n22;
        n22.next = n5;
        Node n = l1.intersection(l1.head, l2.head);
        System.out.println(n.data);
	}
}
