package graphsandtees;

import java.util.ArrayList;

//- Here, our graph is implemented somewhat like a Graph "Adjacency List" like in CS 225.
//- Edges are not directly stored. Instead, a node's neighbors are saved in an ArrayList
public class GraphNode {
   
	public int data;
	public boolean visited; // needed for BFS, DFS
	public ArrayList<GraphNode> neighbors; // can alternatively use a HashSet (and give nodes unique IDs)
	
    /* Constructor */
	public GraphNode(int data) {
        this.data = data;
        visited = false;
        neighbors = new ArrayList<>();
    }
	
	public  void visit()
	{
		visited = true;
	}
	
	public void addneighbor(GraphNode node)
	{
		neighbors.add(node);
		node.neighbors.add(this);
	}
	
	public void addDirectedNeighbor(GraphNode node)
	{
		neighbors.add(node);
	}
	
	public ArrayList<GraphNode> getneighbors()
	{
		return neighbors;
	}
}
