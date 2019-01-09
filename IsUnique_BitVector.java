//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
// Let us assume that the string has all lower case letters and solve it using bit vector
// Advantages: space is reduced
public class IsUnique_BitVector {
	public static boolean isUnique(String s)
	{
		int checker = 0;
		for(int i=0;i<s.length();i++)
		{
			int val = s.charAt(i)-'a';
			int newval = 1<<val;
			if((checker & newval) > 0) return false;
			checker |= newval;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isUnique("java"));
		System.out.println(isUnique("string"));
		System.out.println(isUnique("jav"));

	}

}
