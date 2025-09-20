import java.util.*;
import java.io.*;

public class EC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] weights = new int[len];
            for (int i = 0; i < len; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }
            
            int lhval = weights[0];
           int rhval = weights[len - 1];
            int i = 0, j = len - 1;
            int maxnum = 0;

            while (i < j) {
                if (lhval == rhval) {
                    maxnum = (i + 1) + (len - j);
                }           
                if (lhval <= rhval) {
                    i++;
                    if (i < j) lhval += weights[i];
                } else {
                    j--;
                    if (i < j) rhval += weights[j];
                }
            }
            
            pw.println(maxnum);
        }
        
        pw.close();
    }
}

