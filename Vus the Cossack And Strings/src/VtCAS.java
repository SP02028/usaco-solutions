import java.util.*;
import java.io.*;
public class VtCAS {
public static void main(String[] args) {
Kattio kattio =new Kattio();
String a = kattio.next();
String b = kattio.next();
int[] prefa = new int[a.length()+1];
    for (int i = 1; i <=a.length(); i++) {
        prefa[i] = prefa[i-1] + a.charAt(i-1)-'0';
    }
    int[] prefb = new int[b.length()+1];
    for (int i = 1; i <=b.length(); i++) {
        prefb[i] = prefb[i-1] + b.charAt(i-1)-'0';
    }
    int count =0 ;
    for (int i = 1; i <= a.length()-b.length()+1; i++) {
        int pa = prefa[i+b.length()-1]-prefa[i-1];
        int pb = prefb[b.length()];
        if(pa%2==pb%2) count++;
    }
    kattio.println(count);
    kattio.close();
}
    static class Kattio extends
            PrintWriter {
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
