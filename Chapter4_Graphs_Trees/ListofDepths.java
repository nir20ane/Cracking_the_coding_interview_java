/*
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). 
*/
package graphsandtees;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListofDepths {
	
	public ArrayList<LinkedList<TreeNode>> createlists(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		lists = createlisthelper(root,lists,0);
		return lists;
	}

	public ArrayList<LinkedList<TreeNode>> createlisthelper(TreeNode node, ArrayList<LinkedList<TreeNode>> lists, int level)
	{
		// if node is null return null
		if(node == null) return null;
		
		// time to add new ll to array list
		if(lists.size() == level)
		{
		    lists.add(new LinkedList<TreeNode>());
		}
		
		// get current level list
		LinkedList<TreeNode> list = lists.get(level);
		// add current node data
		list.add(new TreeNode(node.data));
		
		// increment left and go to left and right side of root
		createlisthelper(node.left, lists, level+1);
		createlisthelper(node.right, lists, level+1);
		return lists;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.addleftchild(0);
        root.addrightchild(8);
        root.left.addleftchild(6);
        root.right.addrightchild(9);
        ListofDepths ld = new ListofDepths();
        ArrayList<LinkedList<TreeNode>> dep = ld.createlists(root);
        
        // Print the final list
        for (int i = 0; i < dep.size(); i++) {
            LinkedList<TreeNode> list = dep.get(i);
            System.out.format("\nLevel %d: ", i);
            for (TreeNode node : list) {
                System.out.print(node.data+" ");
            }
        }
	}

}
