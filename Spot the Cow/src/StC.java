import java.io.*;
import java.util.*;

public class StC {
    static int[][] cows;
    static boolean[][] seen;

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        cows = new int[N][N];
        seen = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = kattio.next();
            for (int j = 0; j < N; j++) {
                cows[i][j] = row.charAt(j);
            }
        }
        ArrayList<int[]> all = new ArrayList<>(); // {x1, y1, x2, y2}
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = i; k < N; k++) {
                    for (int l = j; l < N; l++) {
                        int[] temp = {i, j, k, l};
                        if (valid(temp)) all.add(temp);
                    }
                }
            }
        }

        int count = 0;
        for (int a = 0; a < all.size(); a++) {
            boolean maximal = true;
            for (int b = 0; b < all.size(); b++) {
                if (a != b && containssub(all.get(b), all.get(a))) {
                    maximal = false;
                    break;
                }
            }
            if (maximal) count++;
        }

        kattio.println(count);
        kattio.close();
    }
    public static boolean valid(int[] grid) {
        for (int i = grid[0]; i <= grid[2]; i++) {
            for (int j = grid[1]; j <= grid[3]; j++) {
                seen[i][j] = false;
            }
        }
        HashMap<Integer, Integer> regions = new HashMap<>();
        for (int i = grid[0]; i <= grid[2]; i++) {
            for (int j = grid[1]; j <= grid[3]; j++) {
                if (!seen[i][j]) {
                    regions.merge(cows[i][j], 1, Integer::sum);
                    if (regions.size() > 2) return false;
                    fill(i, j, cows[i][j], grid);
                }
            }
        }

        if (regions.size() != 2) return false;
        Iterator<Integer> it = regions.values().iterator();
        int a = it.next(), b = it.next();
        return (a == 1 && b >= 2) || (b == 1 && a >= 2);
    }
    static void fill(int i, int j, int color, int[] grid) {
        if (i < grid[0] || i > grid[2] || j < grid[1] || j > grid[3]) return;
        if (seen[i][j] || cows[i][j] != color) return;
        seen[i][j] = true;
        fill(i + 1, j, color, grid);
        fill(i - 1, j, color, grid);
        fill(i, j + 1, color, grid);
        fill(i, j - 1, color, grid);
    }

    // check if grid2 is within grid1
    public static boolean containssub(int[] grid1, int[] grid2) {
        return grid1[0] <= grid2[0] && grid1[1] <= grid2[1]
                && grid1[2] >= grid2[2] && grid1[3] >= grid2[3];
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}