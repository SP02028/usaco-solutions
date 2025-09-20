import java.io.*;
import java.util.StringTokenizer;

public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // If the first entry is positive, there's an immediate contradiction
        if (arr[0] > 0) {
            pw.println(-1); 
            pw.close();
            return;
        }
        arr[0] = 0;
        // Variables to track the consistency of the log
        int lastnum = -1; // Used to fill backward values
        boolean possible = true; // Flag to check for contradictions
        int numBreakouts = 0; // To count breakout events (0 entries)
        int numUndetermined = 0; // To count undetermined entries (-1)
        // Sweep backward through the days
        for (int i = N - 1; i >= 0; i--) {
            // If there's a contradiction in the log
            if (lastnum != -1 && arr[i] != -1 && arr[i] != lastnum) {
                possible = false;
                break;
            }
            // If value is undetermined, fill the value
            if (lastnum == -1) {
                lastnum = arr[i];
            }
            if (arr[i] == -1) {
                arr[i] = lastnum; // fill the lastnum value
            }
            // Count breakout events and undetermined entries
            if (arr[i] == 0) {
                numBreakouts++;
            }
            if (arr[i] == -1) {
                numUndetermined++;
            }
            // Decrement the filled value for the next day
            if (lastnum > -1) {
                lastnum--;
            }
        }
        // Output the results based on the flag
        if (!possible) {
            pw.println(-1); // Output -1 if a contradiction was found
        } else {
            int minBreakouts = numBreakouts; // Minimum number of breakouts
            int maxBreakouts = numBreakouts + numUndetermined; // Maximum number of breakouts
            pw.println(minBreakouts + " " + maxBreakouts); 
        }
        pw.close();
    }
}
