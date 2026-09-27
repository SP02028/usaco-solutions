import java.io.*;
import java.util.*;

public class WB {
    static final int MAX_N = 20;

    static char[][] image = new char[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static int iMin, iMax, jMin, jMax;

    static void floodfill(int i, int j, char color) {
        if (i < iMin || j < jMin || i > iMax || j > jMax ||
                visited[i][j] || image[i][j] != color) {
            return;
        }

        visited[i][j] = true;

        floodfill(i + 1, j, color);
        floodfill(i - 1, j, color);
        floodfill(i, j + 1, color);
        floodfill(i, j - 1, color);
    }

    static boolean isPCL(int i1, int j1, int i2, int j2) {
        int[] regionCount = new int[26];

        iMin = i1;
        iMax = i2;
        jMin = j1;
        jMax = j2;

        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                if (!visited[i][j]) {
                    char c = image[i][j];
                    regionCount[c - 'A']++;
                    floodfill(i, j, c);
                }
            }
        }

        visited = new boolean[MAX_N][MAX_N];

        int colorCount = 0;
        boolean oneRegion = false;
        boolean multiRegion = false;

        for (int x : regionCount) {
            if (x != 0) colorCount++;
            if (x == 1) oneRegion = true;
            if (x > 1) multiRegion = true;
        }

        return colorCount == 2 && oneRegion && multiRegion;
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        for (int i = 0; i < n; i++) {
            String row = io.next();
            for (int j = 0; j < n; j++) {
                image[i][j] = row.charAt(j);
            }
        }

        List<PCL> pcls = new ArrayList<>();
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {

                        if (i2 < i1 || j2 < j1) continue;

                        if (isPCL(i1, j1, i2, j2)) {
                            pcls.add(new PCL(i1, j1, i2, j2));
                        }
                    }
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < pcls.size(); i++) {
            boolean valid = true;
            for (int j = 0; j < pcls.size(); j++) {
                if (i == j) continue;
                if (pcls.get(i).isInside(pcls.get(j))) {
                    valid = false;
                    break;
                }
            }
            if (valid) ans++;
        }

        io.println(ans);
        io.close();
    }

    static class PCL {
        int i1, j1, i2, j2;
        PCL(int a, int b, int c, int d) {
            i1 = a; j1 = b; i2 = c; j2 = d;
        }

        boolean isInside(PCL o) {
            return i1 >= o.i1 && i2 <= o.i2 &&
                    j1 >= o.j1 && j2 <= o.j2;
        }
    }
    static class Kattio extends PrintWriter {
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
