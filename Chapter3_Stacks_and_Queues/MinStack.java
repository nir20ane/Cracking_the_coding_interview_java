/*Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. 
*/
package CCIstackqueue;

import java.util.Stack;

public class MinStack {
	
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();
	public void push(int x)
	{
		if(x <= min)
		{
			stack.push(min);  // if x is <=min, push min first and then x, so as to keep track of min for each pop() operation
			min = x;
		}
		stack.push(x);
	}
	
	public void pop()
	{
		if(stack.pop() == min) min = stack.pop(); // pop twice is top element is min
	}
	public int getmin()
	{
		return min;
	}
	
	public int top()
	{
		return stack.peek();
	}
	public static void main(String[] args) {
        MinStack min = new MinStack();
        min.push(-2);
        min.push(0);
        min.push(-3);
        min.push(-2);
        min.pop();
        System.out.println(min.getmin());
        System.out.println(min.top());
        min.pop();
        System.out.println(min.getmin());
        System.out.println(min.top());
	}
}
