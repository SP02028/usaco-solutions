import java.util.*;
import java.io.*;
public class PS{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);   
        int t = Integer.parseInt(br.readLine());
       for(int tc= 0;tc<t;tc++){
           StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 2;
            if (isSorted(a)) {
                ans = 0;
            } else if (a[0] == 1 || a[n - 1] == n) {
                ans = 1;
            } else if (a[0] == n && a[n - 1] == 1) {
                ans = 3;
            }
            pw.println(ans);
        }
        pw.close();
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

