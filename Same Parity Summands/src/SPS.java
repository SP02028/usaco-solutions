import java.util.*;
import java.io.*;

public class SPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());       
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());           
            int temp = N - (K - 1);
            if (temp > 0 && temp % 2 == 1) {
                pw.println("YES");
                for (int i = 0; i < K - 1; i++) {
                    pw.print(1 + " ");
                }
                pw.println(temp);
                continue;
            }
            temp = N - 2 * (K - 1);
            if (temp > 0 && temp % 2 == 0) {  
                pw.println("YES");
                for (int i = 0; i < K - 1; i++) {
                    pw.print(2 + " ");
                }
                pw.println(temp);
                continue;
            }
            
            pw.println("NO");
        }       
        pw.close();
    }
}
