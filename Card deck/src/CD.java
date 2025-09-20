import java.io.*;
import java.util.*;

public class CD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;    
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] index = new int[100005];          
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                index[a[i]] = i;
            }          
            int l = n;
            for (int i = n; i > 0; i--) {
                boolean flag = false;
                for (int j = index[i]; j < l; j++) {
                    pw.print(a[j] + " ");
                    flag = true;
                }
                if (flag) {
                	l = index[i];
                }
            }
            pw.println();
        }
        pw.close();
    }
}

