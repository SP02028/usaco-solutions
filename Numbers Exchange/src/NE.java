import java.io.*;
import java.util.*;

public class NE {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int M = kattio.nextInt();

        long[] a = new long[N];
        HashSet<Long> set = new HashSet<>();
        ArrayList<Integer> dups = new ArrayList<>();
        ArrayList<Integer> evensu = new ArrayList<>();
        ArrayList<Integer> oddsu = new ArrayList<>();

        long even = 0;
        long odd = 0;
        long exchange = 0;
        for (int i = 0; i < N; i++) {
            a[i] = kattio.nextLong();
            if (set.contains(a[i])) {
                dups.add(i);
            } else {
                set.add(a[i]);
                if (a[i] % 2 == 0) {
                    evensu.add(i);
                    even++;
                } else {
                    oddsu.add(i);
                    odd++;
                }
            }
        }

        Queue<Long> evenrep = new LinkedList<>();
        Queue<Long> oddrep = new LinkedList<>();
        for (long i = 1; i <= Math.min(M, 400000); i++) {
            if (!set.contains(i)) {
                if (i % 2 == 0) evenrep.add(i);
                else oddrep.add(i);
            }
        }

        while (even > N / 2) {
            dups.add(evensu.remove(evensu.size() - 1));
            even--;
        }
        while (odd > N / 2) {
            dups.add(oddsu.remove(oddsu.size() - 1));
            odd--;
        }
        for (int index : dups) {
            if (even < N / 2) {
                if (evenrep.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                a[index] = evenrep.poll();
                even++;
            } else {
                if (oddrep.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                a[index] = oddrep.poll();
                odd++;
            }
            exchange++;
        }

        kattio.println(exchange);
        for (int i = 0; i < N; i++) {
            kattio.print(a[i] + " ");
        }
        kattio.println();
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
