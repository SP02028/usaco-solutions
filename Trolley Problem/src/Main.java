import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] t = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) t[i] = Integer.parseInt(st.nextToken());
        int[] t1 = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
        	t1[i] = Integer.parseInt(st.nextToken());
        }
        int[] t2 = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
        	t2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t1);
        Arrays.sort(t2);
        int p1 = 0;
        int p2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int trolley = t[i];
            boolean safe1 = p1 < a && trolley <= t1[p1];
            boolean safe2 = p2 < b && trolley <= t2[p2]; 
            if (safe1 && !safe2) {
                p1++;
            } else if (!safe1 && safe2) {
                p2++;
            } else if (safe1 && safe2) {
                p1++;
            } else {
                if (p1 < a && p2 < b) {
                    if (t1[p1] >= t2[p2]) p1++;
                    else p2++;
                } else if (p1 < a) {
                    p1++;
                } else if (p2 < b) {
                    p2++;
                }
            }
        }
        int ans = p1 + p2;
        out.println(ans);
        out.flush();
    }
}

