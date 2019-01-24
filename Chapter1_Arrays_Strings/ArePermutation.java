/** Check Permutation: Given two strings, write a method to decide if one is a permutation of the other. 
* Time Complexity O(nlogn)
* Sort the arrays and check if they are equal
*/
import java.util.Arrays;

public class ArePermutation {
	public static String sortString(String str)
	{
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	public static boolean arePermutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		return sortString(str1).equals(sortString(str2));
	}
	public static void main(String[] args) {
		System.out.println(arePermutation("javacoding","codingjava"));
		System.out.println(arePermutation("javacoding","java"));
		System.out.println(arePermutation("god","dog"));
	}
}
