import java.util.*;
import java.io.*;

public class M {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            Map<Integer, Integer> count = new HashMap<>();
            Set<Integer> temp = new TreeSet<>();  
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
                count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
                temp.add(arr[i]);
                temp.add(arr[i] + 1);
            }
            
            int last = 0;
            int res = 0;
            for (int x : temp) {
                int c = count.getOrDefault(x, 0);
                if (c > last) {
                    res += c - last;
                    last = c;
                } else {
                    last = c;
                }
            }
            pw.println(res);
        }
        pw.close();
    }
}






