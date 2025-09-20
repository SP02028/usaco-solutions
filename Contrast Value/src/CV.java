import java.util.*;
import java.io.*;

public class CV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; j++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> a = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            List<Integer> uniqueList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 || !a.get(i).equals(a.get(i - 1))) {
                    uniqueList.add(a.get(i));
                }
            }
            n = uniqueList.size();
            if (n <= 2) {
                pw.println(n);
                continue;
            }
            int ans = n;
            for (int i = 0; i + 2 < n; i++) {
                int prev = uniqueList.get(i);
                int curr = uniqueList.get(i + 1);
                int next = uniqueList.get(i + 2);
                if ((prev < curr && curr < next) || (prev > curr && curr > next)) {
                    ans--;
                }
            }
         pw.println(ans);
        }
        pw.flush();
    }
}
