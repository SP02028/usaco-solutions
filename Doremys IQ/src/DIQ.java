import java.util.*;
import java.io.*;

public class DIQ {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        String firstToken = kattio.next();
        if (firstToken == null) return;

        int T = Integer.parseInt(firstToken);
        while (T-- > 0) {
            int N = kattio.nextInt();
            long q = kattio.nextLong();
           StringBuilder sb = new StringBuilder();
           int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = kattio.nextInt();
            }
            int count = 0; //contests that reduce iq
            char[] res =new char[N ];
            for (int i = N-1; i >=0; i--) {
                //we process in reverse order to ensure that once the iq decreases, its AFTER she tests an easier contest earlier on
                //basically, decrement as late as possible so that we dont prevent her from testing easy contests earlier
                if(arr[i] <= count){ //iq is high enough so she tests the contest
                     res[i] = '1';
                } else if(arr[i] > count && count<q){ //iq is not high enough but has remaining iq
                    res[i] = '1';
                    count++;
                }else res[i] = '0';
            }
            kattio.println(new String(res));
        }
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
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
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}