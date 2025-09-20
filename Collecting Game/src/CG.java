import java.io.*;
import java.util.*;

public class CG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][2];          
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = i;
            }         
            Arrays.sort(arr, 1, n + 1, Comparator.comparingInt(a -> a[0]));          
            int[] next = new int[n + 1];
            long[] sum = new long[n + 1];
            int[] ans = new int[n + 1];           
            next[0] = 0;
            sum[0] = 0;            
            for (int i = 1; i <= n; i++) {
                if (next[i - 1] >= i) {
                    next[i] = next[i - 1];
                    sum[i] = sum[i - 1];
                } else {
                    sum[i] = sum[i - 1] + arr[i][0];
                    next[i] = i;
                    while (next[i] + 1 <= n && sum[i] >= arr[next[i] + 1][0]) {
                        next[i]++;
                        sum[i] += arr[next[i]][0];
                    }
                }
                ans[arr[i][1]] = next[i];
            }
            
            for (int i = 1; i <= n; i++) {
                pw.print((ans[i] - 1) + " ");
            }
            pw.println();
        }
        pw.close();
    }
}
