/* 4.1 Route Between Nodes: 
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes. 
*/
package graphsandtees;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
	
	public boolean routeExists(GraphNode start, GraphNode end)
	{
		if(start == end) return true;
		Queue<GraphNode> q = new LinkedList<>();
		q.add(start);
		start.visit();
		while(!q.isEmpty())
		{
			GraphNode n = q.remove();
			if (n == end) {
                return true;
            }
			for(GraphNode neighbor:n.getneighbors())
			{
				if(!neighbor.visited) {
				neighbor.visit();
				q.add(neighbor);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
	        GraphNode node1 = new GraphNode(1);
	        GraphNode node2 = new GraphNode(2);
	        GraphNode node3 = new GraphNode(3);
	        node1.addneighbor(node2);
	        node2.addneighbor(node3);
	        RouteBetweenNodes rb = new RouteBetweenNodes();
	        System.out.println("Route exists? (should be true): " + rb.routeExists(node1, node3));
	        GraphNode node4 = new GraphNode(1);
	        GraphNode node5 = new GraphNode(2);
	        GraphNode node6 = new GraphNode(3);
	        node4.addneighbor(node6);
	        System.out.println("Route exists? (should be false): " + rb.routeExists(node4, node5));
	}
}
