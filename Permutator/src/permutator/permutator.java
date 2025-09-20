package permutator;

import java.io.*;
import java.util.Arrays;

public class permutator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        int[] b = new int[n];
        
        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aInput[i]) * (i + 1) * (n - i);
        }
        Arrays.sort(a);
        
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(bInput[i]);
        }
        Arrays.sort(b);
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * b[n - i - 1];
        }
        pw.println(ans);
        
        pw.close();
    }
}
