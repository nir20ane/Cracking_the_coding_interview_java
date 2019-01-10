/**
 * 1.4 Palindrome Permutation
 * Given a string, write a function to check if it is a permutation 
 * of a palindrome. A palindrome is a word or phrase that is the same
 * forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictioniary words
 * Example :
 * Input : Tact Coa
 * Output : True (permutations: "taco cat", "atco cta", etc.)
 * Approach: use a table to count the charcaters
 * a string is a permutation plaindrome if it has exactly one character with odd count
 * Assume that characters are only alphabets between A-Z and a-z
 * Time Complexity is O(N), Space Complexity is O(26)
 */

public class IsPermutationOfPalindrome {
	private static int z = Character.getNumericValue('z');
	private static int a = Character.getNumericValue('a');
	public boolean isPermutationOfPalindrome(String str)
	{
		str = str.trim();
		char[] chars = str.toCharArray();
		return buildtable(chars);
	}
	public static int countcharnum(char c)
	{
		int x = Character.getNumericValue(c);
		if(a <= x && x <= z) return x-a;
		else return -1;
	}
	public static boolean buildtable(char[] chars) {
		int[] count = new int[z - a + 1];
		int countodd = 0;
		for(char c: chars)
		{
			int x = countcharnum(c);
			if(x != -1)
			{
				count[x]++;
				if(count[x] % 2 == 0) countodd--;
				else countodd++;
			}
		}
		return countodd <= 1; 
	}

	public static void main(String[] args) {
		IsPermutationOfPalindrome isper = new IsPermutationOfPalindrome();
		System.out.println(isper.isPermutationOfPalindrome("Tact Coa"));
		System.out.println(isper.isPermutationOfPalindrome("Tact Coaa"));
	}
}
