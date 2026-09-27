import java.io.*;
import java.util.*;
public class MH {
public static void main(String[] args) {
    Kattio io = new Kattio();
    int T= io.nextInt();
    while(T-->0){
        int N = io.nextInt();
        int[] freq = new int[26];
        for (int i=0; i<=2*N; i++) {
            char[] c = io.next().toCharArray();
            for (char x : c) {
                freq[x-'a']++;
            }
        }

        for (int i=0; i<26; i++) {
            if (freq[i]%2==1) {
                io.println((char)('a'+i));
            }
        }
    }
    io.close();
}


    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public long nextLong() {
            // TODO Auto-generated method stub
            return Long.parseLong(next())	;	}
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public int nextInt() { return Integer.parseInt(next()); }
    }
}
