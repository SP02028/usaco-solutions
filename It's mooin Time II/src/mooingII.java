import java.util.*;
import java.io.*;

public class mooingII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());  
        int[] vals = new int[len];
        int[] freq1 = new int[len + 1];  
        int[] freq2 = new int[len + 1];  
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
            freq2[vals[i]]++;
        }
        long ans = 0;
        int distinct = 0;
        for (int i = 0; i < len; i++) {
            freq2[vals[i]]--;  
            if (freq2[vals[i]] == 1) {
                ans += (long) (distinct - (freq1[vals[i]] > 0 ? 1 : 0));
            }
            freq1[vals[i]]++;  
            if (freq1[vals[i]] == 1) {
                distinct++; 
            }
        }
        pw.println(ans);
        pw.close();
    }
}

