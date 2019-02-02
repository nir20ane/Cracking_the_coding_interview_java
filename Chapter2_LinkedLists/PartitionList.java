/*Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions. 
* Approach: 
* have four pointers: beforehead, before, after, afterhead
* Time Complexity: O(N)
* Space Complexity: O(1)
*/
package CTCILinked;

public class PartitionList {
	private static Node head;
	
	public static Node makepartition(Node head, int x)
	{
		Node beforehead = new Node(0);  // create before=head and afterhead nodes
		Node before = beforehead;
		Node afterhead = new Node(0);
		Node after = afterhead;
		while(head != null)
		{
			if(head.data < x)
			{
				before.next = head;
				before = before.next;  // values < x, comes to before list
			}
			else
			{
				after.next = head;
				after = after.next;  // values > x, comes to after list
			}
			
			head = head.next;
		}
		after.next = null;
		before.next = afterhead;  // join two lists
		return beforehead.next;  // return before
		
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
		PartitionList l1 = new PartitionList();
        l1.head = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(5);
        Node n5 = new Node(10);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        Node part = l1.makepartition(l1.head,5);
        while(part != null)
        {
        	System.out.println(part.data);
        	part = part.next;
        }
	}
}
