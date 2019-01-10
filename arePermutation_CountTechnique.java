/** Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
* Count the characters in each string and check if they are equal.
* Time Complexity O(1)
*/
public class ArePermutation_CountTechnique {
	public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
	        return false;
	        }
		int[] letters = new int[128]; 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { 
		    letters[c]++;
		}
		char[] t_array = t.toCharArray();
		for (char ta : t_array) { 
		    letters[ta]--;
		    if(letters[ta]<0) return false;
		}
  
		return true;
	}
	public static void main(String[] args) {
		System.out.println(permutation("javacoding","codingjave"));
		System.out.println(permutation("javacoding","codingjava"));
	}
}
