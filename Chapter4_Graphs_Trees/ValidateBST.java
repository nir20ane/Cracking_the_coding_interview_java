/* 4.5 Validate BST: 
 * Implement a function to check if a binary tree is a binary search tree. 
 */
package graphsandtees;

public class ValidateBST {
	
	public boolean validatebst(TreeNode root)
	{
		if(root == null)
		{
			return true;
		}
		
		return validatebsthelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
    
	public boolean validatebsthelper(TreeNode node, int min, int max)
	{
		if(node == null) return true;
		
		if(node.data <= min || node.data > max)
		{
			return false;
		}
		
		return validatebsthelper(node.left, min, node.data) && validatebsthelper(node.right, node.data, max);
	}
	public static void main(String[] args) {
		ValidateBST vbst = new ValidateBST();
		TreeNode root = new TreeNode(3);
		root.addleftchild(1);
		root.left.addleftchild(0);
		root.left.left.addleftchild(-1);
		root.addrightchild(4);
		System.out.println(vbst.validatebst(root));
		
		TreeNode root1 = new TreeNode(20);
		root1.addleftchild(10);
		root1.addrightchild(40);
		root1.left.addleftchild(9);
		root1.left.addrightchild(11);
		root1.left.left.addleftchild(8);
		root1.right.addleftchild(30);
		root1.right.addrightchild(0);
		System.out.println(vbst.validatebst(root1));

	}

}
