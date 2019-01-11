/** 1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring
of another. 
* Given two strings, S1 and S2, write code to check if S2 is a rotation of S1 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat")

** Contenate string str1+str1 and check if str2 is in str1
* Time Complexity - O(n^2)
* Space Complexity - O(n) - since we concatenate two strings
*/
public class StringRotation_UsingContains{
	public boolean stringRotation(String str1, String str2)
	{
		// check for equal length and String str2 in concatenated str+str1
		return((str1.length() == str2.length()) && (str1+str1).contains(str2));
	}
	public static void main(String[] args)
	{
		StringRotation strrot = new StringRotation();
		System.out.println(strrot.stringRotation("bata", "taba"));
		System.out.println(strrot.stringRotation("bata", "tabe"));
	}
}