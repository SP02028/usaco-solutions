import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.*;
public class StF2 {

    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("split");
        int N = io.nextInt();
        long[][] cows = new long[N][2];
        for(int i =0;i<N;i++) {
            long x = io.nextLong();
            long y = io.nextLong();
            cows[i][0] = x;
            cows[i][1] = y;
        }
        long ans =0;
        for(int j=0;j<2;j++) {
            Arrays.sort(cows, Comparator.comparingLong(a -> a[0]));
            //compute prefix suffix max
            //one iteration is for x
            //one iteration is for y
            long[][] pref = new long[N][2];
            long[][] suff=  new long[N][2];
            //compute prefix min
            pref[0][0] = cows[0][1];
            pref[0][1] = cows[0][1];

            for(int i=1;i<N;i++) {
                pref[i][0] = Math.min(pref[i-1][0], cows[i][1]);
                pref[i][1] = Math.max(pref[i-1][1], cows[i][1]);
            }
            suff[N-1][0] = cows[N-1][1];
            suff[N-1][1] = cows[N-1][1];

            for(int i=N-2;i>=0;i--) {
                suff[i][0] = Math.min(suff[i+1][0], cows[i][1]);
                suff[i][1] = Math.max(suff[i+1][1], cows[i][1]);
            }

            long initarea = Math.abs((cows[N-1][0] -cows[0][0])) * Math.abs((pref[N-1][1] - pref[N-1][0]));
            //	System.out.println("cN-10" + cows[N-1][0]);
            //	System.out.println("c00" + cows[0][0]);
            //	System.out.println("cN-11" + cows[N-1][1]);
            //	System.out.println("cN-10" + cows[N-1][0]);
            //	System.out.println("ia" + initarea);
            long best = Long.MAX_VALUE;
            for(int i=0;i<N-1;i++) {
                if(cows[i][0] != cows[i+1][0]) {
                    long r1 = (cows[i][0]-cows[0][0])*(pref[i][1]-pref[i][0]);
                    long r2 = (cows[N-1][0]-cows[i+1][0])*(suff[i+1][1] - suff[i+1][0]);
                    best = Math.min(r1+r2, best);
                    //	System.out.println("b" + best);
                }
            }
            ans = Math.max(ans, initarea-best);

            //switch coordinates
            for(int i=0;i<N;i++) {
                long temp = cows[i][0];
                cows[i][0] = cows[i][1];
                cows[i][1] = temp;
            }
        }
        io.println(ans);
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
