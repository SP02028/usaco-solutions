import java.util.*;
import java.io.*;

public class IS {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while (T-- > 0) {
            int N = kattio.nextInt();
            List<Integer[]> starts = new ArrayList<>();
            List<Integer[]> ends = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int s = kattio.nextInt();
                int e = kattio.nextInt();
                int c = kattio.nextInt();

                Integer[] start = new Integer[]{s, i, c, e};
                Integer[] end = new Integer[]{e, i, c, s};
                starts.add(start);
                starts.sort(Comparator
                        .comparingInt((Integer[] arr) -> arr[0])
                        .thenComparingInt(arr -> arr[2])
                );
                ends.add(end);
                ends.sort((a, b) -> {
                    if (!a[0].equals(b[0])) {
                        return b[0].compareTo(a[0]);
                    }
                    return a[2].compareTo(b[2]);
                });

                 if(Objects.equals(ends.getFirst()[3], starts.getFirst()[1])){
                    kattio.println(ends.getFirst()[0]);
                } else if(!Objects.equals(ends.getFirst()[1], starts.getFirst()[1])){
                     kattio.println(ends.getFirst()[2]+starts.getFirst()[2]);
                 }
                 else{
                     kattio.println(ends.getFirst()[2]);
                 }
            }
        }
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
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
                return null;
            }
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
