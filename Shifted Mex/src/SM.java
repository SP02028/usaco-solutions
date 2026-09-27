import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SM {
public static void main(String[] args) {
    Kattio kattio =new Kattio();
    int t = kattio.nextInt();
    while(t-->0){
        int N = kattio.nextInt();
        HashSet<Long> set =  new HashSet<>();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i]=kattio.nextLong();
        }
        Arrays.sort(arr);
        long prev = arr[0];
        set.add(prev);
        int max = 1;
        for (int i = 1; i < N; i++) {
            long a = arr[i];
            if(a==prev+1||a==prev) {
                set.add(a);
                prev= a;
            }
            else {
                max = Math.max(set.size(), max);
                set.clear();
                set.add(a);
                prev=a;
            }
        }
        max = Math.max(set.size(),max);
        kattio.println(max);
    }
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
