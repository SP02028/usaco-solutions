import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TC {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int K = kattio.nextInt();
        int[][] tiles = new int[N][3];
        for (int i = 0; i < N; i++) {
            tiles[i][0] = kattio.nextInt();
            tiles[i][1] = kattio.nextInt();
            tiles[i][2] = i;
        }
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));

        TreeSet<int[]> active = new TreeSet<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int count = 0;
        int first = -1;
        int second = -1;
        int left = 0;

        for (int i = 0; i < N; i++) {
            int[] curr = tiles[i];

            // 1. Remove tiles that fall out of the X-axis sliding window range (width K)
            while (left < i && curr[0] - tiles[left][0] >= K) {
                active.remove(tiles[left]);
                left++;
            }

            int[] floor = active.floor(curr);
            while (floor != null && curr[1] - floor[1] < K) {
                count++;
                if (count > 1) {
                    kattio.println(-1);
                    kattio.close();
                    return;
                }
                first = curr[2];
                second = floor[2];
                floor = active.lower(floor);
            }

            int[] ceil = active.ceiling(curr);
            while (ceil != null && ceil[1] - curr[1] < K) {
                count++;
                if (count > 1) {
                    kattio.println(-1);
                    kattio.close();
                    return;
                }
                first = curr[2];
                second = ceil[2];
                ceil = active.higher(ceil);
            }
            active.add(curr);
        }

        if (count == 0) {
            kattio.println(0);
        } else {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            for (int i = 0; i < N; i++) {
                if (tiles[i][2] == first) {
                    x1 = tiles[i][0];
                    y1 = tiles[i][1];
                }
                if (tiles[i][2] == second) {
                    x2 = tiles[i][0];
                    y2 = tiles[i][1];
                }
            }
            long xoverlap = K - Math.abs(x1 - x2);
            long yoverlap = K - Math.abs(y1 - y2);
            kattio.println(xoverlap * yoverlap);
        }

        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }
                    this.st = new StringTokenizer(line);
                }
                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
