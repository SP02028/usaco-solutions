import java.util.*;
import java.io.*;

public class SGFP {
    static ArrayList<int[]>[] tree;
    static HashSet<Integer> fromA, fromB;
    static int n, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            tree = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                tree[u].add(new int[]{v, w});
                tree[v].add(new int[]{u, w});
            }

            fromA = new HashSet<>();
            fromB = new HashSet<>();

            // DFS from a, don't visit b
            dfs(a, 0, -1, b, fromA);

            // DFS from b, but do NOT add b itself to fromB
            for (int[] edge : tree[b]) {
                int v = edge[0], w = edge[1];
                dfs(v, w, b, b, fromB);
            }

            boolean found = false;
            // If any value in fromA is in fromB, we can teleport and then reach b
            for (int x : fromA) {
                if (fromB.contains(x)) {
                    found = true;
                    break;
                }
            }
            pw.println(found ? "YES" : "NO");
        }
        pw.close();
    }

    // DFS to collect all xor-paths from start, skipping forbidden node
    static void dfs(int u, int xor, int parent, int forbidden, HashSet<Integer> set) {
        if (u == forbidden) return;
        set.add(xor);
        for (int[] edge : tree[u]) {
            int v = edge[0], w = edge[1];
            if (v != parent) {
                dfs(v, xor ^ w, u, forbidden, set);
            }
        }
    }
}

