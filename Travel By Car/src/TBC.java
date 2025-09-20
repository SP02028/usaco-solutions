import java.util.*;
import java.io.*;
public class TBC {
	static List<int[]>[] graph;
	static int N;
	public static void main(String[] args) throws IOException{
		//construct graph from weight to
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i = 0; i <=N;i++) {
			graph[i] = new ArrayList<int[]>();
 		}
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[f].add(new int[] {w,t});
			graph[t].add(new int[] {w,f});
		}
		int Q = Integer.parseInt(br.readLine());
		while(Q-->0) {
			 st =new StringTokenizer(br.readLine());
			 int ta = Integer.parseInt(st.nextToken());
			 int tb = Integer.parseInt(st.nextToken());
			 if(graph[ta].isEmpty()||graph[tb].isEmpty()) {
				 pw.println(-1);
				 continue;
			 }
			 int n = dijkstra(ta, tb);
			 if (n == Integer.MAX_VALUE) {
				    pw.println(-1);
				} else {
				    pw.println((n + L - 1) / L - 1);
				}

		}
		pw.close();
	}
	  static int dijkstra(int src, int dest) {
	        int[] dist = new int[N+1];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	PriorityQueue<int[]> s = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
	        dist[src] = 0;
	        s.add(new int[] { 0, src });
	        while (!s.isEmpty()) {
	        	int[] it = s.poll();
	        	int node = it[1];
	        	int distTillNow = it[0];
	        	if (distTillNow > dist[node]) continue;

	        	for (int[] nbrPair : graph[node]) {
	        	    int nbr = nbrPair[1];
	        	    int currentEdge = nbrPair[0];
	        	    if (distTillNow + currentEdge < dist[nbr]) {
	        	        dist[nbr] = distTillNow + currentEdge;
	        	        s.add(new int[] { dist[nbr], nbr });
	        	    }
	        	}


	        }
	        return dist[dest];
	    }
}
