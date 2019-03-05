package ccistackqueue;

import java.util.Stack;

public class QueueViaStacks {
	
	Stack<Integer> oldest = new Stack<Integer>();
	Stack<Integer> newest = new Stack<Integer>();
	
	public void enqueue(int item)
	{
		newest.push(item); // push item into new stack
	}
	
	public int dequeue()
	{
		shiftstacks();
		int item = oldest.pop();  // get top element, first shift and then pop from oldest
		return item;
	}
	
	public void shiftstacks()
	{
		if(oldest.isEmpty())
		{
			while(!newest.isEmpty())
			{
				oldest.push(newest.pop());  // shift from new to old
			}
		}
	}
	
	public int peek()
	{
		shiftstacks();
		int item = oldest.peek();  // get top element, first shift and then peek from oldest
		return item;
	}
	public int size()
	{
		return oldest.size()+newest.size();
	}
	
	public static void main(String[] args) {
		QueueViaStacks myque = new QueueViaStacks();
		myque.enqueue(1);
		myque.enqueue(2);
		myque.enqueue(3);
		myque.enqueue(4);
		myque.enqueue(5);
		myque.enqueue(6);
		myque.enqueue(7);
		myque.enqueue(8);
		myque.enqueue(9);
		System.out.println(myque.dequeue());
		System.out.println(myque.dequeue());
		System.out.println(myque.dequeue());
		System.out.println(myque.size());
		System.out.println(myque.peek());
		System.out.println(myque.dequeue());
		}
}

