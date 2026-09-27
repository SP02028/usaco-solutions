import java.io.*;
import java.util.*;

public class WS {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("wormsort");

        int cowNum = io.nextInt();
        int wormholeNum = io.nextInt();

        int[] cows = new int[cowNum];
        for (int c = 0; c < cowNum; c++) { cows[c] = io.nextInt() - 1; }

        int maxWidth = 0;
        List<int[]>[] neighbors = new ArrayList[cowNum];
        for (int c = 0; c < cowNum; c++) { neighbors[c] = new ArrayList<>(); }
        for (int w = 0; w < wormholeNum; w++) {
            int c1 = io.nextInt() - 1;
            int c2 = io.nextInt() - 1;
            int width = io.nextInt();
            neighbors[c1].add(new int[] {c2, width});
            neighbors[c2].add(new int[] {c1, width});
            maxWidth = Math.max(maxWidth, width);
        }

        int lo = 0;
        int hi = maxWidth + 1;
        int valid = -1;
        int[] component = new int[cowNum];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            Arrays.fill(component, -1);
            int currComp = 0;
            for (int c = 0; c < cowNum; c++) {
                if (component[c] != -1) { continue; }
                List<Integer> frontier = new ArrayList<>(Collections.singletonList(c));
                while (!frontier.isEmpty()) {
                    int curr = frontier.remove(frontier.size() - 1);
                    component[curr] = currComp;
                    for (int[] n : neighbors[curr]) {
                        if (component[n[0]] == -1 && n[1] >= mid) {
                            frontier.add(n[0]);
                        }
                    }
                }
                currComp++;
            }

            boolean sortable = true;
            for (int c = 0; c < cowNum; c++) {
                if (component[c] != component[cows[c]]) {
                    sortable = false;
                    break;
                }
            }

            if (sortable) {
                valid = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        io.println(valid == maxWidth + 1 ? -1 : valid);
        io.close();
    }

    //BeginCodeSnip{Kattio}
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
    //EndCodeSnip
}