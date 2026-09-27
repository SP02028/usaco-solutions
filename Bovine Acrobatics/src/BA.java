import java.io.*;
import java.util.*;

public class BA {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N= kattio.nextInt();
        int M = kattio.nextInt();
        int K = kattio.nextInt();
        int[][] groups = new int[N][2];
        for (int i = 0; i < N; i++) {
            groups[i][0] = kattio.nextInt();
            groups[i][1] = kattio.nextInt();
        }
        Arrays.sort(groups, Comparator.comparingInt(g-> g[0]));

        Deque<long[]> towers = new ArrayDeque<>();
        towers.addFirst(new long[] {(long) -1e18, M});
        long ans = 0;
        for(int[] g: groups){
            long w = g[0];
            long a = g[1];
            long remaining = a;
            while(!towers.isEmpty()&& remaining>0 && w-K>= towers.peekFirst()[0]){
                long[] top = towers.peekFirst();
                if(top[1]> remaining){
                    top[1] -=remaining;
                    remaining=0;
                }
                else {
                    remaining-=top[1];
                    towers.pollFirst();
                }
            }
          long used = a-remaining;
            if(used>0){
                towers.addLast(new long[] {w, used});
                ans += used;
            }
        }
        kattio.println(ans);
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
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
