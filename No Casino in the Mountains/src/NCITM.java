import java.io.*;
import java.util.*;

public class NCITM {
	//bro speedrun time
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
           	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
           int count = 0;
            int i = 0;
            while (i <= n - k) {
                boolean canHike = true;
                for (int j = 0; j < k; j++) {
                    if (a[i + j] != 0) {
                        canHike = false;
                        break;
                    }
                }
                if (canHike) {
                    count++;
                    i += k + 1;  
                } else {
                    i++;
                }
            }
            pw.println(count);
        }
        pw.close();
    }
}
