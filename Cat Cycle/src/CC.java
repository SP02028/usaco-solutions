import java.util.*;
import java.io.*;

public class CC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken())-1;
            int floor = n / 2;
            int ans = (k + (n % 2) * k / floor) % n + 1;
            pw.println(ans);
        }
        pw.close();
    }
}
