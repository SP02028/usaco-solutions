import java.util.*;
import java.io.*;

public class GWM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int[] freqarr = new int[30]; // Frequency array
        int q = Integer.parseInt(br.readLine());       
        for (int u = 0; u < q; u++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());          
            if (type == 1) {
                // Add 2^num to the multiset
                freqarr[num]++;
            } else {
                // Check if we can form the sum 
                int remaining = num;              
                // Start from the highest bit and work downwards
                for (int i = 29; i >= 0; i--) {
                    int power = 1 << i;
                    int needed = remaining / power;
                    if (needed > 0) {
                        int used = Math.min(needed, freqarr[i]);
                        remaining -= used * power;
                    }
                }               
                if (remaining == 0) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            }
        }
        pw.close();
    }
}
