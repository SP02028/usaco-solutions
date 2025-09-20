import java.util.*;
import java.io.*;

public class HH {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for(int t =0; t<tc;t++){
            int len = Integer.parseInt(br.readLine());
            char[] s = br.readLine().toCharArray();
            long[] ans = new long[len + 1];
            int ri = len - 1;
            int las;
            int ls = 0;
            for (int i = 1; i <= len; i++) {
                las = len - i;
                if (s[las] == '0') {
                    ans[i] = ans[i - 1];
                } else {
                    if (ans[i - 1] == 0) {
                        ri = las;
                    }
                    while (ri >= 0 && s[ri] == '1') {
                        ri--;
                    }
                    if (ri < 0) {
                        ls = i;
                        ans[i] = -1;
                        for (int j = i + 1; j <= len; j++) {
                            ans[j] = -1;
                        }
                        break;
                    } else {
                        s[las] = '0';
                        s[ri] = '1';
                        ans[i] = ans[i - 1] + las - ri;
                    }
                }
            }
            for (int i = 1; i <= len; i++) {
                pw.print(ans[i]);
                if (i == len) {
                    pw.println();
                } else {
                    pw.print(" ");
                }
            }
        }
        pw.close();
    }
}