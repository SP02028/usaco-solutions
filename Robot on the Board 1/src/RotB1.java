import java.util.*;
import java.io.*;
public class RotB1 {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
       while(T-->0){
           int N =kattio.nextInt();
           int M = kattio.nextInt();
           String string =  kattio.next();
           int colcount = 0;
           int rowcount = 0;
           int minc=0;
           int maxc= 0;
           int maxr=0;
           int optr = 1;
           int optc = 1;
           int minr =0 ;
           for (int i = 0; i < string.length(); i++) {
               if(string.charAt(i)=='U') rowcount--;
               if(string.charAt(i)=='D') rowcount++;
               if(string.charAt(i)=='L') colcount--;
               if(string.charAt(i)=='R') colcount++;
               minr = Math.min(minr, rowcount);
               maxr= Math.max(maxr, rowcount);
               minc = Math.min(minc, colcount);
               maxc= Math.max(maxc, colcount);

               int RowS = maxr-minr+1;
               int ColS = maxc-minc+1;
               if(RowS>N ||ColS>M){
                   break;
               }
               optr = 1-minr;
               optc = 1-minc;
           }
           kattio.println(optr + " " + optc);
       }
       kattio.close();
    }
        static class Kattio extends PrintWriter {
            private BufferedReader r;
            private StringTokenizer st;
            // standard input
            public Kattio() { this(System.in, System.out); }
            public Kattio(InputStream i, OutputStream o) {
                super(o);
                r = new BufferedReader(new InputStreamReader(i));
            }
            // USACO-style file input
            public Kattio(String problemName) throws IOException {
                super(problemName + ".out");
                r = new BufferedReader(new FileReader(problemName + ".in"));
            }
            // returns null if no more input
            public String next() {
                try {
                    while (st == null || !st.hasMoreTokens())
                        st = new StringTokenizer(r.readLine());
                    return st.nextToken();
                } catch (Exception e) { }
                return null;
            }
            public int nextInt() { return Integer.parseInt(next()); }
            public double nextDouble() { return Double.parseDouble(next()); }
            public long nextLong() { return Long.parseLong(next()); }
        }
    }