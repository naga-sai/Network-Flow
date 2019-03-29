package fordFulkerson;

import java.util.*;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class GraphConstruct {

	private static BufferedReader r;
	private static HashMap<String, HashMap<String, Nodes>> InputGraph;
	private static HashMap<String, Nodes> edge_connections;
	static boolean visited[];
	static long startTime, endTime;

	public static void main(String[] args) throws IOException {

		String inputLine = "";
		String source = args[2];
		int destination = Integer.parseInt(args[3]);
		startTime = System.currentTimeMillis();
		r = new BufferedReader(new FileReader(args[1]));
		int node_num = 0;
		// r = new BufferedReader(new FileReader(FILENAME));
		InputGraph = new HashMap<String, HashMap<String, Nodes>>();

		while ((inputLine = r.readLine()) != null) {
			edge_connections = new HashMap<String, Nodes>();
			StringTokenizer st = new StringTokenizer(inputLine, " ");
			while (st.hasMoreTokens()) {
				String name = st.nextToken();
				//System.out.println(name);
				int capacity = Integer.parseInt(st.nextToken());
				//System.out.println(capacity);
				edge_connections.put(name, new Nodes(name, capacity));

			}
			InputGraph.put(Integer.toString(node_num), edge_connections);

			node_num++;

		}
		// System.out.println("destination"+destination);

		/*
		 * for (String key1 : InputGraph.keySet()) { HashMap<String,Nodes>
		 * m_edge_connections = InputGraph.get(key1);
		 * //System.out.println(m_edge_connections.size()); Iterator<String> it
		 * = m_edge_connections.keySet().iterator();
		 * 
		 * while(it.hasNext()) { Nodes n1 = (Nodes)
		 * m_edge_connections.get(it.next()); System.out.println("For node" +
		 * key1 + ": " + n1.getName() + " " +n1.getCapacity()); }
		 * 
		 * }
		 */

		setVisitedNodes(InputGraph);

		Bfs_ShortestPath a = new Bfs_ShortestPath();
		
		a.doBfs(new Nodes(source), InputGraph, destination);

	}

	public static void setVisitedNodes(HashMap<String, HashMap<String, Nodes>> Input) {
		visited = new boolean[Input.keySet().size() + 2];
		for (int i = 0; i < Input.keySet().size() + 1; i++)
			visited[i] = false;
	}

}
