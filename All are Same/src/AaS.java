import java.util.*;
import java.io.*;

public class AaS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[len];
            	for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean allSame = true;
            for (int i = 1; i < len; i++) {
                if (arr[i] != arr[0]) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                pw.println(-1); 
                continue;
            }
            int g = 0;
            int min = arr[0];
            for (int i = 1; i < len; i++) {
                g = gcd(g, Math.abs(arr[i] - min));
            }

            pw.println(g);
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

