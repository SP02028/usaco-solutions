import java.io.*;
import java.util.StringTokenizer;

public class GVIF {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int N = kattio.nextInt();
        int[] plants = new int[N];
        for (int i = 0; i < N; i++) {
            plants[i] = kattio.nextInt();
        }
        long[] left = new long[N];//left[i] = min increase to fix the pair i, i+1
        long[] right = new long[N]; //total increases needed on prefix to make array strictly decreasing after i
        for (int i = 0; i < N-1; i++) {
            if(plants[i] > plants[i+1]){
                left[i] = 0;
            }
            else{
                left[i] = plants[i+1]-plants[i]+1;
            }
        }
        left[N-1]=0;
        for (int i = N-1; i >0 ; i--) {
            if(plants[i] > plants[i-1]){
                right[i] =0;
            }else{
                right[i] = plants[i-1]-plants[i]+1;
            }
        }
        right[0] = 0;
        for (int i = 1; i <N ; i++) {
            right[i] +=right[i-1];
        }
        for (int i = N-2; i >=0 ; i--) {
            left[i] += left[i+1];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) { //iterate over all "peak" points
            min = Math.min(min, Math.max(left[i], right[i]));
        }
        kattio.println(min);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        @Override
        public void close() {
            super.close();
            try {
                r.close();
            } catch (IOException ignored) {
            }
        }
    }
}
