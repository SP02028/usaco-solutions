import java.io.*;
import java.util.*;

public class RR {

    static int N;
    static int[][] dif;
    static int[] ans;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        N = io.nextInt();
        dif = new int[N][N];

        // dif[i][j] = max(a[i..i+j]) - min(a[i..i+j])
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                dif[i][j] = io.nextInt();
            }
        }

        ans = new int[N];

        for (int i = N - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] + dif[i][1];
            if (!ok(i)) {
                ans[i] = ans[i + 1] - dif[i][1];
                // guaranteed valid
            }
        }

        for (int i = 0; i < N; i++) {
            io.print(ans[i] + (i + 1 == N ? "\n" : " "));
        }
        io.close();
    }

    static boolean ok(int i) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int j = i; j < N; j++) {
            mx = Math.max(mx, ans[j]);
            mn = Math.min(mn, ans[j]);
            if (mx - mn != dif[i][j - i]) {
                return false;
            }
        }
        return true;
    }

    // Kattio
    static class Kattio extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        Kattio() {
            super(new BufferedOutputStream(System.out));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}