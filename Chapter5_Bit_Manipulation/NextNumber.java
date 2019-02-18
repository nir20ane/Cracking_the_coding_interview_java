/*
 * Next Number: Given a positive integer, print the next smallest and the next largest number 
 * that have the same number of 1 bits in their binary representation.
 */
package bitmanipulation;

public class NextNumber {
	
	public int nextnum(int x)
	{
		int ones = countones(x);
		for(int i=x+1;i<Integer.MAX_VALUE;i++)
		{
			if(countones(i) == ones)
			{
				return i;
			}
		}
		return -1;
	}
	
	public int beforenum(int x)
	{
		int ones = countones(x);
		for(int i=x-1;i>0;i--)
		{
			if(countones(i) == ones)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int countones(int m)
	{
		int count = 0;
		for(int i=m;i>0;i=i&(i-1))
		{
			count += 1;
		}
		return count;
	}

	public static void main(String[] args) {
		NextNumber nn = new NextNumber();
		System.out.println(nn.nextnum(5));
		System.out.println(nn.beforenum(5));
		System.out.println(nn.nextnum(50));
		System.out.println(nn.beforenum(50));

	}
}
