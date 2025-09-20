import java.util.*;
import java.io.*;

public class PQ {
    static int time = 1;
    static int[] vals;
    static int[] parent;
    static int N;
    static int[] pathSum;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        vals = new int[N + 1];
        pathSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) { // N-1 edges
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, -1);
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int c = Integer.parseInt(st.nextToken());
                vals[b] = c;
                dfs(b, parent[b]);
            } else if (type == 2) {
                pw.println(pathSum[b]);
            }
        }
        pw.close();
    }

   static void dfs(int node, int par) {
	   parent[node] = par;

	   if (par == -1) {
		    pathSum[node] = 0 + vals[node];
		} else {
		    pathSum[node] = pathSum[par] + vals[node];
		}
        for (int neighbor : graph[node]) {
            if (neighbor != par) {
                dfs(neighbor, node);
            }
        }
    }

}