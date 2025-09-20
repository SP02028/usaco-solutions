import java.util.*;
import java.io.*;
public class bfssp {
	private static boolean[] visited;
	static List<Integer>[] adj;
	private static int n=6;
	public static void main(String[] args) {
		visited  = new boolean[n];
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) { 
			adj[i] = new ArrayList<>();
			}
		adj[0] = new ArrayList<>(Arrays.asList(1, 2));
		adj[1] = new ArrayList<>(Arrays.asList(0));
		adj[2] = new ArrayList<>(Arrays.asList(0));
		adj[3] = new ArrayList<>(Arrays.asList(4,5));
		adj[4] = new ArrayList<>(Arrays.asList(3,5));
		adj[5] = new ArrayList<>(Arrays.asList(4,3));

		System.out.println(bfssp(0,5));
	}
	public static int bfssp(int source, int dest) {
		Queue<Integer> q = new LinkedList();
		int[] parent = new int[n]; //unique to sp
		int[] dist = new int[n]; //unique to sp
		Arrays.fill(parent, -1); //unique to sp
		q.add(source);
		visited[source] = true;
		parent[source] = source; //unique to sp
		dist[source] = 0;
		while(!q.isEmpty()) {
		int node = q.poll();
		//System.out.println(node);
		for(int nbr: adj[node]) {
			if(!visited[nbr]) {
				q.add(nbr);
				parent[nbr]=node;
				dist[nbr] = dist[node]+1;
				visited[nbr] = true;
			}
		}
		}
		return dist[dest];
	}
}


