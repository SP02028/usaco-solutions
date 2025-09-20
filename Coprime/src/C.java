import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());       
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            int[] arr = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine());
                        Map<Integer, Integer> lastIndex = new HashMap<>();
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                lastIndex.put(arr[i], i + 1); 
            }
            int maxSum = -1;
            for (int x : lastIndex.keySet()) {
                for (int y : lastIndex.keySet()) {
                    if (gcd(x, y) == 1) {
                        maxSum = Math.max(maxSum, lastIndex.get(x) + lastIndex.get(y));
                    }
                }
            }

            pw.println(maxSum);
        }
        pw.close();
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

