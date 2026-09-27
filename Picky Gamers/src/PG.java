import java.io.*;
import java.util.*;

public class PG {
    static List<List<Integer>> adjList;
    static         List<List<Integer>> cyclelist = new ArrayList<>();
    static int[] visited;
    static int[] parent;
    static int M;
    static int[] games;
    public static void main(String[] args) {
    Kattio kattio = new Kattio();
     M= kattio.nextInt();
  visited = new int[M]; // 0 = unvisited, 1 = visiting, 2 = visited
        games = new int[M];
        parent  = new int[M];
        int N = kattio.nextInt();
    adjList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int a = kattio.nextInt()-1;
            int b = kattio.nextInt()-1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
      int[] ids =  assignCycleIds();
        for (int i = 0; i < M; i++) {
            if(visited[i]==0){
                dfs(i,-1 );
            }
            //STUCK: How to propogate games????
            // Tree: Choose one node not to be picked
            // 1 cycle: Sucessor graph which we just traverse and assign
            //multiple cycles: Propogate w/in and then propogate outside cycle
            //i dont know how to start implementing this...
            //im also stuck on how we're assigining it back to the og cow bc our graph only has nodes = games and edges = choices but
            //the choices don't distinguish what cow made the choice...
        }
        //games eventually contains all games.
        //not sure if we need a step to assign games to cows after or if we can just print games...
    }
    //cycle detection helper
    public static int[] assignCycleIds() {
        int[] cycleId = new int[M];
        Arrays.fill(cycleId, -1);
        Arrays.fill(parent, -1);
        //Detect all cycles using DFS
        for (int i = 0; i < M; i++) {
            if (visited[i] == 0) {
                dfs(i, -1);
            }
        }
        // Sort cycles by size descending to let larger (prominent) cycles claim nodes first
        cyclelist.sort((c1, c2) -> Integer.compare(c2.size(), c1.size()));
        //Assign distinct IDs to nodes based on prominent cycles
        for (int id = 0; id < cyclelist.size(); id++) {
            for (int node : cyclelist.get(id)) {
                if (cycleId[node] == -1) {
                    cycleId[node] = id;
                }
            }
        }
        return cycleId;
    }
    public static void dfs(int u, int p) {
        visited[u] = 1;
        parent[u] = p;
        for (int v : adjList.get(u)) {
            if (v == p) continue;
            if (visited[v] == 1) {
                // Found a back-edge, reconstruct cycle
                List<Integer> cycle = new ArrayList<>();
                cycle.add(v);
                int curr = u;
                while (curr != v && curr != -1) {
                    cycle.add(curr);
                    curr = parent[curr];
                }
                cyclelist.add(cycle);
            } else if (visited[v] == 0) {
                dfs(v, u);
            }
        }
        visited[u] = 2;
    }
    static class Kattio extends
            PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
