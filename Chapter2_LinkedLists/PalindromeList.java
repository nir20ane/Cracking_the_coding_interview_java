/* Palindrome: Implement a function to check if a linked list is a palindrome. 
** Approach: get middle of list, and then reverse one half, then compare the nodes
* Time - O(n); Space - O(1)
*/
package CTCILinked;

public class PalindromeList {
	private Node head;
	
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
    public boolean palindrome(Node head)
    {
        Node fast = head;
        Node slow = head;
        Node l1 = head;
        while(fast != null && fast.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if(fast != null)
        {
        	slow = slow.next;  // find middle of linked list
        }
        Node l2 = reverse(slow);  // reverse from middle to end
        while(l2 != null)
        {
        	if(l1.data != l2.data) return false;  // compare Nodes from both sides
        	l1 = l1.next;
        	l2 = l2.next;
        }
		return true;  // return true if same
    }
    
    public Node reverse(Node head) {
    	
    	Node prev = null;
    	Node next = null;
    	Node curr = head;
    	while(curr != null)
    	{
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
		return prev;
    }
    
    public static void main(String[] args) {
    	PalindromeList l1 = new PalindromeList();
        l1.head = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(0);
        l1.head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        System.out.println(l1.palindrome(l1.head));
	}
}
