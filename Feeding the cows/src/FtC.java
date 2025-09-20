import java.util.*;
import java.io.*;
public class FtC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for (int tc = 0; tc <t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] cows = br.readLine().toCharArray();
            int lastg = -k - 1;
            int lasth = -k - 1;
            char[] answer = new char[n];
            for (int j = 0; j < n; j++) {
                answer[j] = '.';
            }
            int nump = 0;
            for (int j = k; j < n; j++) {
                if (cows[j - k] == 'G') {
                    if ((j - k) - lastg > k) {
                        nump++;
                        answer[j] = 'G';
                        lastg = j;
                    }
                } else {
                    if ((j - k) - lasth > k) {
                        nump++;
                        answer[j] = 'H';
                        lasth = j;
                    }
                }
            }
            boolean needsg = false;
            for (int j = n - 1; j >= 0; j--) {
                if (cows[j] == 'G' && j - lastg > k) {
                    needsg = true;
                }
            }
            if (needsg) {
                for (int j = n - 1; j >= 0; j--) {
                    if (answer[j] == '.') {
                        nump++;
                        answer[j] = 'G';
                        break;
                    }
                }
            }
            boolean needsh = false;
            for (int j = n - 1; j >= 0; j--) {
                if (cows[j] == 'H' && j - lasth > k) {
                    needsh = true;
                }
            }
            if (needsh) {
                for (int j = n - 1; j >= 0; j--) {
                    if (answer[j] == '.') {
                        nump++;
                        answer[j] = 'H';
                        break;
                    }
                }
            }
            pw.println(nump);
            for(char a:answer) {
            	pw.print(a);
            }
            pw.println();
        }
        pw.close();
    }
}


