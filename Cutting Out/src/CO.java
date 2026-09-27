import java.io.*;
import java.util.*;
public class CO {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int K = kattio.nextInt();
        int[] arr = new int[N];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = kattio.nextInt();
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        int lo = 1;
        int hi = N/K;
        while(lo<hi){
            int mid = (lo+hi+1)/2;
            if(check(freq, mid, K)){
                //this works, search higher
                lo=mid;
            }else{
                //doesn't work, search lower
                hi = mid-1;
            }
        }
        int finalfreq = lo;
        int[] ans = new int[K];
        int pointer = 0;
        for (int key:freq.keySet()){
            if (pointer >= K) break;
            if(freq.get(key)/finalfreq >0){
                int val = freq.get(key)/finalfreq;
                while(val-->0) {
                    ans[pointer] = key;
                    pointer++;
                    if(pointer >=K)break;
                }
            }

        }
        for (int i = 0; i < K; i++) {
            kattio.print(ans[i] + " ");
        }
        kattio.close();
    }
    static boolean check(HashMap<Integer, Integer> freq, int c, int k){
        int temp = 0;
        for(int a: freq.values()){
            temp += a/c;
        }
        return temp >=k;
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
