import java.io.*;
import java.util.*;
class R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int racelen = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());
        for (int q = 0; q < queries; q++) {
            int finalspeed = Integer.parseInt(br.readLine());
            int speedUpDist = 0;   // Distance while speeding up
            int slowDownDist = 0; // Distance while slowing down
            int seconds = 0;
            for (int currspeed = 1;; currspeed++) {
                speedUpDist += currspeed; // Increment speeding-up distance
                seconds++;
                if (speedUpDist + slowDownDist >= racelen) {
                    pw.println(seconds);
                    break;
                }
                if (currspeed >= finalspeed) {
                    slowDownDist += currspeed; // Add to slowing down distance
                    seconds++;
                    if (speedUpDist + slowDownDist >= racelen) {
                        pw.println(seconds);
                        break;
                    }
                }
            }
        }
        pw.close();
    }
}
