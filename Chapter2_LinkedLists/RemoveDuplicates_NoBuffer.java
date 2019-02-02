package CTCILinked;
import java.util.HashSet;
/*Remove Dups: Write code to remove duplicates from an unsorted linked list.
How would you solve this problem if a temporary buffer is not allowed? 
Approach: No Extra Space is allowed, for every node, have runner and check for duplicates
Time COmplexity: O(n^2)
Space COmplexity: O(1)
*/

public class RemoveDuplicates_NoBuffer {
    private static Node head;
    
    public static Node removedups(Node head)
    {
    	
    	Node curr = head;
    	while(curr != null)
    	{
    		Node runner = curr;
    		while(runner.next != null)
    		{
    			if(runner.next.data == curr.data)
    			{
    				runner.next = runner.next.next;  // remove dup by increment runner if a duplicate is found
    			}
    			else
    			{
    				runner = runner.next;  // increment runner to point to next
    			}
    		}

    		curr = curr.next;
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
		RemoveDuplicates_NoBuffer l1 = new RemoveDuplicates_NoBuffer();
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