/** 1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring
of another. 
* Given two strings, S1 and S2, write code to check if S2 is a rotation of S1 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat")

** Approach: Use two loops, inner loop should not increment when characters mismatch
* Time Complexity - O(n^2)
* Space Complexity - O(1)

*/
public class StringRotation{
	public boolean stringRotation(String str1, String str2)
	{
		if(str1.length() != str2.length()) return false; // check for length mismatch
		if(str1.length() == 0) return true; // check for length 0
		int n = str1.length();
		
		search:
		    for(int s=0; s<n; s++) // first loop increments everytime
		    {
			    for(int i=0; i<n; i++) // second loop increments only when characters match
			    {
				    if(str1.charAt((s + i)%n) != str2.charAt(i)) continue search; //logic to keep iterator going				    
			    }
			return true;
		    }
		return false;
	}
	public static void main(String[] args)
	{
		StringRotation strrot = new StringRotation();
		System.out.println(strrot.stringRotation("bata", "taba"));
		System.out.println(strrot.stringRotation("bata", "tabe"));
	}
}
