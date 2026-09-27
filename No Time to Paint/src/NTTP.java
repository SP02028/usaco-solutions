import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NTTP {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int N=kattio.nextInt();
        int Q = kattio.nextInt();
        String string = kattio.next();
        char[] str = new char[N+1];
        for (int i = 0; i < N; i++) {
            str[i+1] =  string.charAt(i);
        }

        int[] prefix = new int[N+1];
        boolean[] seen = new boolean[26];
        seen[str[1]-'A']=true;
        prefix[1] = 1;
        for (int i = 2 ;i <=N ; i++) {
            if(str[i]>str[i-1]){
                //this means that the next color is darker.
                seen[str[i]-'A']= true;
                seen[str[i-1]-'A']= true;
                prefix[i] =prefix[i-1]+1;
            }
            else if(str[i]==str[i-1]){
                prefix[i] = prefix[i-1];
            }
            else if(str[i-1]>str[i] && seen[str[i]-'A']){
                //the next color is lighter, but its been seen previously
                prefix[i] = prefix[i-1];
            } else{
                //the next color is lighter and has not been seen previously
                Arrays.fill(seen, false);
                seen[str[i]-'A'] = true;
                prefix[i] =prefix[i-1]+1;
            }
        }
        int[] suffix = new int[N+1];
        Arrays.fill(seen, false);
        seen[str[N]-'A']=true;
        suffix[N] = 1;

        for (int i = N ;i >1 ; i--) {
            if(str[i]<str[i-1]){
                //this means that the next color is darker.
                seen[str[i]-'A']= true;
                seen[str[i-1]-'A']= true;
                suffix[i-1] =suffix[i]+1;
            }
            else if(str[i]==str[i-1]){
                suffix[i-1] = suffix[i];
            }
            else if(str[i-1]<str[i] && seen[str[i-1]-'A']){
                //the next color is lighter, but its been seen previously
                suffix[i-1] = suffix[i];
            } else{
                //the next color is lighter and has not been seen previously
                Arrays.fill(seen, false);
                seen[str[i-1]-'A'] = true;
                suffix[i-1] =suffix[i]+1;
            }
        }
        for (int i = 0; i < Q; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            int prefixVal = (a - 1 >= 0) ? prefix[a - 1] : 0;
            int suffixVal = (b + 1 <= N) ? suffix[b + 1] : 0;
            kattio.println(prefixVal + suffixVal);
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
