import java.io.*;
import java.util.*;
public class GalaxyLuck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] a = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    a[j][k] = Integer.parseInt(st.nextToken());
                }
            }
           long ans = 0;
            for (int j = 0; j < m; j++) {
                List<Long> temp = new ArrayList<>();
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    temp.add((long) a[k][j]);
                    sum += a[k][j];
                }
                long curr = 0;
                Collections.sort(temp);
                for (int k = 0; k < n; k++) {
                    curr += temp.get(k);
                    ans += Math.abs((sum - curr) - (n - 1 - k) * temp.get(k));
                }
            }
            pw.println(ans);
        }
        pw.close();
    }
}