import java.io.*;
import java.util.*;
public class SaD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            int[] freq = {0, 0};             
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - '0']++;
            }            
            for (int i = 0; i <= s.length(); i++) {
                if (i == s.length() || freq[1 - (s.charAt(i) - '0')] == 0) {
                    pw.println(s.length() - i);
                    break;
                }
                freq[1 - (s.charAt(i) - '0')]--;
            }
        }
        pw.close();
    }
}
