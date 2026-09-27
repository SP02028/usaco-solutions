import java.io.*;
import java.util.*;

public class FJFO2 {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T= kattio.nextInt();
        while(T-->0)
        {
            int N = kattio.nextInt();
            int M = kattio.nextInt();
            long[] a = new long[N];
            for (int i = 0; i < N; i++) {
                long A = kattio.nextLong();
                a[i] = A%M;
            }
            //inflections[x] = change in slope at x
            TreeMap<Long, Long> inflections = new TreeMap<>();

            for (long A : a) {
                inflections.put(A, inflections.getOrDefault( A, 0L)+2);
                if(M%2==1){
                    // FIX: the true peak sits at the single fractional point
                    // A + M/2.0. Its floor and ceiling are two ADJACENT
                    // integers (lo, lo+1) - compute them directly as one
                    // pair instead of two independently-branching "A vs h"
                    // checks, which could collapse onto the same point.
                    long lo = (A + (M-1)/2) % M;
                    long hi = (lo + 1) % M;
                    inflections.put(lo, inflections.getOrDefault(lo, 0L) - 1);
                    inflections.put(hi, inflections.getOrDefault(hi, 0L) - 1);
                }else{
                    long half = M/2;
                    long x = (A + half) % M;
                    inflections.put(x, inflections.getOrDefault(x, 0L) - 2);
                }

            }
            inflections.putIfAbsent(0L, 0L);
            List<Long> points = new ArrayList<>(inflections.keySet());
            Collections.sort(points);

            // Cost at x = 0
            long cost = 0;
            for (long A  : a) {
                cost += Math.min(A, M - A);
            }

            // FIX: the old "A >= M/2.0 ? +1 : -1" shortcut assumed every
            // term is cleanly ascending or descending as it crosses x=0.
            // That breaks when a term's peak pair straddles the 0/M-1
            // boundary itself (its two flat peak-neighbors ARE M-1 and 0,
            // so slope there is actually 0, not +-1). Instead, compute the
            // true entering slope directly: it's just the cost difference
            // between x=0 and x=M-1, computed the same way as `cost` above.
            long costMinus1 = 0;
            if (M > 1) {
                for (long A : a) {
                    long x = M - 1;
                    long d = Math.abs(A - x);
                    costMinus1 += Math.min(d, M - d);
                }
            } else {
                costMinus1 = cost; // M=1: everything is congruent, no wraparound distinction
            }
            long slope = cost - costMinus1;

            long best = cost;
            // Sweep
            for (int i = 0; i < points.size() - 1; i++) {
                long x = points.get(i);
                slope += inflections.get(x);
                long dx = points.get(i + 1) - x;
                cost += slope * dx;
                best = Math.min(best, cost);
            }
            // Wraparound: close the loop from the last candidate back to M (=0)
            long x = points.get(points.size()-1);
            slope += inflections.get(x);
            long dx = M-x;
            cost += slope * dx;
            best = Math.min(best, cost);

            kattio.println(best);
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
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
            } catch (Exception e) { return null; }
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
