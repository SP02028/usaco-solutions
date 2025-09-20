import java.io.*;
import java.util.*;

public class NBFSIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numtowers = Integer.parseInt(st.nextToken());
        int numfloors = Integer.parseInt(st.nextToken());
        int minfloorwpass = Integer.parseInt(st.nextToken());
        int maxfloorwpass = Integer.parseInt(st.nextToken());
        int tcs = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tcs; t++) {
            st = new StringTokenizer(br.readLine());
            int ta = Integer.parseInt(st.nextToken());
            int fa = Integer.parseInt(st.nextToken());
            int tb = Integer.parseInt(st.nextToken());
            int fb = Integer.parseInt(st.nextToken());
            if (ta == tb) {
                pw.println(Math.abs(fa - fb));
                continue;
            }
            int mintime = Integer.MAX_VALUE;
            if (fa >= minfloorwpass && fa <= maxfloorwpass) {
                mintime = Math.abs(ta - tb) + Math.abs(fa - fb);
            }
            if (fb >= minfloorwpass && fb <= maxfloorwpass) {
                mintime = Math.min(mintime, Math.abs(ta - tb) + Math.abs(fa - fb));
            }
            mintime = Math.min(mintime, Math.abs(fa - minfloorwpass) + Math.abs(fb - minfloorwpass) + Math.abs(ta - tb));
            mintime = Math.min(mintime, Math.abs(fa - maxfloorwpass) + Math.abs(fb - maxfloorwpass) + Math.abs(ta - tb));

            pw.println(mintime);
        }
        pw.close();
    }
}

