import java.util.*;
import java.io.*;

public class MP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numfarms = Integer.parseInt(st.nextToken());
        int numqueries = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
        int[] differences = new int[numfarms];
        for (int i = 0; i < numfarms; i++) {
            differences[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numfarms; i++) {
            differences[i] -= Integer.parseInt(st.nextToken());
        }
        // Precompute posout values
        int[] posout = new int[1000001];
        for (int i = 0; i < 1000001; i++) {
            int count = 0;
            int[] temp = differences.clone(); 
            for (int j = 0; j < numfarms; j++) {
                temp[j] -= i; 
            }
            for (int d : temp) {
                if (d > 0) {
                    count++;
                }
            }
            posout[i] = count; 
            if (count == 0) {
                break; 
            }
        }

        for (int i = 0; i < numqueries; i++) {
            st = new StringTokenizer(br.readLine());
            int wantvisit = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            // Check if enough farms are visitable at the given time
            if (posout[time] >= wantvisit) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        
        pw.close();
    }
}

