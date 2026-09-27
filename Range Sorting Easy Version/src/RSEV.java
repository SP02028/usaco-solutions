import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class RSEV {
    public static void main(String[] args) {
    //Solution:
        //Obs 1: A subarray will be divided into non overlapping subarrays and we will apply a range sort to each subarray
        //Obs 2: If l < i1< i2<...<ik<r, then we can sort subarrays a[l...i1, a[i1+1... i2]... a[ik+1...r] independently if and only
        //if the max of the previous subarray is less than the min of the current subarray for all subarrays.
        //Therefore, the answer for a subarray a[l...r] = r-l - (#k such that l<=k<r and max of the previous subarray is less than the min of the current subarray for all subarrays.)
        //a triplet (l, k, r) satisfies if k is the closest position to the left of i satisfying ak<ai.
        //if x is the closest pos left of k such that ax>ai and y is the closest pos right of i such that ay<ai, we add (k-x)*(y-i) to
        //ans if the triplet is valid.
        //We find such values of x, k, y for each i.
        Kattio kattio = new Kattio();
        int T =kattio.nextInt();
        while(T-->0) {
            int N = kattio.nextInt();
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = kattio.nextLong();
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                ArrayList<Long> a = new ArrayList<>();
                a.add(arr[i]);
                for (int j = i + 1; j < N; j++) {
                    long ele = arr[j];
                    if (a.isEmpty() || ele > a.get(a.size() - 1)) {
                        a.add(ele);
                    } else {
                        long max = a.remove(a.size() - 1);
                        while (!a.isEmpty() && ele < a.get(a.size() - 1)) {
                            a.remove(a.size() - 1);
                        }
                        a.add(max);
                    }
                    int len = j - i + 1;
                    int num = a.size();
                    ans += len - num;
                }
            }
            kattio.println(ans);
        }
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
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
