

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src == null || dest == null || !graph.containsElement(src) || !graph.containsElement(dest))
			return -1;
		if (src.equals(dest)) return 0;
		BreadthFirstSearch bfs1 = new BreadthFirstSearch(graph);
		if(bfs1.bfs(graph.getNode(src), dest)) {
			//System.out.println("Found:"+ src+ "," + dest + "," + bfs1.marked+", size:"+(bfs1.marked.size()-1));
			return bfs1.marked.size()-1;
		} else
			//System.out.println("False:"+ src+ "," + dest + "," + bfs1.marked+", size:"+(bfs1.marked.size()-1));
		return -1; // this line is here only so this code will compile if you don't modify it
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null || !graph.containsElement(src) || distance<1)
			return null;
		Set<Node> set = graph.getNodeNeighbors(graph.getNode(src));
		if (set.size()==0 && distance > 0 &&!(src == null)) {
			Set<String> stringset = new HashSet<>();
			return stringset;
		}
		for (int i=0;i<distance-1;i++) {
			Object[] array = set.toArray();
			String[] stringarray = new String[array.length];
			for (int j=0;j<array.length;j++) {
				if (array[j] instanceof Node)
					stringarray[j] = ((Node)array[j]).getElement();
			}
			int setsize= set.size();
			for (int k=0;k<setsize-1;k++)
				set.addAll(graph.getNodeNeighbors(graph.getNode(stringarray[k])));
		}
		set.remove(graph.getNode(src));
		Set<String> stringset = new HashSet<>();
		for(Node node:set)
			stringset.add(node.getElement());
		return stringset; 
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (values == null || g ==  null || values.size() == 0)
			return false;
		LinkedList<String> list = new LinkedList<String>();
		if (values instanceof LinkedList) {
			list = (LinkedList)values;
			if (list.getFirst() != list.getLast())
				return false;
		}
		for (int i=0; i<list.size()-2;i++) {
			String src=list.get(i);
			Set<Edge> edgeset= new HashSet<Edge>();
			if (g.containsElement(src)) {
				edgeset = g.getNodeEdges(g.getNode(src));
			}
			String dest =  list.get(i+1);
			//if (g.containsElement(dest)) {
			//	Set<Edge> edgeset2 = g.getNodeEdges(g.getNode(dest));
			//}
			boolean edgeisthere = false;
			Node srcnode = new Node(src);
			Node destnode = new Node(dest);
			Edge edge1 = new Edge(srcnode, destnode);
			Edge edge2 = new Edge(destnode, srcnode);
			boolean containsedge1 = edgeset.contains(edge1); // Contains checks the HashMaps-hashCode-function, Edge-hashCode,
			boolean containsedge2 = edgeset.contains(edge2); // Node-hashCode and always returns false: Error
			if ( containsedge1 | containsedge2 ) {
				edgeisthere=true;
				continue;
			}
			if (edgeisthere == false) break;
		}
		return false; 
	}
	
	/*	public static void main(String[] args)  {
			Graph graph = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
			
			Set<String> stringset = nodesWithinDistance(graph, "0", 3);
			for (String string:stringset)
				System.out.println(string);
				
			List<String> list = new LinkedList<>();
			list.add("0");
			list.add("1");
			list.add("2");
			list.add("3");
			list.add("4");
			list.add("5");
			list.add("0");
			System.out.println("HamiltonianPathFound is: "+isHamiltonianPath(graph,list));
		}*/
		
}
