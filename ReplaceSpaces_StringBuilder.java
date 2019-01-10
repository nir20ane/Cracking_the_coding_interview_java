/** URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.) 
* EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"  
* Use StringBuilder and split the strings
* We can edit the staring in place if we use character arrays
*/
public class ReplaceSpaces_StringBuilder {
	public String replace(String s1) {
        String[] words = s1.split(" ");
        StringBuilder newstring = new StringBuilder(words[0]);
        for(int i=1;i<words.length;i++)
        {
        	newstring.append("%20");
        	newstring.append(words[i]);
        }
		return newstring.toString();
	}

	public static void main(String args[]) {
		String s1 = "I am John Smith  ";
        s1=s1.trim();
        ReplaceSpaces_StringBuilder r = new ReplaceSpaces_StringBuilder();
		System.out.println(r.replace(s1));
	}

}
