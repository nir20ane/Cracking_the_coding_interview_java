/** 1.6 String Compression: Implement a method to perform basic string compression using the counts
* of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
* "compressed" string would not become smaller than the original string, your method should return
* the original string. You can assume the string has only uppercase and lowercase letters (a - z). 
* Approach: use String Builder, calc compressed length, return orginal string if compressed length is longer
* Time Complexity O(n); Space Complexity O(n) - String builder
*/
public class StringCompression {
	public String compress(String str)
	{
		int final_len = calclen(str); // calculate compressed length
		if(final_len >= str.length()) return str; // return original string jf compressed one is longer
		StringBuilder compstr = new StringBuilder(final_len);
		int consicount = 0;
		for(int i=0;i<str.length();i++)
		{
			consicount++;
			if((i+1 >= str.length()) || (str.charAt(i) != str.charAt(i+1)))
				{
				    compstr.append(str.charAt(i)); // append char if characters are not same or if it is end of string
				    compstr.append(consicount); // append count
				    consicount = 0; // make count as 0 if characters are not same
				}
		}
		return compstr.toString();
	}
	
	public int calclen(String str)
	{
		int conscount = 0;
		int complength = 0;
		for(int i=0;i < str.length(); i++)
		{
			conscount++;
			if((i+1 >= str.length()) || (str.charAt(i) != str.charAt(i+1)))
			{
				complength += 2; // newlength will increment by 2 if characters are not same or if it is end of string
				conscount = 0; // make count as 0 if characters are not same
			}
		}
		return complength;
	}
    
	public static void main(String[] args)
	{
		StringCompression comstring = new StringCompression();
		System.out.println(comstring.compress("aaaabbgg"));
		System.out.println(comstring.compress("ccccgggghhhhh"));
		System.out.println(comstring.compress("aaaabbggffjjggsskkhgh"));
		System.out.println(comstring.compress("a"));
		System.out.println(comstring.compress("abc"));
	}

}
