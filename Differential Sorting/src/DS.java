import java.util.*;
import java.io.*;

public class DS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[len];

            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (arr[len - 1] < arr[len - 2]) {
                pw.println(-1);
                continue;
            }
            boolean greaterthanorequal = true;
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] >= arr[i - 1]) {
                    continue;
                } else {
                    greaterthanorequal = false;
                    break;
                }
            }
            if (greaterthanorequal) {
                pw.println(0);
                continue;
            }
            if (arr[len - 1] < 0) {
                pw.println(-1);
                continue;
            }

            pw.println(len - 2);
            for (int i = 0; i < len - 2; i++) {
                arr[i] = arr[len - 2] - arr[len - 1];
                int x = i + 1;
                int y = len - 1;
                int z = len;
                pw.println(x + " " + y + " " + z);
            }
        }
        pw.close();
    }
}

