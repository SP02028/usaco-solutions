import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EVT {
 //   static int[] freqa=new int[21];
 //   static int[] freqb=new int[21];
    static long[] ans = new long[41];
    public static void main(String[] args) {
        /*
Use the stored counts from the second half to update the final answer for the combined subset size.
Print the answers for all K.

         */
        Kattio kattio = new Kattio();

        int N=kattio.nextInt();
        int destx = kattio.nextInt();
        int desty=  kattio.nextInt();
        // Split the list into two halves.
        int[][] half1 = new int[N/2][2];
        int[][] half2 = new int[N-N/2][2];
        for (int i = 0; i < N/2; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            half1[i][0] = a;
            half1[i][1] = b;
        }
        for (int i = N/2; i < N; i++) {
            int a = kattio.nextInt();
            int b = kattio.nextInt();
            half2[i-N/2][0] = a;
            half2[i-N/2][1] = b;
        }
        HashMap<String, int[]> A = new HashMap<>();
        HashMap<String, int[]> B = new HashMap<>();
        // For each half, generate every subset with bitmasks.
        int len1 = N / 2;
        for (int i = 0; i < (1 << len1); i++) {
            int currx = 0;
            int curry = 0;
            int subsetsize = 0;
            for (int j = 0; j < len1; j++) {
                //For each subset, compute its total movement and how many instructions it uses.
                if (((i >> j) & 1) == 1) { // Check if the j-th bit is set
                    currx += half1[j][0];
                    curry += half1[j][1];
                    subsetsize++;
                }
            }
            //Store counts of how many subsets reach each movement for each subset size.
            String key = currx + "," + curry;
            A.putIfAbsent(key, new int[len1 + 1]);
            A.get(key)[subsetsize]++;
        }
        int len2 = N - N / 2;
        for (int i = 0; i < (1 << len2); i++) {
            int currx = 0;
            int curry = 0;
            int subsetsize = 0;
            for (int j = 0; j < len2; j++) {
                //For each subset, compute its total movement and how many instructions it uses.
                if (((i >> j) & 1) == 1) { // Check if the j-th bit is set
                    currx += half2[j][0];
                    curry += half2[j][1];
                    subsetsize++;
                }
            }
            //Store counts of how many subsets reach each movement for each subset size.
            String key = currx + "," + curry;
            B.putIfAbsent(key, new int[len2 + 1]);
            B.get(key)[subsetsize]++;
        }
//Then, for each movement from the first half, compute the needed complementary movement from the second half.
        /*Then, when combining the two halves, you iterate over each stored key from the first half, compute the
 complementary key needed from the second half, and if that complementary key exists, you combine the two count arrays.
  if half A has c1 ways to reach some offset using i instructions, and half B has c2 ways to reach the needed
   complementary offset using j instructions, then those contribute c1 × c2 ways to the answer for K = i + j.*/
        for (String key : A.keySet()) {
            String[] parts = key.split(",");
            int needx = destx - Integer.parseInt(parts[0]);
            int needy = desty - Integer.parseInt(parts[1]);
            String needkey = needx + "," + needy;
            if(!B.containsKey(needkey)) continue;
            else{
                for (int i = 0; i <= N/2; i++) {
                    for (int j = 0; j <= N-N/2; j++) {
                        ans[i+j] += (long) A.get(key)[i] * B.get(needkey)[j];
                    }
                }
            }
        }
        long total = 0;
        for (int i=1;i<=N;i++) {
            kattio.println(ans[i]);
        }

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
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
