/*Sort Stack: 
 * Write a program to sort a stack such that the smallest items are on the top. 
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure
 *The stack supports the following operations: push, pop, peek, and is Empty.
 * O(n^2) time and O(n) space
*/
package ccistackqueue;

import java.util.Arrays;
import java.util.Stack;

public class SortStacks {
	Stack<Integer> result = new Stack<Integer>();
	
	public Stack<Integer> sort(Stack<Integer> stack)
	{
		while(!stack.isEmpty())
		{
			int tmp = stack.pop();
			while(!result.isEmpty() && (tmp < result.peek()))
			{
				stack.push(result.pop());
			}
			result.push(tmp);
		}
		stack = result;
		return stack;
	}

	public static void main(String[] args) {
		Integer[] a = {2,6,5,4,1,3,8,7};
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(Arrays.asList(a));   // add elements from array to stack
		SortStacks sortstack = new SortStacks();
		Stack<Integer> news = sortstack.sort(stack);
		System.out.println(news);
	}
}
