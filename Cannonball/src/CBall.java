import java.util.*;
import java.io.*;

public class CBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());       
        int len = Integer.parseInt(st.nextToken()); 
        int start = Integer.parseInt(st.nextToken());
        int[][] pos = new int[len][2]; 
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        int power = 1;
        int direction = 1;
        int numtimes = 0;
        Set<Integer> targets = new HashSet<>();
        while (start >= 1 && start <= len && numtimes < 3 * len) {
            numtimes++;
            int v = pos[start - 1][1];
            if (pos[start - 1][0] == 0) { 
            	// Jump pad
                power += v;
                direction *= -1;
            } else { 
            	// Target
                if (power >= v) {
                    targets.add(start);
                }
            }
            start += power * direction;
        }
        pw.println(targets.size());
        pw.close();
    }
}


