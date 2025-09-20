import java.io.*;
import java.util.*;

public class PO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<t;tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] input = new int[n + 1]; 
            int[] pos = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                pos[input[i]] = i + 1;
            }
            for (int i = 1; i <= n; i++) {
                pw.print(Math.min(pos[i], n) + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}


