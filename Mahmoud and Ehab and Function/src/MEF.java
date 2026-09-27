import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

public class MEF {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N= kattio.nextInt();
        int M = kattio.nextInt();
    int Q = kattio.nextInt();
    long[] A = new long[N];
    long[] B = new long[M];
    int[][] queries = new int[Q][3];
        for (int i = 0; i < N; i++) {
            A[i] = kattio.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i] = kattio.nextInt();
        }
        for (int i = 0; i < Q; i++) {
            queries[i][0] = kattio.nextInt()-1;
            queries[i][1] = kattio.nextInt()-1;
            queries[i][2] = kattio.nextInt();
        }
        long val = 0;
        for (int i = 0; i < N; i++) {
            if(i%2==0){
                val+=A[i];
            }else{
                val +=-A[i];
            }
        }
            // Calculate the odd and even prefix sums
            long[] odd_b = new long[M];
            long[] even_b = new long[M];
            
            for (int i = 0; i < M; i++) {
                if ((i & 1) == 1) {
                    odd_b[i] = B[i];
                } else {
                    even_b[i] = B[i];
                }
                
                if (i > 0) {
                    odd_b[i] += odd_b[i - 1];
                    even_b[i] += even_b[i - 1];
                }
            }
            
            // Calculate segment sums for all windows of size N in array B
            TreeSet<Long> altsums = new TreeSet<>();
            
            for (int i = 0; i <= (M - N); i++) {
                long sum_even = even_b[i + N - 1] - (i > 0 ? even_b[i - 1] : 0);
                long sum_odd = odd_b[i + N - 1] - (i > 0 ? odd_b[i - 1] : 0);
                
                // If we started on an odd index, invert the operations
                if ((i & 1) == 1) {
                    altsums.add(sum_odd - sum_even);
                } else {
                    altsums.add(sum_even - sum_odd);
                }
            }
            
            Long left = altsums.floor(val);
        Long right = altsums.ceiling(val);
        if((left != null) && (right != null)){
            long leftres = Math.abs(val-left);
            long rightres = Math.abs(val-right);
            kattio.println(Math.min(leftres, rightres));
        } else if (left!=null) {
            kattio.println(Math.abs(val-left));
        }else{
            kattio.println(Math.abs(val-right));
        }
        for (int i = 0; i < Q; i++) {
            int range = queries[i][1] - queries[i][0]+1;
            if(range%2 !=0){
                if(queries[i][0]%2==0){
                    val+=queries[i][2];
                }
                else {
                    val-= queries[i][2];
                }
            }
            Long leftone = altsums.floor(val);
            Long rightone = altsums.ceiling(val);
            if(leftone!=null && rightone!=null){
                long leftres = Math.abs(val-leftone);
                long rightres = Math.abs(val-rightone);
            kattio.println(Math.min(leftres,rightres));
            }else if(leftone!=null){
                kattio.println(Math.abs(val-leftone));
            }
            else{
                kattio.println(Math.abs(val-rightone));
            }
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

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
