import java.util.*;
import java.io.*;

public class BD {

    public static void main(String[] args) throws IOException {
        List<Integer> binarynums = Arrays.asList( 1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111, 10000, 10001, 10010, 10011, 10100, 10101, 10110, 10111, 11000, 11001, 11010, 
            11011, 11100, 11101, 11110, 11111, 100000
        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(s.nextToken());

            if (binarynums.contains(num)) {
                pw.println("YES");
                continue;
            }

            for (int n : binarynums) {
                if (n > num) {
                	break; 
                }
                if (num % n == 0 && n!=1) {
                    while (num % n == 0) {
                        num /= n;
                    }
                }
            }

            if (binarynums.contains(num)) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
}
