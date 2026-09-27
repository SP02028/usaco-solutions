import java.io.*;
import java.util.*;
public class RaP {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T= kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            int[] arr = new int[N];
            int[] indices = new int[N+1];
            for (int i = 1; i <=N ; i++) {
                int a = kattio.nextInt();
                arr[i-1] = a;
                indices[a] = i;
            }
            int pos = -1;
            for (int i = 0; i < N; i++) {
                if(arr[i] !=N-i){
                    pos=i;
                    break;
                }
            }
            if(pos==-1){
                for(int a: arr){
                    kattio.print(a + " ");
                }
                kattio.println();
                continue;
            }
            int bestval = -1;
            int bestidx= -1;
            for(int i = pos; i <N;i++){
                if(arr[i] > bestval){
                    bestval = arr[i];
                    bestidx=i;
                }
            }
            while(pos<bestidx){
                int temp = arr[pos];
                arr[pos] = arr[bestidx];
                arr[bestidx] = temp;
                pos++;
                bestidx--;
            }
            for(int a: arr){
                kattio.print(a + " ");
            }
            kattio.println();
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Input and output as System.in and System.out 
        public Kattio() {
            this(System.in, System.out);
        }

        // Input and output streams
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // Read the next token
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

        // Next integer
        public int nextInt() {
            return Integer.parseInt(next());
        }

        // Next long
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
