/* Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific substack. 
*/
package ccistackqueue;

import java.util.LinkedList;
import java.util.Stack;

public class StackofPlates {
	
    LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();
    int stack_size = 3;
    
    public void push(int item)
    {
    	if(stacks.isEmpty() || stacks.getLast().size() >= stack_size)  // if linked list is empty or last stack is empty
    	{
    		Stack<Integer> stack = new Stack<Integer>(); // create new stack and push item
    		stack.push(item);
    		stacks.add(stack);
    	}
    	else
    	{
    		stacks.getLast().push(item); // push into last stack in linked list
    	}
    }
    
    public int pop()
    {
    	if(stacks.isEmpty())
    	{
    		throw new IllegalStateException("Stacks are Empty");
    	}
    	else
    	{
    		Stack<Integer> last = stacks.getLast();  // get last stack and pop item
    		int item = last.pop();
    		if(last.isEmpty())
    		{
    			stacks.removeLast();  // remove last stack from ll if last stack is empty
    		}
    		return item;
    	}
    }
    
    public int popAt(int index)
    {
    	if(stacks.isEmpty())
    	{
    		throw new IllegalStateException();  // validate stacks
    	}
    	if(index < 0 || index > stacks.size())
    	{
    		throw new IllegalArgumentException();  // validate index value
    	}
    	int item = stacks.get(index).pop();
    	for(int i=index;i<stacks.size()-1;i++)
    	{
    		Stack<Integer> curr = stacks.get(i);
    		Stack<Integer> next = stacks.get(i+1);  // keep pushing elements if there are empty spaces in stack
    		curr.push(next.remove(0));
    	}
    	if(stacks.getLast().size() == 0)
    	{
    		stacks.removeLast();
    	}
    	return item;
    }
    
    public void printStacks()
    {
    	for(Stack<Integer> stack: stacks)
    	{
    		for(int item: stack)
    		{
    			System.out.println("Item is : "+item);
    		}
    		System.out.println("top");
    	}
    }
    
	public static void main(String[] args)
	{
		StackofPlates setOfStacks = new StackofPlates();
        setOfStacks.push(1); setOfStacks.push(2); setOfStacks.push(3);
        setOfStacks.push(4); setOfStacks.push(5); setOfStacks.push(6);
        setOfStacks.push(7); setOfStacks.push(8); setOfStacks.push(9);
        setOfStacks.printStacks();
        System.out.println();
        setOfStacks.popAt(1);
        setOfStacks.popAt(0);
        setOfStacks.printStacks();
	}
}
 