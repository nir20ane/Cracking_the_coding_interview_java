/** One Away: There are three types of edits that can be performed on strings: insert a character,
* remove a character, or replace a character. Given two strings, write a function to check if they are
* one edit (or zero edits) away.
* EXAMPLE
* pale, ple -> true
* pales, pale -> true
* pale, bale -> true
* pale, bae -> false
* Approach - increase count if there is a mismatch in character or length
* increase index 1 if string1 length is more and index 2 if string 2 length is more
* Time Complexity O(n); Space Complexity O(1)
*/
public class OneEditString
{
	public static boolean oneEditString(String s1, String s2)
	{
		int len1 = s1.length();
		int len2 = s2.length();
		int index1 = 0, index2 = 0;
		int count = 0;
		while(index1<len1 && index2<len2)
		{
			if(s1.charAt(index1) != s2.charAt(index2))
			{
				if(count == 1) return false;
				if(len1 < len2) index2++; //increase index2 is string2 is long
				else if(len1 > len2) index1++; //increase index1 is string1 is long
				else
				{
					index1++;
					index2++; //increase index1 and index2 if they are equal
				}
				count++; //increase count if characters dont match
			}
			else
			{
				index1++; // increase both indexes if characters match
				index2++;
			}
		}
		if(index1 < len1 || index2 < len2) count++; // increase count if they is an extra length
		return count == 1;
	}
	public static void main(String[] args)
	{
		OneEditString one = new OneEditString();
		System.out.println(one.oneEditString("pale","bale"));
		System.out.println(one.oneEditString("pale","balee"));
		System.out.println(one.oneEditString("ale","bale"));
		System.out.println(one.oneEditString("bale","bal"));
	}
}
