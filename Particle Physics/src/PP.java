import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PP {
    static int N;
    static int[] X;
    static int[] Y;
    static int[] partner;
    static int[] next;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        X = new int[N + 1];
        Y = new int[N + 1];
        partner = new int[N + 1];
        next = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (X[j] > X[i] && Y[i] == Y[j]) {
                    if (next[i] == 0 || X[j] < X[next[i]]) {
                        next[i] = j;
                    }
                }
            }
        }
        System.out.println(backtrack());
    }

    public static int backtrack() {
        int i = 1;
        while (i <= N && partner[i] != 0) {
            i++;
        }
        if (i > N) {
            return hasCycle() ? 1 : 0;
        }

        int total = 0;
        for (int j = i + 1; j <= N; j++) {
            if (partner[j] == 0) {
                partner[i] = j;
                partner[j] = i;

                total += backtrack();

                partner[i] = 0; // Backtrack
                partner[j] = 0;
            }
        }
        return total;
    }

    public static boolean hasCycle() {
        for (int start = 1; start <= N; start++) {
            int curr = start;
            for (int step = 0; step < N; step++) {
                curr = next[partner[curr]];
                if (curr == 0) break;
            }
            if (curr != 0) return true;
        }
        return false;
    }
}
