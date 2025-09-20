
import java.util.*;
import java.io.*;

public class VP {
    public static void main(String[] args) throws IOException {
        // Set up input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int len = Integer.parseInt(br.readLine());
            int[] b = new int[len + 1];
            boolean[] node = new boolean[len + 1];
            for (int i = 1; i <= len; i++) {
                node[i] = true;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            // Read the parent of each node and mark non-leaves
            for (int i = 1; i <= len; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                node[b[i]] = false;
            }
            // Special case for a single node
            if (len == 1) {
                out.println("1");
                out.println("1");
                out.println("1");
                out.println();
                continue;
            }
            // Paths
            ArrayList<Integer>[] paths = new ArrayList[len + 1];
            for (int i = 0; i <= len; i++) {
                paths[i] = new ArrayList<>();
            }
            boolean[] used = new boolean[len + 1];
            int n = 0;
            // Find paths starting from leaves
            for (int i = 1; i <= len; i++) {
                if (!node[i]) {
                    continue; // Skip non-leaves
                }
                used[i] = true;
                paths[n].add(i);
                int v = i;
                // Follow the path upwards until a cycle or used node is found
                while (b[v] != v && !used[b[v]]) {
                    v = b[v];
                    used[v] = true;
                    paths[n].add(v);
                }
                n++;
            }
            out.println(n);
            for (ArrayList<Integer> path : paths) {
                if (path.isEmpty()) continue;
                out.println(path.size());
                Collections.reverse(path); // Reverse the path
                for (int v : path) {
                    out.print(v + " ");
                }
                out.println();
            }
            out.println();
        }
        out.close();
    }
}