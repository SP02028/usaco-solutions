import java.util.*;
import java.io.*;

public class SMM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Integer[] diffs = new Integer[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                diffs[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(diffs, Collections.reverseOrder());
            int count = 0;
            long sum = 0;

            while (count < k && sum + (N - diffs[count]) < N) {
                sum += (N - diffs[count]);
                count++;
            }

            pw.println(count);
        }
        pw.close();
    }
}
