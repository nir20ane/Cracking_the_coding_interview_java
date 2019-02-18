/* Conversion: Write a function to determine the number of bits you would need to flip to convert
* integer A to integer B.
* EXAMPLE
* Input:
* Output:
* SOLUTION
* 29 (or: 11101), 15 (or: 01111)
* 2 
*/
package bitmanipulation;

public class Conversion {
	
	public int conversion(int x, int y)
	{
		int diff = x ^ y;
		int count = 0;
		while(diff != 0)
		{
			diff = diff&(diff-1);
			count += 1;
		}
		return count;
	}

	public static void main(String[] args) {
		Conversion conv = new Conversion();
		System.out.println(conv.conversion(29, 15));
	}
}
