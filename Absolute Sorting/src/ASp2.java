import java.util.*;
import java.io.*;

public class ASp2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int len = Integer.parseInt(br.readLine());
            int[] arr = new int[len];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int x = 0;
            for (int n = 1; n < len; n++) {
                if (arr[n - 1] > arr[n]) {
                    int sum = arr[n - 1] + arr[n];
                    x = Math.max(x, (sum + 1) / 2);
                }
            }

            boolean sorted = true;
            for (int j = 0; j < len; j++) {
                arr[j] = Math.abs(arr[j]-x);
            }
            
            for (int n = 0; n < len - 1; n++) {
                if (arr[n] > arr[n + 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                pw.println(x);
            } else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}
