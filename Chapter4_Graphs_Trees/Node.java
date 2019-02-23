package graphsandtees;

import java.util.ArrayList;

public class Node {
    public char data;
    public Visited status;
    public ArrayList<Node> neighbors;
    
    public Node(char data)
    {
    	this.data = data;
    	status = Visited.NEW;
    	neighbors = new ArrayList<>();
    }
    
    public void addDirectedNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}
