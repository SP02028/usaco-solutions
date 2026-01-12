/**
 * Problem: Lifeguards
 * 
 * This solution determines the maximum time period that can be covered by lifeguards
 * after firing exactly one lifeguard. Uses sweep line algorithm with events.
 * 
 * Approach:
 * - Create arrival and departure events for each lifeguard
 * - Sort events by time (arrivals before departures at same time)
 * - Track which lifeguards are present at each time
 * - Calculate total covered time and time each lifeguard is alone
 * - Remove the lifeguard with minimum alone time
 * 
 * Time Complexity: O(N log N) for sorting events
 * Space Complexity: O(N) for storing events
 */
import java.io.*;
import java.util.*;

public class Li {
    /**
     * Main method that finds maximum coverage after removing one lifeguard.
     */
    public static void main(String[] args) throws IOException {
        Kattio kattio = new Kattio("lifeguards");
        int N = kattio.nextInt();
        long[][] events = new long[2 * N][3]; // time, type(arrival=1/departure=-1), id

        // Read lifeguard shifts and create events
        for (int i = 0; i < N; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            events[i][0] = a;
            events[i][1] = 1; // Arrival event
            events[i][2] = i;
            events[2 * N - 1 - i][0] = b;
            events[2 * N - 1 - i][1] = -1; // Departure event
            events[2 * N - 1 - i][2] = i;
        }

        // Sort events by time, with arrivals before departures at same time
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
        long[] alone = new long[N]; // Time each lifeguard is alone

        // Process events to calculate coverage and alone times
        for (long[] e : events) {
            long curr = e[0];
            if (present.size() > 0) {
                total += curr - prev;
            }
            if (present.size() == 1) {
                // This lifeguard is alone during this period
                alone[(int) (present.iterator().next())] += curr - prev;
            }
            if (e[1] == 1) {
                present.add((int) e[2]);
            } else {
                present.remove((int) e[2]);
            }
            prev = curr;
        }

        // Find minimum alone time and subtract from total
        Arrays.sort(alone);
        kattio.println(total - alone[0]);
        kattio.close();
    }

    /**
     * Custom I/O class for competitive programming.
     * Extends PrintWriter for output and uses BufferedReader for fast input.
     */
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input/output
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input/output
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
