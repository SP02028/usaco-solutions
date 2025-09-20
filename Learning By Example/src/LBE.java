import java.io.*;
import java.util.*;

public class LBE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        List<long[]> V = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String buf = st.nextToken();
            long w = Long.parseLong(st.nextToken());
            V.add(new long[]{w, buf.charAt(0) == 'S' ? 1 : 0});
        }

        V.add(new long[]{Long.MIN_VALUE, 0});
        V.add(new long[]{Long.MAX_VALUE, 0});
        V.sort(Comparator.comparingLong(a -> a[0]));

        long ans = 0;
        for (int i = 0; i + 1 < V.size(); i++) {
            long S = V.get(i)[0];
            long E = V.get(i + 1)[0];
            long M = (S + E) / 2;

            if (V.get(i)[1] == 1) {
                long s = Math.max(A, S + 1);
                long e = Math.min(B, M);
                if (e >= s) {
                    ans += e - s + 1;
                }
            }

            if (V.get(i + 1)[1] == 1) {
                long s = Math.max(A, M + 1);
                long e = Math.min(B, E);
                if (e >= s) {
                    ans += e - s + 1;
                }
            }

            if (V.get(i + 1)[1] == 1 && V.get(i)[1] == 0 && (S % 2) == (E % 2) && A <= M && M <= B) {
                ans++;
            }
        }

        out.println(ans);
        out.flush();
    }
}

