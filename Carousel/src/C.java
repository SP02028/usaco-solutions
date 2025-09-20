import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (countval(arr, arr[0]) == n) {
                pw.println(1);
                for (int i = 0; i < n; ++i) {
                    pw.print(1 + " ");
                }
                pw.println();
                continue;
            }
            if (n % 2 == 0) {
                pw.println(2);
                for (int i = 0; i < n; ++i) {
                    pw.print((i % 2 + 1) + " ");
                }
                pw.println();
                continue;
            }
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == arr[(i + 1) % n]) {
                    int[] ans = new int[n];
                    int pos = i + 1;
                    while (pos < n) {
                        ans[pos] = (pos - (i + 1)) % 2 + 1;
                        pos++;
                    }
                    pos = i;
                    while (pos >= 0) {
                        ans[pos] = (i - pos) % 2 + 1;
                        pos--;
                    }
                    pw.println(2);
                    for (pos = 0; pos < n; pos++) {
                        pw.print(ans[pos] + " ");
                    }
                    pw.println();
                    found = true;
                    break;
                }
            }
            if (!found) {
                pw.println(3);
                for (int i = 0; i < n - 1; i++) {
                    pw.print((i % 2 + 1) + " ");
                }
                pw.println(3);
            }
        }
        pw.close();
    }
    private static int countval(int[] array, int val) {
        int count = 0;
        for (int v : array) {
            if (v == val) {
                count++;
            }
        }
        return count;
    }
}

