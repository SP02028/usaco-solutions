import java.util.*;
import java.io.*;
public class SS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());    
        int tc = Integer.parseInt(st.nextToken());
        for(int t = 0;t<tc;t++) {
            int len = Integer.parseInt(br.readLine());
            int[] arr = new int[len];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int l = 0;
            for (int i = 0; i < len; i++) {
                int r = i - l + 1;
                while (arr[l] < r) {
                    l++;
                    r--;
                }
                pw.print(i - l + 1 + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}

