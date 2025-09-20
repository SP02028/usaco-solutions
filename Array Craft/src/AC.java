import java.util.*;
import java.io.*;

public class AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for(int t= 0; t<tc;t++)	{      
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x--;
            y--;
            int[] a = new int[n];
            Arrays.fill(a, 1); 
            int currele = -1;
            for (int i = x + 1; i < n; i++) {
                a[i] = currele;
                currele *= -1;
            }
            currele = -1;
            for (int i = y - 1; i >= 0; i--) {
                a[i] = currele;
                currele *= -1;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                	pw.print(" ");
                }
                pw.print(a[i]);
            }
            pw.println();
        }
        pw.close();
    }
}