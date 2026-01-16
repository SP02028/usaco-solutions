import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = kattio.nextLong();
        }

        List<int[]> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                pairs.add(new int[] {i, stack.peek()});
                stack.pop();
            }
            if(!stack.isEmpty()){
                pairs.add(new int[] {stack.peek(), i});
            }
            stack.push(i);
        }

        long dists = 0;
        for (int i = 0; i < pairs.size(); i++) {
            dists += Math.abs(pairs.get(i)[1] - pairs.get(i)[0]) + 1;
        }

        kattio.println(dists);
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
