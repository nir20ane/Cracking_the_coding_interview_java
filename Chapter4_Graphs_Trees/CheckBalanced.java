/*
 * Check Balanced: 
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
 * Time Complexity: O(n)
 * Space Complexity: O(n) 
 */

package graphsandtees;

public class CheckBalanced {
    
	public boolean isbalanced(TreeNode root)
	{
		return (isbalancedhelper(root) == -1)? false:true;
		
	}
	
	/* Returns -1 if unbalanced, otherwise returns height of tree from given node */
	public int isbalancedhelper(TreeNode node)
	{
		if(node == null) return 0;
		
		int leftheight = isbalancedhelper(node.left);
		if(leftheight == -1) return -1; // left tree is unbalanced
		
		int rightheight = isbalancedhelper(node.right);
		if(rightheight == -1) return -1; // right tree is unbalanced
		
		if(Math.abs(rightheight - leftheight) > 1) 
		{
			return -1; // imbalance between the 2 subtrees
		}
		
		return 1+Math.max(leftheight, rightheight); //return height in case of balanced tree
	}
	
	public static void main(String[] args) {
		CheckBalanced cb = new CheckBalanced();
		TreeNode root = new TreeNode(0);
		root.addleftchild(1);
		root.left.addleftchild(3);
		root.left.left.addleftchild(4);
		root.addrightchild(2);
		System.out.println(cb.isbalanced(root));
		
		TreeNode root1 = new TreeNode(0);
		root1.addleftchild(1);
		root1.addrightchild(4);
		root1.left.addleftchild(3);
		root1.left.addrightchild(5);
		root1.left.left.addleftchild(10);
		root1.right.addleftchild(3);
		root1.right.addrightchild(3);
		System.out.println(cb.isbalanced(root1));
	}
}
