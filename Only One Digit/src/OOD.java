import java.util.*;
import java.io.*;

public class OOD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            int min = 9;
            for (int j = 0; j < num.length(); j++) {
                int digit = num.charAt(j) - '0';
                min = Math.min(min, digit);
            }
            pw.println(min);
        }
        pw.close();
    }
}