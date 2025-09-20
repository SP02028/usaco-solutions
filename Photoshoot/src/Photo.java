import java.io.*;
import java.util.*;
public class Photo {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        char[] ordering = in.readLine().toCharArray();
        int answer = 0;
        for (int j = n - 2; j >= 0; j -= 2) {
            if (ordering[j] != ordering[j + 1] && (ordering[j] == 'G') == (answer % 2 == 0)) {
                answer++;
            }
        }
        pw.println(answer);
    }
}