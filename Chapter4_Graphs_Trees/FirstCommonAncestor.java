package graphsandtees;

public class FirstCommonAncestor {
	
	public TreeNode commonanc(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root ==  null)
		{
			return null;
		}
		if(p == root || q == root)
		{
			return root;
		}
		TreeNode left = commonanc(root.left, p, q);
		TreeNode right = commonanc(root.right, p, q);
		if(left == null)
		{
			return right;
		}
		else if(right == null)
		{
			return left;
		}
		else
		{
			return root;
		}
	}
    
	
	public static void main(String[] args) {
		FirstCommonAncestor fc = new FirstCommonAncestor();
		TreeNode root = new TreeNode(5);
        root.addleftchild(1);
        root.left.addleftchild(0);
        root.addrightchild(8);
        root.right.addleftchild(6);
        root.right.addrightchild(9);
		System.out.println(fc.commonanc(root, root.left, root.right.right).data);
		System.out.println(fc.commonanc(root, root.right, root.right.left).data);
	}
}
