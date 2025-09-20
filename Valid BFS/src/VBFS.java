import java.util.*;
import java.io.*;

public class VBFS {
    static List<Integer>[] graph;
    static int[] order;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        order = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        if (order[0] != 1) {
            System.out.println("No");
            return;
        }

        System.out.println(isValidBFS() ? "Yes" : "No");
    }

    static boolean isValidBFS() {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);

        int idx = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            Set<Integer> unvisitedNeighbors = new HashSet<>();

            for (int neighbor : graph[cur]) {
                if (!visited[neighbor]) {
                    unvisitedNeighbors.add(neighbor);
                }
            }

            int count = unvisitedNeighbors.size();
            for (int i = 0; i < count; i++) {
                if (idx >= n || !unvisitedNeighbors.contains(order[idx])) {
                    return false;
                }
                visited[order[idx]] = true;
                q.add(order[idx]);
                idx++;
            }
        }

        return true;
    }
}
