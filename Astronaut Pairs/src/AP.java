import java.util.*;
import java.io.*;
public class AP {
	static int N;
	static List<Integer>[] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		int P = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for(int i =0;i <N;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i< P;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		    int count = 1;
		}
		List<Integer> sizes = getComponentSizes(N);
		int total = N * (N+1)/2;
		for(int s: sizes) {
			total -= (s*(s+1)/2);
		}
		pw.println(total);
		pw.close();
	}
	static List<Integer> getComponentSizes(int N) {
	    boolean[] visited = new boolean[N];
	    List<Integer> sizes = new ArrayList<>();

	    for (int i = 0; i < N; i++) {
	        if (!visited[i]) {
	            int size = dfs(i, visited);
	            sizes.add(size);
	        }
	    }
	    return sizes;
	}
	static int dfs(int node, boolean[] visited) {
	    visited[node] = true;
	    int count = 1;

	    for (int neighbor : graph[node]) {
	        if (!visited[neighbor]) {
	            count += dfs(neighbor, visited);
	        }
	    }
	    return count;
	}

}
