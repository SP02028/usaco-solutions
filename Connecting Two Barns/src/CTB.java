import java.io.*;
import java. util. ArrayList;
import java.util.Collections;
import java.util.List;
import java.util. StringTokenizer;

public class CTB {
    static boolean[] visited;
    static List<Integer>[] adj;
    static List<List<Integer>> comps = new ArrayList<>();

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int T = io.nextInt();
        while (T-- > 0) {
            comps.clear();
            int N = io.nextInt();
            int M = io.nextInt();
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }
            visited = new boolean[N];
            for (int i = 0; i < M; i++) {
                int a = io.nextInt()-1;
                int b = io.nextInt()-1;
                adj[a].add(b);
                adj[b].add(a);
            }

            int startcomp = -1;
            int endcomp = -1;
            for (int i = 0; i < N; i++) {
                if(!visited[i]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    dfs(i, temp);
                    Collections.sort(temp);
                    comps.add(temp);

                    int currentComp = comps. size() - 1;
                    if(temp.contains(0)){
                        startcomp = currentComp;
                    }
                    if(temp.contains(N-1)){
                        endcomp = currentComp;
                    }
                }
            }

            if(startcomp == endcomp){
                io.println(0);
                continue;
            }
            List<Integer> startNodes = comps.get(startcomp);
            List<Integer> endNodes = comps.get(endcomp);

            long mindirect = mincost(startNodes, endNodes);
            long minindirect = Long.MAX_VALUE;

            for (int i = 0; i < comps.size(); i++) {
                if(i == startcomp || i == endcomp){
                    continue;
                }
                List<Integer> inter = comps.get(i);
                long sdist = mincost(startNodes, inter);
                long edist = mincost(inter, endNodes);
                long total = sdist + edist;
                minindirect = Math.min(minindirect, total);
            }
            if(minindirect == Long. MAX_VALUE) {
                io. println(mindirect);
            } else {
                io.println(Math.min(minindirect, mindirect));
            }
        }
        io.close();
    }

    static long mincost(List<Integer> comp1, List<Integer> comp2) {
        long minCost = Long.MAX_VALUE;
        int i = 0, j = 0;

        while (i < comp1.size() && j < comp2.size()) {
            int node1 = comp1. get(i);
            int node2 = comp2.get(j);
            long cost = (long)(node1 - node2) * (node1 - node2);
            minCost = Math. min(minCost, cost);

            if (node1 < node2) {
                i++;
            } else {
                j++;
            }
        }
        return minCost;
    }

    public static void dfs(int s, ArrayList<Integer> res){
        if (visited[s]) {
            return;
        }
        res. add(s);
        visited[s] = true;
        for (int nbr : adj[s]) {
            dfs(nbr, res);
        }
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System. in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}