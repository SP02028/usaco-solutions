import java.io.*;
import java.util.*;
public class WA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            List<Integer> b = new ArrayList<>();
            boolean printed = false;
            while (s > 0) {
                int x = (int) (a % 10);
                int y = (int) (s % 10);
                if (x <= y) {
                    b.add(y - x);
                } else {
                    s /= 10;
                    y += 10 * (s % 10);
                    if (x < y && y >= 10 && y <= 19) {
                        b.add(y - x);
                    } else {
                        pw.println(-1);
                        printed =true;
                        break;
                    }
                }
                a /= 10; //truncate the last digit
                s /= 10;
            }
            if(!printed) {
            if (a > 0) {
                pw.println(-1);
                continue;
            } else {
                while (!b.isEmpty() && b.get(b.size() - 1) == 0) {
                    b.remove(b.size() - 1);
                }
                for (int i = b.size() - 1; i >= 0; i--) {
                    pw.print(b.get(i));
                }
                pw.println();
            }
            }
        }
        pw.close();
    }
}
