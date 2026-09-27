import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RCAST {
    public static void main(String[] args) {
    Kattio kattio = new Kattio();
    int N = kattio.nextInt();
    int K = kattio.nextInt();
    int[] arr = new int[N+2];
        for (int i = 0; i < K; i++) {
            int a = kattio.nextInt();
            int b=kattio.nextInt();
            arr[a]++;
            arr[b+1]--;
        }
        int[] pref =  new int[N+2];
        for (int i = 1; i <=N; i++) {
            pref[i]=arr[i]+pref[i-1];
        }
        Arrays.sort(pref);
        int[] arr2 = new int[N];
        for (int i = 2; i <N+2 ; i++) {
            arr2[i-2] = pref[i];
        }
        kattio.println(arr2[N/2]);
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
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }

                    this.st = new StringTokenizer(line);
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
