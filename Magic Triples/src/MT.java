import java.io.*;
import java.util.StringTokenizer;

public class MT {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int[] freq = new int[1000001];
            int[] arr = new int[N];
            long count =0;
            int max = -1;
            for (int i = 0; i < N; i++) {
                arr[i]=kattio.nextInt();
                freq[arr[i]]++;
                max = Math.max(max, arr[i]);
            }
            for (int i = 0; i <N; i++) {
             
                    count += (long) (freq[arr[i]] - 1) *(freq[arr[i]]-2);
                for (int j = 2; arr[i]*j*j<=max ; j++) {
                    count += (long) freq[arr[i] * j] *freq[arr[i]*j*j];
                }
            }
            kattio.println(count);
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
