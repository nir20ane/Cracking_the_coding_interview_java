package graphsandtees;

public class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;
    public int data;
    
    public TreeNode(int data)
    {
    	this.data = data;
    }
    
    public void addleftchild(int data)
    {
    	TreeNode node = new TreeNode(data);
    	left = node;
    	node.parent = this;
    }
    
    public void addrightchild(int data)
    {
    	TreeNode node = new TreeNode(data);
    	right = node;
    	node.parent = this;
    }
}
