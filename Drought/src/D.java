import java.util.*;
import java.io.*;
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            long[] arr = new long[len + 1]; // 1-indexed
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 1; i <= len; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            
            long count = 0;
            boolean broken = false;
            
            for (int i = 1; i < len; i++) {
                if (arr[i + 1] > arr[i]) {
                    if (i + 2 > len) {
                        pw.println(-1);
                        broken = true;
                        break;
                    }
                    
                    long diff = arr[i + 1] - arr[i];
                    arr[i + 1] -= diff;
                    arr[i + 2] -= diff;
                    
                    if (arr[i + 2] < 0) {
                        pw.println(-1);
                        broken = true;
                        break;
                    }
                    
                    count += diff * 2;
                } else if (arr[i] > arr[i + 1]) {
                    if (i % 2 == 1) {
                        pw.println(-1);
                        broken = true;
                        break;
                    }
                    
                    long diff = arr[i] - arr[i + 1];
                    count += diff * i;
                }
            }
            
            if (!broken) {
                pw.println(count);
            }
        }
        pw.close();
    }
}