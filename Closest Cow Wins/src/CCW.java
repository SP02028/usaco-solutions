import java.io.*;
import java.util.*;

public class CCW {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int K = io.nextInt();
        int M = io.nextInt();
        int N = io.nextInt();
        //Implementation outline
        // Treat each interval between Nhoj's cows as a single problem.
        // After computing the answer for each interval, we can select the N most optimal cow placements for our answer.

        long[] pos = new long[K];
        long[] T = new long[K];
        long[] fncows = new long[M]; //stores his cows

        for(int i=0;i<K; i++){
            long p = io.nextLong();
            long t= io.nextLong();
            pos[i] = p;
            T[i] = t;
        }
        for(int i=0;i<M;i++){
            fncows[i] = io.nextLong();
        }
        Integer[] ord = new Integer[K];
        for (int i = 0; i < K; i++) ord[i] = i;
        long[] finalPos = pos;
        Arrays.sort(ord, Comparator.comparingLong(i -> finalPos[i]));
        long[] sp = new long[K];
        long[] st = new long[K];
        for (int i = 0; i < K; i++) {
            sp[i] = pos[ord[i]];
            st[i] = T[ord[i]];
        }
        pos = sp;
        T = st;

        Arrays.sort(fncows);
        ArrayList<Long> gains = new ArrayList<>(2 * M + 2);

        int pi = 0;

        // if !seenany || seenall, take all the patches seen.
        // We can use a single cow to cut off Nhoj's cows on either edge.
        // These cows earn all the tastiness left of the leftmost Nhoj cow and right of the rightmost Nhoj cow.
        long left = 0;
        while (pi < K && pos[pi] < fncows[0]) {
            left += T[pi];
            pi++;
        }
        gains.add(left);

        // now for middle cows
        // Middle Intervals
        // We have a one-cow and a two-cow answer for each middle interval.
        for (int i = 0; i < M - 1; i++) {
            long L = fncows[i];
            long R = fncows[i + 1];
            long gap = R - L;
            int start = pi;
            long total = 0;
            while (pi < K && pos[pi] < R) {
                // pos[pi] > L automatically because pi has moved past all < fncows[0] and each interval advances pi
                total += T[pi];
                pi++;
            }
            int end = pi;
            if (start == end) continue; // no patches in this interval
            // For the one-cow answer, regardless of where the cow is placed,
            // it covers the same range that it beats Nhoj's cows.
            // We can thus use a sliding window to compute the maximum gain from a single cow
            // a single FJ cow can only win patches whose positions lie in an interval of width < gap/2
            // => 2*(pos[r]-pos[l]) < gap
            long best1 = 0;
            long sum = 0;
            int l = start;
            for (int j = start; j < end; j++) {
                sum += T[j];
                while (l <= j && 2L * (pos[j] - pos[l]) >= gap) {
                    sum -= T[l];
                    l++;
                }
                if (sum > best1) best1 = sum;
            }
            // For the two-cow answer, we can place cows right before both of Nhoj's cows,
            // thus gaining all the tastiness in the interval.
            // We then calculate the gain from adding the second cow to be:
            // (two-cow tastiness) minus (one-cow tastiness).
            gains.add(best1);
            gains.add(total - best1);
        }

        long right = 0;
        while (pi < K) {
            right += T[pi];
            pi++;
        }
        gains.add(right);
        gains.sort(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0; i < N && i < gains.size(); i++) ans += gains.get(i);

        io.println(ans);
        io.close();
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
