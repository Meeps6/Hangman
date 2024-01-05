//Nate Gould CS 2, 12/3/2023
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Listing28_8 {

	public static void main(String[] args) {
		
		// Graphs - depthFirstTraversal()
		GraphHelper graph = createGraph();
        GraphHelper.GraphIterator itr = graph.iterator();
        
        System.out.println("Adjacency vertex lists:");
        while (itr.hasNext())
            System.out.println(itr.next());
        
		String graphRoot = "Bob";

		System.out.println("\nPerforming a depth first traversal of the graph");
		System.out.println(depthFirstTraversal(graph, graphRoot));

	}
	
//*******************************************Graphs***************************************************

	static GraphHelper createGraph() {
		GraphHelper graph = new GraphHelper();
		graph.addVertex("Bob");
		graph.addVertex("Alice");
		graph.addVertex("Mark");
		graph.addVertex("Rob");
		graph.addVertex("Maria");
		graph.addEdge("Bob", "Alice");
		graph.addEdge("Bob", "Rob");
		graph.addEdge("Alice", "Mark");
		graph.addEdge("Rob", "Mark");
		graph.addEdge("Alice", "Maria");
		graph.addEdge("Rob", "Maria");
		return graph;
	}
    
	// TODO fill in these methods
	static Set<String> depthFirstTraversal(GraphHelper graph, String root) {
        LinkedHashSet<String> visited = new LinkedHashSet<String>();	
		visited = (LinkedHashSet<String>) dfs(graph, root, visited);
		return visited;
    }
    
    static Set<String> dfs(GraphHelper graph, String root, LinkedHashSet<String> dftSet){
    	dftSet.add(root);
    	for (String neighbor : graph.getAdjVertices(root)) {
			if (!dftSet.contains(neighbor)) {
				//Set root as parent to neighbor?
				dfs(graph, neighbor, dftSet);
			}
		}
		return dftSet;
	}
}


