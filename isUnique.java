// Problem:Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
// Time complexity: O(n)
// Space Complexity: O(1) or 128, as we create an array of 128 boolean values
//Question to ask is array and ASCII array
public class IsUnique{
    public static boolean isUnique(String s)
    {
    	System.out.println(s);
        if(s.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for(int i=0;i<s.length();i++)
        {
            int val = s.charAt(i);
            if(char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
    public static void main(String[] args)
    {
    	System.out.println(isUnique("java"));
    	System.out.println(isUnique("string"));
    	System.out.println(isUnique("jav"));
    }
}