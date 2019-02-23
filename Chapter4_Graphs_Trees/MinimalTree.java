/* 4.2 Minimal Tree: 
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height. 
*/
package graphsandtees;

public class MinimalTree {
    
	public TreeNode createminTree(int[] sortedarray)
	{
		return createminTree(sortedarray, 0, sortedarray.length-1);
	}
	
	public TreeNode createminTree(int[] sortedarray, int start, int end)
	{
		if(start > end) return null;
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(sortedarray[mid]);
		n.left = createminTree(sortedarray, start, mid-1);
		n.right = createminTree(sortedarray, mid+1, end);
		return n;
	}
	
	public void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data); // our toString() method will be invoked here
            printInOrder(node.right);
        }
    }
	
	public static void main(String[] args) {
		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7 };
		MinimalTree mt = new MinimalTree();
		TreeNode BST = mt.createminTree(sortedArray);
		mt.printInOrder(BST);
	}
}
