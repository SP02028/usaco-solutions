import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] diff = new int[N + 2];
        TreeSet<Integer[]> seen = new TreeSet<>((a, b) -> {
            if (!a[0].equals(b[0])) return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A > B) {
                int temp = A;
                A = B;
                B = temp;
            }
            seen.add(new Integer[] {A,B});
                diff[A + 1] -= 1;
                diff[B] += 1;
            }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += diff[i];
            int currh = H + sum;
            System.out.println(currh);
        }
    }
}