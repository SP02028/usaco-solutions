import java.io.*;
import java.util.*;
public class SE {
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        String str1 = kattio.next();
        String str2 = kattio.next();
        int Q = kattio.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        while(Q-->0){
            String string = kattio.next();
            boolean letters[] = new boolean[18];
            for (int i = 0; i < string.length(); i++) {
                letters[string.charAt(i)-'a']=true;
            }
            int p1 = 0;
            int p2 = 0;
            boolean pos = true;
           while(p1<str1.length()&& p2<str2.length()) {
                if(str1.charAt(p1)==str2.charAt(p2)) {
                    p1++;
                    p2++;
                }
                else if(!letters[str1.charAt(p1)-'a']){
                    p1++;
                }
                else if(!letters[str2.charAt(p2)-'a']){
                    p2++;
                }
                else{
                    pos = false;
                    break;
                }

                }
            if(p1 == str1.length() && p2 == str2.length())
            {
                kattio.print("Y");
            }
            else{
                while(p1<str1.length() && !letters[str1.charAt(p1)-'a']){
                    p1++;
                }
                while(p2<str2.length() && !letters[str2.charAt(p2)-'a']){
                    p2++;
                }
                if(p1 == str1.length() && p2 == str2.length())
                {
                    kattio.print("Y");
                }
                else{
                    kattio.print("N");
                }
            }

        }

        kattio.println(stringBuilder);
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
