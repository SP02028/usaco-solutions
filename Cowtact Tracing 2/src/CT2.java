import java.util.*;
import java.io.*;

class CT2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        ArrayList<int[]> ones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1' && (i == 0 || s.charAt(i - 1) == '0')) {
                int len = 0;
                int lenS = 0;
                int lenD = 0;
                int x = i - 1;
                while (x >= 0 && s.charAt(x) == '0') {
                    x--;
                    lenS++;
                }
                x = i;
                while (x < n && s.charAt(x) == '1') {
                    x++;
                    len++;
                }
                i = x - 1;
                while (x < n && s.charAt(x) == '0') {
                    x++;
                    lenD++;
                }
                ones.add(new int[]{len, lenS, lenD});
            }
        }

        if (ones.size() == 0) {
            pw.println(0);
            pw.close();
            return;
        }

        int minD = 1000000;
        for (int i = 0; i < ones.size(); i++) {
            int[] current = ones.get(i);
            if (current[1] == 0 || current[2] == 0)
                minD = Math.min(minD, current[0] - 1);
            else
                minD = Math.min(minD, (current[0] - 1) / 2);
        }
        minD++;

        int cnt = 0;
        for (int i = 0; i < ones.size(); i++) {
            int[] current = ones.get(i);
            cnt += Math.max(1, (current[0] + minD * 2 - 2) / (minD * 2 - 1));
        }

        pw.println(cnt);
        pw.close();
    }
}
