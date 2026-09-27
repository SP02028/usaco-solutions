import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
public class ChladniFigure {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int n = kattio.nextInt();
        int m = kattio.nextInt();
        // HashMap<Integer, int[]> segs = new HashMap();
        HashSet<Long> segs = new HashSet<>();
        int[][] ogsegs = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            ogsegs[i][0] = a;
            ogsegs[i][1] = b;
            long hash = hash(a, b, n);
            segs.add(hash);
        }

        HashSet<Integer> divs = div(n);
        boolean found = false;
        for (int k : divs) {
            if (k == n) continue;
            boolean divvalid = true;
            for (int i = 0; i < m; i++) {
                int a = ogsegs[i][0];
                int b = ogsegs[i][1];
                int ra = (a + k - 1) % n + 1;
                int rb = (b + k - 1) % n + 1;
                // if(!segs.containsValue(new int[]{temp[0]+d, temp[1]+d})){
                long rh = hash(ra, rb, n);
                if (!segs.contains(rh)) {
                    divvalid = false;
                    break;
                }
            }
            if (divvalid) {
                found = true;
                break;
            }
        }
        if (found) kattio.println("Yes");
        else kattio.println("No");
        kattio.close();
    }
    static long hash(int a, int b, int n) {
        int p1 = Math.min(a,b);
        int p2 = Math.max(a,b);
        long hash = ((long)p2<<32)|p1;
        return hash;
    }

    static HashSet<Integer> div (int N){
        HashSet<Integer> d = new HashSet<>();
        for (int i = 1; i*i <=N ; i++) {
            if(N% i==0) {
                d.add(i);
                if (i * i != N) {
                    d.add(N / i);
                }
            }
        }
        return d;
    }


    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

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
