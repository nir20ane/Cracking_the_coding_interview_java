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
	}
	
	public void createlist()
	{
		for(int i=0;i<=capacity; i++)
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
	
	public StackNode pop(int stacknum, int index) throws Exception
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
		size --;
	}
	 public static void main(String args[]) {
         // Test Driver
		 StackMFromArray1 mulStack = new StackMFromArray1();
		 try {
			 mulStack.push(1, 11);
			 mulStack.push(1, 12);
			 mulStack.push(2, 21);
			 mulStack.push(3, 31);
			 mulStack.push(3, 32);
			 mulStack.push(2, 22);
			 mulStack.push(1, 13);
			 StackNode1 node = mulStack.pop(1);
			 System.out.println(node.value);
			 node = mulStack.pop(1);
			 System.out.println(node.value);
			 mulStack.push(1, 13);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
}
}
