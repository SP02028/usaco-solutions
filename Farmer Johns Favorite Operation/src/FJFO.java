import java.io.*;
import java.util.*;

public class FJFO {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while (T-- > 0) {
            int N = kattio.nextInt();
            int M = kattio.nextInt();
            long[] a = new long[N];
            for (int i = 0; i < N; i++) {
                long A = kattio.nextLong();
                a[i] = A % M; // only the remainder matters, shifting by a full M is free
            }

            // cost(x) as x sweeps around is piecewise linear - each term is
            // a triangle wave, 0 at its own remainder, peak at the opposite
            // side, straight lines in between. so the true minimum can only
            // live at one of these bend points. this map tracks how much
            // the SLOPE changes at each one - not the cost itself, that
            // gets built up in the sweep below.
            TreeMap<Long, Long> inflections = new TreeMap<>();

            for (long A : a) {
                inflections.put(A, inflections.getOrDefault(A, 0L) + 2); // valley, slope flips -1 to +1

                if (M % 2 == 1) {
                    // old buggy version of this block:
                    // int[] halves = {(M+1)/2, M/2};
                    // for (int h : halves) {
                    //     long x = (A >= h) ? A - h : A + h;
                    //     inflections.put(x, ... - 1);
                    // }
                    // this ran two SEPARATE branches and for some A they'd
                    // both land on the same point instead of two different
                    // adjacent ones. classic collapse bug.

                    // fix: get both points from ONE fractional peak value
                    // instead - floor and floor+1, guaranteed adjacent.
                    long lo = (A + (M - 1) / 2) % M;
                    long hi = (lo + 1) % M;
                    inflections.put(lo, inflections.getOrDefault(lo, 0L) - 1);
                    inflections.put(hi, inflections.getOrDefault(hi, 0L) - 1);
                } else {
                    long x = (A + M / 2) % M;
                    inflections.put(x, inflections.getOrDefault(x, 0L) - 2); // clean single peak
                }
            }

            inflections.putIfAbsent(0L, 0L); // anchors the sweep's start
            List<Long> points = new ArrayList<>(inflections.keySet());
            Collections.sort(points);

            long cost = 0;
            for (long A : a) cost += Math.min(A, M - A);

            // old buggy version of the starting slope:
            // int slope = 0;
            // for (long A : a) slope += (A >= M / 2.0) ? 1 : -1;
            // looked reasonable... but silently broke for whichever term's
            // peak pair happened to straddle the M-1/0 wraparound - that
            // term is actually FLAT there, not going up or down.

            // fix: just compute the real slope directly, no guessing.
            long costMinus1 = 0;
            if (M > 1) {
                for (long A : a) {
                    long d = Math.abs(A - (M - 1));
                    costMinus1 += Math.min(d, M - d);
                }
            } else {
                costMinus1 = cost;
            }
            long slope = cost - costMinus1;

            long best = cost;

            for (int i = 0; i < points.size() - 1; i++) {
                long x = points.get(i);
                slope += inflections.get(x);
                long dx = points.get(i + 1) - x;
                cost += slope * dx;
                best = Math.min(best, cost);
            }

            // old version just... stopped here. never closed the loop back
            // to x=0, so any minimum sitting in that last stretch got
            // skipped completely.
            long x = points.get(points.size() - 1);
            slope += inflections.get(x);
            cost += slope * (M - x);
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