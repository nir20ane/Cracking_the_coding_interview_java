/** URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place.) 
* EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"  
* Use StringBuilder and split the strings
* We can edit the staring in place if we use character arrays
*/
public class ReplacesSpaces_UsingReplace {
	
	public String replacespaces(String str)
	{
		str=str.replaceAll("\\s","%20");
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "I am John Smith  ";
		s1=s1.trim();
		System.out.println("Input String : " + s1);
		ReplacesSpaces_UsingReplace r = new ReplacesSpaces_UsingReplace();
		System.out.println(r.replacespaces(s1));
	}

}
