import java.util.*;
import java.io.*;

public class SP {
    static int time = 1; // Start from 1 for 1-based indexing
    static int[] tin;
    static int[] subtree_size;
    static int[] flat;
    static int[] vals;
    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tin = new int[N + 1];
        subtree_size = new int[N + 1];
        flat = new int[N + 1];
        vals = new int[N + 1];

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

        // Copy initial values to flat array
        for (int i = 1; i <= N; i++) {
            flat[tin[i]] = vals[i];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int c = Integer.parseInt(st.nextToken());
                flat[tin[b]] = c;
            } else if (type == 2) {
                int sum = 0;
                for (int j = tin[b]; j < tin[b] + subtree_size[b]; j++) {
                    sum += flat[j];
                }
                pw.println(sum);
            }
        }
        pw.close();
    }

    static void dfs(int node, int parent) {
        tin[node] = time++;
        subtree_size[node] = 1;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node);
                subtree_size[node] += subtree_size[neighbor];
            }
        }
    }
}