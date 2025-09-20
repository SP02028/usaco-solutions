import java.util.*;
import java.io.*;


public class bfs {
	private static boolean[] visited;
	static List<Integer>[] adj;
	private static int n=6;
	public static void main(String[] args) {
		visited  = new boolean[n];
		adj = new ArrayList[n];
		for (int i = 1; i < n; i++) { 
			adj[i] = new ArrayList<>();
			}
		adj[0] = new ArrayList<>(Arrays.asList(1, 2, 4));
		adj[1] = new ArrayList<>(Arrays.asList(3, 4));
		adj[2] = new ArrayList<>(Arrays.asList(5));
		for(int i = 0; i < n;i++) {
			if(!visited[i]) {
				bfs(i);
			}
		}
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n); //start from the source node
		visited[n]= true;
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.println(node);
			for(int nbr: adj[node]) {
				if(!visited[nbr]) {
					q.add(nbr); //add the neighbors of the current node to the queue -> adding 1 to depth traversed in next iteration?
					visited[nbr] = true;
				}
			}
		}
	}
}
