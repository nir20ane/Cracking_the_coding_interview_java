/*
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed
 * in as a double, print the binary representation. If the number
 * cannot be represented accurately in binary with at most 32
 * characters, print "ERROR".
*/
package bitmanipulation;

public class BinaryString {
    
	public String binstring(double n)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		while(n>0)
		{
			if(n*2 >= 1)
			{
				sb.append(1);
				n = n*2-1;
			}
			else
			{
				sb.append(0);
				n = n*2;
			}
		}
		if(sb.length() > 32)
		{
			throw new IllegalStateException("more than 32 chacracters");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		BinaryString binstr = new BinaryString();
		System.out.println(binstr.binstring(0.75));
		System.out.println(binstr.binstring(0.5));
		//System.out.println(binstr.binstring(0.72));
	}
}
