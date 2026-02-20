import java.io.*;
import java.util.*;
public class SD {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int X = kattio.nextInt();
        int N =kattio.nextInt();
        long[] arr = new long[N];
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            arr[i] = kattio.nextInt();
            priorityQueue.add(arr[i]);
        }
        long cost = 0;
        while(priorityQueue.size()>1){
            long a=  priorityQueue.poll();
            long b = priorityQueue.poll();
            long val = a+b;
            cost+=val;
            priorityQueue.add(val);
        }
        kattio.println(cost);
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
