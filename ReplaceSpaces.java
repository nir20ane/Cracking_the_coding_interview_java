/* URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.) 
* EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"  
* Two Scan Approach, Scan once forward to count space and once backward for filling
* We can edit the staring in place if we use character arrays
*/
public class ReplaceSpaces {
	public String replace(String s1, int length) {
		char[] chars = s1.toCharArray();
		int index = 0, spacecount = 0,i;
		for(i=0;i<length;i++)
		{
			if(chars[i] == ' ') spacecount++; // count spaces
		}
		index = length+spacecount*2; // have extended length value
		char[] chars_new = new char[index]; // have a new char array
		for(i=length-1;i>=0;i--) // traverse from end of string
		{
			char c = chars[i];
			if(c == ' ')                
			{
			    chars_new[index-1] = '0'; 
			    chars_new[index-2] = '2';
			    chars_new[index-3] = '%';
			    index = index - 3;
			}
			else
			{
			    chars_new[index-1] = c;
			    index--;
			}
		}
		return new String(chars_new);
	}

	public static void main(String args[]) {
		String s1 = "I am John Smith  ";
		s1=s1.trim();
		int trueLength = s1.length();
		System.out.println("Input String : " + s1);
		ReplaceSpaces r = new ReplaceSpaces();
		System.out.println(r.replace(s1, trueLength));
	}
}
