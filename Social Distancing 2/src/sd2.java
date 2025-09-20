import java.util.*;
import java.io.*;
public class sd2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist2.in"));
        PrintWriter pw = new PrintWriter("socdist2.out");
        int len = Integer.parseInt(br.readLine());
        int[] cows = new int[1000001];
        ArrayList<Integer> infected = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cowpos = Integer.parseInt(st.nextToken());
            int status = Integer.parseInt(st.nextToken());
            if(status==1) {
            	cows[cowpos] = 1;
            }
            else {
            	cows[cowpos]=-1;
            }
            if (status == 1) {
                infected.add(cowpos);
            }
        }
        // Find smallest gap between a sick and a healthy cow
        int smallestGap = Integer.MAX_VALUE, last = -1;
        for (int i = 0; i <= 1000000; i++) {
            if (cows[i] != 0) {
                if (last != -1 && cows[i] != cows[last]) {
                    smallestGap = Math.min(smallestGap, i - last);
                }
                last = i;
            }
        }
        // Count number of sick clusters
        int lastState = 0, sickClusters = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (cows[i] != 0) {
                if (cows[i] != lastState && cows[i] == 1) {
                    sickClusters++;
                }
                lastState = cows[i];
            }
        }
        // Count number of gaps of size i or larger within sick cows
        int gaps = 0, start = -1;
        for (int i = 0; i <= 1000000; i++) {
            if (cows[i] != 0) {
                if (start != -1 && cows[start] == 1 && cows[i] == 1 && i - start >= smallestGap) {
                    gaps++;
                }
                start = i;
            }
        }
        pw.println(sickClusters + gaps);
        pw.close();
    }
}

