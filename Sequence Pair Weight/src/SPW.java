import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SPW {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = kattio.nextInt();
            }

            long[] weight = new long[N];
            HashMap<Integer,Long>map = new HashMap<>(); //prefix map
            long total =0;

            for (int i = 0; i < N; i++) {
                if(i>0){
                    weight[i] = weight[i-1]; //carries over total weight calculated by previous prefix
                }
                long currpref = map.getOrDefault(arr[i], 0L); //cumulative sum for all previous weights w/ same val as curr
                weight[i] += currpref; //new contribution to total weight
                map.put(arr[i], currpref+1+i);// update the sum by adding the one based index
                total += weight[i];//update total
            }
            kattio.println(total);
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
