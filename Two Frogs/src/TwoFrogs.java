import java.util.*;
import java.io.*;

public class TwoFrogs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(t.nextToken());
            int aindex = Integer.parseInt(t.nextToken()) - 1;
            int bindex = Integer.parseInt(t.nextToken()) - 1;
            boolean validmove = true;
            while (validmove) {
                boolean aleftval = (aindex - 1 >= 0) && (aindex - 1 != bindex);
                boolean arightval = (aindex + 1 < N) && (aindex + 1 != bindex);
                if (!aleftval && !arightval) {
                    pw.println("NO");
                    validmove = false;
                    break;
                }
                if (arightval) {
                    aindex++;
                } else if (aleftval) {
                    aindex--;
                }
                boolean bleftval = (bindex - 1 >= 0) && (bindex - 1 != aindex);
                boolean brightval = (bindex + 1 < N) && (bindex + 1 != aindex);
                if (!bleftval && !brightval) {
                    pw.println("YES");
                    validmove = false;
                    break;
                }
                if (brightval) {
                    bindex++;
                } else if (bleftval) {
                    bindex--;
                }
            }
        }
        pw.flush();
    }
}



