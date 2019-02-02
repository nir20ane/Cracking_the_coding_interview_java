package CTCILinked;
import java.util.HashSet;
/*Remove Dups: Write code to remove duplicates from an unsorted linked list.
How would you solve this problem if a temporary buffer is not allowed? 
Approach: Extra Space is allowed, use a set to add Ndes
Time COmplexity: O(n)
Space COmplexity: O(n)
*/

public class RemoveDuplicates {
    private static Node head;
    
    public static Node removedups(Node head)
    {
    	HashSet<Integer> nodeset = new HashSet<Integer>();
    	
    	Node curr = head;
    	Node prev = null;
    	while(curr != null)
    	{
    		if(nodeset.contains(curr.data))
    		{
    			prev.next = curr.next;  // if Node in set, in increment prev to skip Node
    		}
    		else
    		{
    			nodeset.add(curr.data);  // add Node to set, if node not in set
    			prev = curr;
    		}
    		curr = curr.next;  // increment curr
    	}
    	return head;
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
		RemoveDuplicates l1 = new RemoveDuplicates();
        l1.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(4);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node remdup = l1.removedups(l1.head);
        while(remdup != null)
        {
        	System.out.println(remdup.data);
        	remdup = remdup.next;
        }
	}
}
