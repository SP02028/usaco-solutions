import java.util.*;
import java.io.*;
public class LC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int prevG = -1, prevGG = -1;
        int prevH = -1, prevHH = -1;
        
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'G') {
                prevGG = prevG;
                prevG = i;
            } else {
                prevHH = prevH;
                prevH = i;
            }
            
            if (i >= 2) {
                if (prevGG != -1 && prevHH != -1) {
                    ans += Math.min(i - 2, Math.min(prevG, prevH)) - Math.min(prevGG, prevHH);
                } else {
                    if (prevG != -1 && prevH != -1) {
                        ans += Math.min(i - 2, Math.min(prevG, prevH)) + 1;
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}