import java.util.*;
import java.io.*;
public class DivideAndEqualize {
    public static final int MAX = 1000001;
    public static int[] smallestprime = new int[MAX];
    public static void main(String[] args) {
        Kattio kattio =new Kattio();
        int T = kattio.nextInt();
        sieve();
        while(T-->0){
            int N = kattio.nextInt();
            int[] arr = new int[N];
            //how to efficiently check prime factors?
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int a = kattio.nextInt();
                List<Integer> factors = factorize(a);
                for(int e: factors){
                    if (freq.containsKey(e)){
                        int val = freq.get(e);
                        freq.put(e, val+1);
                    }else{
                        freq.put(e, 1);
                    }
                }
            }
            boolean pos = true;
            for(int v: freq.values()){
                if(v%N !=0){
                    pos=false;
                    break;
                }
            }
            if(pos) kattio.println("Yes");
            else kattio.println("No");
        }
        kattio.close();
    }
    public static List<Integer> factorize(int n){
        List<Integer> factors = new ArrayList<>();
        while(n>1){
            int factor = smallestprime[n];
            factors.add(factor);
            n/=factor;
        }
        return factors;
    }
    public static void sieve() {
        for (int i = 0; i < MAX; i++) {
            smallestprime[i] = i;
        }
        for (int i = 2; i * i < MAX; i++) {
            if (smallestprime[i] == i) {
                for (int j = i * i; j < MAX; j += i) {
                    if (smallestprime[j] == j) {
                        smallestprime[j] = i;
                    }
                }
            }
        }
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