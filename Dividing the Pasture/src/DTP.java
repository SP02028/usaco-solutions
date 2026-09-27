import java.util.*;
import java.io.*;

public class DTP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long area = 0;
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
        HashSet<String> c = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            minx = Math.min(minx, x1); miny = Math.min(miny, y1);
            maxx = Math.max(maxx, x2); maxy = Math.max(maxy, y2);
            area += (long) (x2 - x1) * (y2 - y1);
            String[] pts = {x1+","+y1, x2+","+y1, x1+","+y2, x2+","+y2};
            for (String p : pts) {
                if (!c.add(p)) c.remove(p);
            }
        }
        boolean ok = area == (long)(maxx - minx) * (maxy - miny) &&
                c.size() == 4 &&
                c.contains(minx+","+miny) &&
                c.contains(minx+","+maxy) &&
                c.contains(maxx+","+miny) &&
                c.contains(maxx+","+maxy);
        System.out.println(ok ? "Yes" : "No");
    }
}
