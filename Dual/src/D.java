import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int T = io.nextInt();

        while (T-- > 0) {
            int n = io.nextInt();
            int[] arr = new int[n];

            int max = 0;
            boolean pos = false;
            for (int i = 0; i < n; i++) {
                arr[i] = io.nextInt();
                if (arr[i] > arr[max]) max = i;
                if (arr[i] > 0) pos = true;
            }
            List<int[]> ops = new ArrayList<>();
            if (!pos) {
                for (int i = n - 2; i >= 0; i--) {
                    ops.add(new int[]{i + 1, i + 2});
                    arr[i] += arr[i + 1];
                }
            }
            else {
                while (arr[max] <= 20) {
                    ops.add(new int[]{max + 1, max + 1});
                    arr[max] += arr[max];
                }
                for (int i = 0; i < n; i++) {
                    if (i == max) continue;
                    ops.add(new int[]{i + 1, max + 1});
                    arr[i] += arr[max];
                    ops.add(new int[]{i + 1, max + 1});
                    arr[i] += arr[max];

                    max = i;
                }
            }

            io.println(ops.size());
            for (int[] op : ops) {
                io.println(op[0] + " " + op[1]);
            }
        }

        io.close();
    }

    static class Kattio extends PrintWriter {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public Kattio() { super(System.out); }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
