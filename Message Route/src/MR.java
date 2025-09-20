import java.util.*;
import java.io.*;
public class MR {
static boolean[] visited;
static int n;
static List<Integer>[] adj;
static int[] parent;
static List<Integer> path = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		//read input
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		int m = Integer.parseInt(st.nextToken());
		int[][] edges = new int[m][2];
		for(int i = 0; i <m;i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		//make adj list
		adj = makeadj(edges, n+1);
		int dist = bfssp(1, n);
		
		if(parent[n]==-1) {
			pw.println("IMPOSSIBLE");
		}
		else {
			pw.println(dist+1);
			Collections.reverse(path);
			pw.print(path.get(0));
			for(int i = 1;i <path.size();i++ ) {
				pw.print(" " + path.get(i));
			}
		}
		pw.close();
	}
	public static List<Integer>[] makeadj (int[][] edges, int n) {
		List<Integer>[] adj = new ArrayList[n+1];
		for(int i = 0; i < n+1;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int[] edge: edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);

		}
		return adj;	
	}
	public static int bfssp(int source, int dest) {
		Queue<Integer> q = new LinkedList();
		parent = new int[n+1]; //unique to sp
		int[] dist = new int[n+1]; //unique to sp
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
		if(dest!=-1){
            int temp = dest;
            if(parent[dest]!=-1) {
            while(temp!=source){
            	path.add(temp);
                temp = parent[temp];
            }
            path.add(source);
		}
		}
		return dist[dest];
	}
}
