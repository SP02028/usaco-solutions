import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TBCCP {


    public static void main(String[] args) {
        //Core insight: Since bi & bj <= n, their sum <=2n.
        //Therefore ai * aj must also be <=2n
    Kattio kattio = new Kattio();
    int T= kattio.nextInt();
    while(T-->0){
        int N = kattio.nextInt();
        int[] count = new int[N+1];
        int[][] c = new int[N][2];
        for (int i = 0; i < N; i++) {
            c[i][0] = kattio.nextInt();
        }
        for (int i = 0; i < N; i++) {
            c[i][1] = kattio.nextInt();
        }
        long ans = 0;
        Arrays.sort(c, Comparator.comparingInt(a->a[0]));
        for (int i = 1; i*i <=2*N ; i++) {
            Arrays.fill(count, 0); //resets freq array
            for(int[] a: c){
                int e1 = a[0];
                int e2 = a[1];
                int v = e1*i-e2; //iterate over ai and solve for bi using bi + bj = ai*aj
                if(1<=v && v<=N){
                    ans +=count[v];
                }
                if(e1==i) count[e2]++; //only populate map with b values belonging to current ai & handles i<j constraingt
            }
        }
        kattio.println(ans);
    }
    kattio.close();
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
