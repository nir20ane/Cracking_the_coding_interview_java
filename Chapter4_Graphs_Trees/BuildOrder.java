package graphsandtees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class BuildOrder {
	
	public ArrayDeque<Node> topologicalSort(List<Node> nodes) throws Exception
	{
		ArrayDeque<Node> result = new ArrayDeque<>();
		Node source = new Node('s');
		for(Node n:nodes)
		{
			source.addDirectedNeighbor(n);
		}
		topologicalsort(source, result);
		result.removeFirst();
		return result;
	}
	public static void topologicalsort(Node n, ArrayDeque<Node> result) throws Exception
	{
		n.status = Visited.ACTIVE;
		for(Node nn:n.neighbors)
		{
			if(nn.status == Visited.NEW)
			{
				nn.status = Visited.ACTIVE;
				topologicalsort(nn, result);
			}
			else if(nn.status == Visited.ACTIVE)
			{
				throw new Exception("Not a DAG");
			}
		}
		n.status = Visited.DONE;
		result.addFirst(n);
	}

	public static void main(String[] args) throws Exception
	{
		BuildOrder bo = new BuildOrder();
		Node a = new Node('a');
	    Node b = new Node('b');
	    Node c = new Node('c');
	    Node d = new Node('d');
	    Node e = new Node('e');
	    Node f = new Node('f');
	    a.addDirectedNeighbor(d);
	    f.addDirectedNeighbor(b);
	    b.addDirectedNeighbor(d);
	    f.addDirectedNeighbor(a);
	    d.addDirectedNeighbor(c);
	    Node[] n = {a, b, c, d, e, f};
	    List<Node> nodes = Arrays.asList(n);
	    
        try {
            System.out.println(bo.topologicalSort(nodes));
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
	}
}
