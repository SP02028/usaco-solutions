import java.io.*;
import java.util.*;

public class TB1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        long total = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < N; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                total += (end - start);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        total += (end - start);

        double totallen = total * Math.sqrt(2);
        System.out.printf("%.3f\n", totallen);

        br.close();
    }
}
