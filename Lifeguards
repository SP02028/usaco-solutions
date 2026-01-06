import java.io.*;
import java.util.*;

public class Li {
    public static void main(String[] args) throws IOException{
        Kattio kattio = new Kattio("lifeguards");
        int N = kattio.nextInt();
        long[][] events = new long[2*N][3]; //time, type(a/d), id
        for (int i = 0; i < N; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            events[i][0] = a;
            events[i][1] = 1;
            events[i][2] = i;
            events[2*N-1-i][0] = b;
            events[2*N-1-i][1] = -1;
            events[2*N-1-i][2] = i;
        }
        Arrays.sort(events, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                } else {
                    return Long.compare(a[1], b[1]);
                }
            }
        });
        HashSet<Integer> present = new HashSet<Integer>();
        long prev = 0;
        long total = 0;
        long[] alone = new long[N];
        for(long[] e: events)
        {
            long curr = e[0];
            if(present.size()>0){
                total+=curr-prev;
            }
            if(present.size()==1){
                alone[(int) (present.iterator().next())] += curr-prev;
            }
            if(e[1] == 1){
                present.add((int)e[2]);
            }else{
                present.remove((int)e[2]);
            }
            prev=curr;
        }
        Arrays.sort(alone);
        kattio.println(total-alone[0]);
        kattio.close();
    }
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
}
