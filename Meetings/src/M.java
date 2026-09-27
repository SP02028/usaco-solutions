import java.util.*;
import java.io.*;

public class M {

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int L = kattio.nextInt();
        int[][] cows = new int[N][3];
        int leftcows = 0;
        int totalweight =0;
        for (int i = 0; i < N; i++) {
            cows[i][0] = kattio.nextInt();
            cows[i][1] = kattio.nextInt();
            cows[i][2] = kattio.nextInt();
            if(cows[i][2]==-1)leftcows++;
            totalweight+=cows[i][0];
        }
        int rightcows = N-leftcows;
        Arrays.sort(cows, Comparator.comparingInt(a -> a[1]));
        int[] exittime = new int[N];
        HashSet<Integer> lefts = new HashSet<>();
        HashSet<Integer> rights = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if(cows[i][2]==-1){
                exittime[i] = cows[i][1];
                lefts.add(i);
            }
            else{
                exittime[i] = L- cows[i][1];
                rights.add(i);
            }
        }
        int[] leftexittimes = new int[lefts.size()];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(lefts.contains(i)) {
                leftexittimes[count] = exittime[i];
                count++;
            }
        }
        int[] rightexittimes = new int[rights.size()];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            if(rights.contains(i)) {
                rightexittimes[count2] = exittime[i];
                count2++;
            }
        }
        Arrays.sort(rightexittimes);
        Arrays.sort(leftexittimes);

        int[] realexittime = new int[N];
        for (int i = 0; i < leftcows; i++) {
            realexittime[i]=leftexittimes[i];
        }
        for (int i = 0; i < rightcows; i++) {
            realexittime[N-1-i]=rightexittimes[i];
        }

        // find T: sort ranks by realexittime, accumulate weight until >= totalweight/2
        Integer[] rankOrder = new Integer[N];
        for (int i = 0; i < N; i++) rankOrder[i] = i;
        Arrays.sort(rankOrder, Comparator.comparingInt(a -> realexittime[a]));

        int T = 0;
        long cumweight = 0;
        for (int i = 0; i < N; i++) {
            int rank = rankOrder[i];
            cumweight += cows[rank][0]; // weight of whichever cow is at this rank
            if (cumweight*2 >= totalweight) {
                T = realexittime[rank];
                break;
            }
        }

        // count collisions with crossing time <= T
        // pair (i,j), i<j by rank, direction[i]=+1, direction[j]=-1
        // crossing = (cows[j][1]-cows[i][1])/2 <= T  <=>  cows[i][1] >= cows[j][1]-2*T
        int collisions = 0;
        int ptrLo = 0;
        int plusCountInWindow = 0;
        for (int j = 0; j < N; j++) {
            if (cows[j][2] == 1) {
                plusCountInWindow++;
            } else {
                int threshold = cows[j][1] - 2*T;
                while (ptrLo < j && cows[ptrLo][1] < threshold) {
                    if (cows[ptrLo][2] == 1) plusCountInWindow--;
                    ptrLo++;
                }
                collisions += plusCountInWindow;
            }
        }

        kattio.println(collisions);
        kattio.close();
    }


    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public long nextLong() {
            // TODO Auto-generated method stub
            return Long.parseLong(next())   ;  }
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