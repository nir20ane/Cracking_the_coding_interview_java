/* 
* Flip Bit to Win: You have an integer and you can flip exactly one bit from a O to a 1. 
* Write code to find the length of the longest sequence of 1 s you could create.
* EXAMPLE
* Input: 1775
* Output: 8
* SOLUTION (or: 11011101111) 
*/
package bitmanipulation;

public class FlipBitstoWin {
	
	public int flipbits(int n)
	{
		if(~n == 0) return Integer.BYTES*8;
		int currentlength = 0;
		int previouslength = 0;
		int maxlength = 1;
		while(n != 0)
		{
			if((n & 1) == 1)
			{
				currentlength++;
			}
			else if((n & 1) == 0)
			{
				previouslength = (n & 2) == 0? 0:currentlength;
				currentlength = 0;
			}
			else continue;
			maxlength = Math.max(maxlength, previouslength+currentlength+1);
			n >>= 1; 
		}
       return maxlength;
    }
	public static void main(String[] args) {
		FlipBitstoWin fli = new FlipBitstoWin();
		System.out.println(fli.flipbits(1775));
	}
}
