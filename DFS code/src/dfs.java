import java.util.*;
import java.io.*;


public class dfs {
	private static boolean[] visited;
	static List<Integer>[] adj;
	private static int n=6;
	public static void main(String[] args) {
		visited  = new boolean[n];
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) { 
			adj[i] = new ArrayList<>();
			}
		adj[0] = new ArrayList<>(Arrays.asList(1, 2, 4));
		adj[1] = new ArrayList<>(Arrays.asList(3, 4));
		adj[2] = new ArrayList<>(Arrays.asList(5));
		for(int i = 0; i < n;i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	public static void dfs(int n) {
		if(visited[n]) {
			return; 
		}
		visited[n] = true;
		 System.out.println("Visiting node: " + n);
		for (int neighbor : adj[n]) { 
			System.out.println(" " + n + " -> " + neighbor);
			dfs(neighbor); 
		}
	}
}
