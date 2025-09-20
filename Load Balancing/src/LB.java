import java.io.*;
import java.util.*;
public class LB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter("balancing.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        List<int[]> locations = new ArrayList<>();      
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();      
        for (int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(t.nextToken());
            int y = Integer.parseInt(t.nextToken());
            locations.add(new int[]{x, y});
            xs.add(x - 1);
            ys.add(y - 1);
        }       
        long max = Long.MAX_VALUE;
        for (int j : xs) {
            for (int k : ys) {
                int ctq1 = 0, ctq2 = 0, ctq3 = 0, ctq4 = 0;
                for (int[] ele : locations) {
                    if (ele[0] < j && ele[1] < k) {
                        ctq3++;
                    } else if (ele[0] < j && ele[1] > k) {
                        ctq2++;
                    } else if (ele[0] > j && ele[1] > k) {
                        ctq1++;
                    } else if (ele[0] > j && ele[1] < k) {
                        ctq4++;
                    }
                }
                int maxQuadrant = Math.max(Math.max(ctq1, ctq2), Math.max(ctq3, ctq4));
                max = Math.min(max, maxQuadrant);
            }
        }
        pw.println(max);
        pw.close();
    }
}
