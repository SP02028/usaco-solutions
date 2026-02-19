import java.io.*;
import java.util.*;

public class T {
    static class Fence {
        int x;
        int y;
        long heightsum;
        long basesum;
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int x, int y) {
            first = x;
            second = y;
        }

        public int compareTo(Pair x) {
            if (this.first == x.first) return this.second - x.second;
            return this.first - x.first;
        }
    }

    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {
Kattio io =new Kattio();
        int n = io.nextInt();
        Fence[] fences = new Fence[n];
        ArrayList<Pair>[] xcoords = new ArrayList[2 * 10000 + 1];
        ArrayList<Pair>[] ycoords = new ArrayList[2 * 10000 + 1];
        for (int i = 0; i < n; i++) {
            fences[i] = new Fence();
            fences[i].x =io.nextInt();
            fences[i].y = io.nextInt();

            if (xcoords[fences[i].x + 10000] == null)
                xcoords[fences[i].x + 10000] = new ArrayList<>();
            if (ycoords[fences[i].y + 10000] == null)
                ycoords[fences[i].y + 10000] = new ArrayList<>();

            xcoords[fences[i].x + 10000].add(new Pair(fences[i].y, i));
            ycoords[fences[i].y + 10000].add(new Pair(fences[i].x, i));
        }

        for (int i = 0; i <= 2 * 10000; i++) {
            if (xcoords[i] != null) {
                long cur = 0;
                Collections.sort(xcoords[i]);
    
                for (int j = 1; j < xcoords[i].size(); j++) {
                    cur += xcoords[i].get(j).first - xcoords[i].get(0).first;
                }
                fences[xcoords[i].get(0).second].heightsum = cur;
                for (int j = 1; j < xcoords[i].size(); j++) {
                    cur += (2 * j - xcoords[i].size()) *
                            (xcoords[i].get(j).first - xcoords[i].get(j - 1).first);
                    fences[xcoords[i].get(j).second].heightsum = cur;
                }
            }
        }
        for (int i = 0; i <= 2 * 10000; i++) {
            if (ycoords[i] != null) {
                long cur = 0;
                Collections.sort(ycoords[i]);
                for (int j = 1; j < ycoords[i].size(); j++) {
                    cur += ycoords[i].get(j).first - ycoords[i].get(0).first;
                }
                fences[ycoords[i].get(0).second].basesum = cur;
                for (int j = 1; j < ycoords[i].size(); j++) {
                    cur += (2 * j - ycoords[i].size()) *
                            (ycoords[i].get(j).first - ycoords[i].get(j - 1).first);
                    fences[ycoords[i].get(j).second].basesum = cur;
                }
            }
        }
        int totalArea = 0;
        for (int i = 0; i < n; i++) {
            totalArea += fences[i].heightsum * fences[i].basesum % MOD;
            totalArea %= MOD;
        }
        io.println(totalArea);
        io.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
