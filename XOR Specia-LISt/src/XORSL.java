import java.util.*;
import java.io.*;

public class XORSL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());      
        while (tc-- > 0) {
            int len = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[len + 1];
            boolean valid = true;
            
            for (int i = 1; i <= len; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (i > 1) {
                    if(arr[i]<arr[i-1]) {
                    	valid = false;
                    	break;
                    }
                }
            }
            
            if (len % 2 == 0 || !valid) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
}
