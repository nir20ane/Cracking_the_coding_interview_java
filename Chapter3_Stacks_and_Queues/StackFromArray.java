/*Three in One: Describe how you could use a single array to implement three stacks. 
 * I have implemented three stacks of capacity 10 using four five methods
 * createlist() - created new stacknodes array
 * push(int stacknum, int value) - pushes value, checks for overflow, increments size, update top
 * pop(int stacknum, int index) - pops and returns Node, checks for underflow
 * greefreeindex() - gets current free index, updates index
 * freenode(int index) - deletes Node at a particular index decrements size
 */
package CCIstackqueue;

public class StackFromArray {
	StackNode[] stacknodes = null;
	int capacity = 10;
	int[] stackpointers = {-1, -1, -1};
	int size = 0;
	int freelisttopindex = 0;
	
	StackFromArray()
	{
		stacknodes = new StackNode[capacity];
		createlist();
	}
	
	public void createlist()
	{
		for(int i=0;i<capacity; i++)
		{
			stacknodes[i] = new StackNode(0, i+1);
		}
	}
	
	public void push(int stacknum, int value) throws Exception
	{
		int currstacktop;
		int indextopush;
		indextopush = greefreeindex();
		currstacktop = stackpointers[stacknum - 1];
		StackNode curr = stacknodes[indextopush];
		curr.value = value;
		curr.next = currstacktop;
		stackpointers[stacknum - 1] = indextopush;
	}
	
	public StackNode pop(int index, int stacknum) throws Exception
	{
		int currstacktop;
		currstacktop = stackpointers[stacknum - 1];
		if(currstacktop == -1) throw new Exception("UNDER FLOW");
		StackNode temp = stacknodes[currstacktop];
		stackpointers[stacknum - 1] = temp.next;
		freenode(currstacktop);
		return temp;
	}
	public int greefreeindex() throws Exception
	{
		int temp = freelisttopindex;
		if(size >= capacity)
		{
			throw new Exception("OVER FLOW");
		}
		freelisttopindex = stacknodes[temp].next;
		size++;
		return temp;
		
	}
	
	public void freenode(int index)
	{
		stacknodes[index].next = freelisttopindex;
		freelisttopindex = index;
		size--;
	}
	 public static void main(String args[]) {
         // Test Driver
		 StackFromArray mulStack = new StackFromArray();
		 try {
			 mulStack.push(1, 11);
			 mulStack.push(1, 12);
			 mulStack.push(2, 13);
			 mulStack.push(3, 31);
			 mulStack.push(3, 32);
			 mulStack.push(2, 22);
			 mulStack.push(1, 13);
			 StackNode node = mulStack.pop(2, 1);
			 System.out.println(node.value);
			 node = mulStack.pop(1, 2);
			 System.out.println(node.value);
			 mulStack.push(1, 13);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
}
}
