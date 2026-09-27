import java.io.*;
import java.util.StringTokenizer;

public class DBMB {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int n = kattio.nextInt();
            int s = kattio.nextInt();
            int x= kattio.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int a = kattio.nextInt();
                sum+=a;
            }
            if(sum>s) {
                kattio.println("NO");
                continue;
            }
            if((s-sum)%x==0) kattio.println("YES");
            else kattio.println("NO");
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
    }
}
