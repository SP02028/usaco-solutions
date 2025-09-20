import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] vals = {{1, 7}, {2, 7}, {3, 7}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] changes = new int[N][3];

        // Process input and store in changes array
        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            changes[i][0] = Integer.parseInt(s.nextToken());
            String name = s.nextToken();
            if (name.equals("Bessie")) {
                changes[i][1] = 1;
            } else if (name.equals("Mildred")) {
                changes[i][1] = 2;
            } else {
                changes[i][1] = 3;
            }
            changes[i][2] = Integer.parseInt(s.nextToken());
        }

        // Sort the array based on the first term (day)
        Arrays.sort(changes, Comparator.comparingInt((int[] arr) -> arr[0]));

        // Simulate the changes, if the max changes then add one to the count
        int count = 0;
        int[] oldmaxp = {1, 2, 3};
        int[] newmaxp = new int[3];
        for (int[] entry : changes) {
            if (entry[1] == 1) {
                vals[0][1] += entry[2];
            } else if (entry[1] == 2) {
                vals[1][1] += entry[2];
            } else {
                vals[2][1] += entry[2];
            }

            int newmaxval = Math.max(vals[0][1], Math.max(vals[1][1], vals[2][1]));
            int n = 0;
            Arrays.fill(newmaxp, 0);
            for (int[] ele : vals) {
                if (ele[1] == newmaxval) {
                    newmaxp[n] = ele[0];
                    n++;
                }
            }
            Arrays.sort(newmaxp, 0, n);
            if (!Arrays.equals(newmaxp, oldmaxp)) {
                count++;
                oldmaxp = Arrays.copyOf(newmaxp, newmaxp.length);
            }
        }

        System.out.println(count);
    }
}
