import java.io.*;
import java.util.*;

public class RM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] prefix = new int[n + 2]; // prefix[i+1] = max up to i
            int[] suffix = new int[n + 3]; // suffix[i+1] = max from i
            prefix[0] = 0;
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = Math.max(prefix[i], arr[i] + i);
            }
            Arrays.fill(suffix, (int)-1e9); 
            for (int i = n - 1; i >= 0; i--) {
                suffix[i + 1] = Math.max(suffix[i + 2], arr[i] - i);
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans = Math.max(ans, prefix[i] + arr[i] + suffix[i + 2]);
            }
            pw.println(ans);
        }
        pw.close();
    }
}

