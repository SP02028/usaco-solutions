import com.sun.source.tree.Tree;
import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PS {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long K = kattio.nextLong();
        TreeMap<Long, Long> map = new TreeMap<>();
        long start = 0;

        for (int i = 0; i < N; i++) {
            long step = kattio.nextLong();
            char c = kattio.next().charAt(0);

            if (c == 'R') {
                map.put(start, map.getOrDefault(start, 0L) + 1L);
                start += step;
                map.put(start, map.getOrDefault(start, 0L) - 1L);
            } else {
                map.put(start, map.getOrDefault(start, 0L) - 1L);
                start -= step;
                map.put(start, map.getOrDefault(start, 0L) + 1L);
            }
        }

        long ans = 0;
        long prefX = map.isEmpty() ? 0 : map.firstKey();
        long sum = 0;

        for(long key : map.keySet()){
            long x = key;
            long y = map.get(key);
            if(sum >= K){
                ans += x - prefX;
            }
            sum += y;
            prefX = x;
        }

        kattio.println(ans);
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) { return null; }
                    this.st = new StringTokenizer(line);
                }
                return this.st.nextToken();
            } catch (Exception var2) { return null; }
        }
        public int nextInt() { return Integer.parseInt(this.next()); }
        public long nextLong() { return Long.parseLong(this.next()); }
    }
}
