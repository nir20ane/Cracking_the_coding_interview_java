/* Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent. 
Hint:
in-order traversal, left, node, right
if there is no right, then we have to find the parent,
if there is right, we have to find the leftmost child of node
*/
package graphsandtees;

public class Successor {
	
	public TreeNode findsuccessor(TreeNode node)
	{
		if(node.right != null)
		{
			return leftmostchild(node.right);
		}
		else
		{
			return properparent(node);
		}
	}
    
	public TreeNode leftmostchild(TreeNode node)
	{
        if (node == null) {
            return null;
        }
		TreeNode curr = node;
		
		while(curr.left != null)
		{
			curr = curr.left;
		}
		return curr;
	}
	
	public TreeNode properparent(TreeNode node)
	{
		TreeNode parent = node.parent;
		TreeNode child = node;
		while(parent != null && parent.left != child)
		{
			child = parent;
			parent = child.parent;
		}
		return parent;
	}
	
	public static void main(String[] args) {
		Successor suc = new Successor();
        TreeNode root = new TreeNode(5);
        root.addleftchild(1);
        root.left.addleftchild(0);
        root.addrightchild(8);
        root.right.addleftchild(6);
        root.right.addrightchild(9);
        System.out.println("Should be 6:    " + suc.findsuccessor(root).data);
        System.out.println("Should be 5:    " + suc.findsuccessor(root.left).data);
        System.out.println("Should be null: " + suc.findsuccessor(root.right.right));
	}
}
