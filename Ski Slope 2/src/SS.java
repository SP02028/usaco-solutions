import java.util.*;
import java.io.*;

public class SS {
    static HashMap<Integer, List<int[]>> tree = new HashMap<>();
    static long[] prefix;
    static long[][] maxEnjoyment;
    static int n;
    static int q;
    static TreeSet<Integer>[] obstacles;
    static int[][] queries;

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        n = kattio.nextInt();
        prefix = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            int parent = kattio.nextInt();
            int difficulty = kattio.nextInt();
            int enjoyment = kattio.nextInt();
            tree.computeIfAbsent(parent, k -> new ArrayList<int[]>()).add(new int[]{i, difficulty, enjoyment});
        }
        //compute prefix sums of enjoyment
        setPrefix(1);
        q = kattio.nextInt();
        queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            queries[i][0] = kattio.nextInt();
            queries[i][1] = kattio.nextInt();
            queries[i][2] = i;
        }
        //sort queries by skill
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        maxEnjoyment = new long[11][q + 1];
        obstacles = new TreeSet[11];
        for (int i = 0; i <= 10; i++) {
            obstacles[i] = new TreeSet<>();
        }
        //dfs to find answers
        int[] minStrength = new int[11];
        Arrays.fill(minStrength, -1);
        dfs(1, minStrength);
        //compute prefix maximums for each skip level?????
        for (int i = 0; i <= 10; i++) {
            for (int j = 1; j < q; j++) {
                maxEnjoyment[i][j] = Math.max(maxEnjoyment[i][j], maxEnjoyment[i][j - 1]);
            }
        }
        long[] answers = new long[q];
        for (int i = 0; i < q; i++) {
            int og = queries[i][2];
            int skips = queries[i][1];
            answers[og] = maxEnjoyment[skips][i];
        }
        for (long answer : answers) {
            kattio.println(answer);
        }
        kattio.close();
    }

    static void dfs(int node, int[] minStrength) {
        for (int i = 0; i <= 10; i++) {
            //for this node, we find which queries can reach from every skip level
            int strength = minStrength[i];
            //Binary search for first query that can reach this node
            int high = q - 1;
            int low = 0;
            int ans = q;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (queries[mid][0] >= strength) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (ans < q) {
                maxEnjoyment[i][ans] = Math.max(maxEnjoyment[i][ans], prefix[node]);
            }
        }
        int[] ogminstrength = minStrength.clone();
        List<int[]> children = tree.get(node);
        if (children != null) {
            for (int[] edge : children) {
                int child = edge[0];
                int difficulty = edge[1];
                //add this edge's difficulty to the skip levels
                for (int i = 0; i <= 10; i++) {
                    obstacles[i].add(difficulty);
                }
                int[] removed = new int[11]; //for each skip level remove the smallest obstacles such that the hardest ones, the ones we skip, are the only ones remaining in the tree set
                Arrays.fill(removed, -1);
                int[] nextMinStrength = ogminstrength.clone();
                for (int i = 0; i <= 10; i++) {
                    //keep only the top skip level obstacles
                    while (obstacles[i].size() > i) {
                        int smallest = obstacles[i].pollFirst();
                        removed[i] = smallest;
                    }
                    //update minstrength
                    if (removed[i] != -1) {
                        nextMinStrength[i] = Math.max(nextMinStrength[i], removed[i]);
                    }
                }
                dfs(child, nextMinStrength);
                for (int skipLevel = 0; skipLevel <= 10; skipLevel++) { //restore obstacles
                    if (removed[skipLevel] != -1) {
                        obstacles[skipLevel].add(removed[skipLevel]);
                    }
                }

                // Remove the edge's difficulty from all skip levels
                for (int skipLevel = 0; skipLevel <= 10; skipLevel++) {
                    obstacles[skipLevel].remove(difficulty);
                }
            }
        }
    }

    static void setPrefix(int node) {
        List<int[]> children = tree.get(node);
        if (children != null) {
            for (int[] edge : children) {
                int child = edge[0];
                int difficulty = edge[1];
                int enjoyment = edge[2];
                prefix[child] = prefix[node] + enjoyment;
                setPrefix(child);
            }
        }
    } //question, why are we doing this recusively?

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() { this(System.in, System.out); }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
