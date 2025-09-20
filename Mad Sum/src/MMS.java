import java.util.*;
import java.io.*;

public class MMS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());       
        for(int t = 0;t<tc;t++){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            boolean[] seen = new boolean[n + 1]; //store if num has been seen
            StringTokenizer st = new StringTokenizer(br.readLine());        
            for (int i = 1; i <= n; ++i) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            for (int i = 1; i <= n; ++i) {
                ans += a[i];
            }
            Arrays.fill(seen, false);
            int maxu = 0;
            for (int i = 1; i <= n; ++i) {
                if (seen[a[i]]) {
                    maxu = Math.max(maxu, a[i]);
                }
                seen[a[i]] = true;
                a[i] = maxu; //max val seen updated
            }

            for (int i = 1; i <= n; ++i) {
                ans += a[i];
            } //modified array is summed again
            Arrays.fill(seen, false);
            maxu = 0;
            for (int i = 1; i <= n; ++i) {
                if (seen[a[i]]) {
                    maxu = Math.max(maxu, a[i]);
                }
                seen[a[i]] = true;
                a[i] = maxu;
            }//same logic applied again to the modified array

            for (int i = 1; i <= n; ++i) {
                ans += (n - i + 1) * 1L * a[i];
            }//weighted sum

            pw.println(ans);
        }
        pw.close();
    }
}