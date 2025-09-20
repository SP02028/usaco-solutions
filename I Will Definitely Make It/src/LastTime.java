import java.util.*;
import java.io.*;

public class LastTime {
    static class Casino {
        int l, r, real;
        public Casino(int l, int r, int real) {
            this.l = l;
            this.r = r;
            this.real = real;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
           int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
             Casino[] casinos = new Casino[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                 int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                 int real = Integer.parseInt(st.nextToken());
                casinos[i] = new Casino(l, r, real);
            }
            Arrays.sort(casinos, Comparator.comparingInt(c -> c.l));
            int i = 0;
            PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
            boolean changed = true;
            while (changed) {
                changed = false;
                int max = -1;
                for (Casino c : casinos) {
                    if (c.l <= k && k <= c.r) {
                        max = Math.max(max, c.real);
                    }
                }
                if (max > k) {
                    k = max;
                    changed = true;
                }
            }

            pw.println(k);
        }
        	pw.close();
    }			
}
