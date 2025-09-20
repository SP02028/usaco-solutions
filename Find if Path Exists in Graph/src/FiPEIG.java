import java.util.*;

class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void main(String[] args) {
    	int[][] edges= {{0,1},{1,2},{2,0}};
    	System.out.println(validPath(3,edges, 0, 2));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
    	 if(source == destination){
    	        return true;
    	       }
       adj = new ArrayList[n];
       visited = new boolean[n];
		for (int i = 0; i < n; i++) { 
			adj[i] = new ArrayList<>();
			}
		for (int[] i : edges) {
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        int sp = bfssp(n,source, destination);
        if(sp !=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static int bfssp(int n,int source, int dest) {
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
