import java.util.*;
import java.io.*;

public class IMT2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len + 1]; 
        int[] freq = new int[len + 1];
        //right to left freq
        int[] freq2 = new int[len + 1];
        //left to right freq
        //By using freq2, you can determine how many times an element
        //will appear in the future, and by using freq,
        //you can determine how many times it has appeared so far.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq2[arr[i]]++;
        }
        long ans = 0;
        int distinct = 0;
        for (int i = 1; i <= len; i++) {
            freq2[arr[i]]--;
            if (freq2[arr[i]] == 1) {
            	if (freq[arr[i]] > 0) {
            	    ans += 1L * (distinct - 1);
            	} else {
            	    ans += 1L * distinct;
            	}
            }
            freq[arr[i]]++;  
            if (freq[arr[i]] == 1) {
                distinct++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}


