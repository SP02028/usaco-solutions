import java.io.*;
import java.util.*;

public class SQD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(); 
            int k = Integer.parseInt(st.nextToken());  
                for (int i = 0; i < k - 1 && !a.contains("0"); i++) {
                a = updateNumber(a);
            }

            pw.println(a);
        }
        pw.flush();
        pw.close();
    }

    public static String updateNumber(String a) {
        char[] digits = a.toCharArray();
        int minDigit = 9, maxDigit = 0;
        for (char digit : digits) {
            int num = digit - '0';
            minDigit = Math.min(minDigit, num);
            maxDigit = Math.max(maxDigit, num);
        }
        return String.valueOf(Long.parseLong(a) + (minDigit * maxDigit));
    }
}

