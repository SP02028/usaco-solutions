import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class FJACF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] v = new int[n + 1][3];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                v[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                v[i][2] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                v[i][0] = n - Integer.parseInt(st.nextToken()) - 1;
            }

            Arrays.sort(v, 1, n + 1, (a, b) -> Integer.compare(a[0], b[0]));

            int mxD = 0;
            int minbadD = Integer.MAX_VALUE;
            boolean ok = true;

            for (int i = 2; i <= n; i++) {
                if (v[i][1] <= v[i - 1][1]) {
                    if (v[i][2] > v[i - 1][2]) {
                        int rp = (v[i - 1][1] - v[i][1] + v[i][2] - v[i - 1][2]) / (v[i][2] - v[i - 1][2]);
                        mxD = Math.max(mxD, rp);
                    } else {
                        ok = false;
                    }
                } else {
                    if (v[i][2] < v[i - 1][2]) {
                        int rp = (v[i][1] - v[i - 1][1] + v[i - 1][2] - v[i][2] - 1) / (v[i - 1][2] - v[i][2]);
                        minbadD = Math.min(minbadD, rp);
                    }
                }
            }

            if (mxD >= minbadD || !ok) {
                pw.println(-1);
            } else {
                pw.println(mxD);
            }
        }

        pw.close();
    }
}



