import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Z {
    public static void main(String[] args) {
        Kattio kattio=new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N= kattio.nextInt();
            int[] arr = new int[N];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                arr[i] = kattio.nextInt();
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],1);
                }else{
                    map.compute(arr[i], (k, val) -> val + 1);
                }
            }
           int[] freq = new int[N+1];
            long ans =0;
            for (int i = N-2; i >=1 ; i--) {
                freq[arr[i+1]]++;
                long pairs = 0;
                for (int j = i-1; j >=0 ; j--) {
                    if(arr[i]==arr[j]){
                        ans+=pairs;
                    }
                    pairs +=freq[arr[j]];
                }
            }
            kattio.println(ans);
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
