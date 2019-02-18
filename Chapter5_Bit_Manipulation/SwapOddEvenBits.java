/*
 * Write a program to swap odd and even bits in an integer with
 * as few instructions as possible (e.g., bit 0 and bit 1 are
 * swapped, bit 2 and bit 3 are swapped, and so on).
*/
package bitmanipulation;

public class SwapOddEvenBits {
	
	public int swapbits(int n)
	{
		int evenbits = n & 0xAAAAAAAA;
		int oddbits = n & 0x55555555;
		int evenshift = evenbits >> 1;
		int oddshift = oddbits << 1;
		return evenshift | oddshift;
	}
	public static void main(String[] args)
	{
		SwapOddEvenBits Swp = new SwapOddEvenBits();
		System.out.println(Swp.swapbits(23));
	}

}
