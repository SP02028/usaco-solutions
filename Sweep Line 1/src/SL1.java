import java.util.*;

public class SL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int N = sc.nextInt();

        // Build 2N endpoints: (x, type) where type = 0 for left, 1 for right
        int[][] points = new int[2 * N][2];

        for (int i = 0; i < N; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Fix: Store points at alternating sequential positions
            points[2 * i] = new int[]{l, 0};     // 0 = Left endpoint
            points[2 * i + 1] = new int[]{r, 1}; // 1 = Right endpoint
        }

        // Sort endpoints by x, and if x ties, process left (0) before right (1)
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Sweep-line execution
        int res = 0;
        int cnt = 0;

        for (int[] p : points) {
            if (p[1] == 0) {
                res += cnt; // Intersects with all currently active segments
                cnt++;
            } else {
                cnt--;
            }
        }

        System.out.println(res);
        sc.close();
    }
}
