import java.util.*;
import java.io.*;

public class BB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());
        long[] arr = new long[len + 1];
         StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long numpos = 0; 
        long numneg = 0;
        long change = 0;  
        // ltr scan
        for (int i = 1; i <= len; i++) {
            // Update the net change in bacteria level
            change = change + numpos - numneg;        
            // Calculate the bacteria level for the current patch
            long val = arr[i] + change;            
            // If the bacteria level is negative, we need to add bacteria
            if (val < 0) {
                numpos = numpos - val; // Increase the total bacteria added
            } else {
                // If the bacteria level is positive, we need to remove bacteria
                numneg = numneg + val;
            }         
            // Update the net change to reflect the adjustment made
            change = change - val;
        }     
        // Output the total number of bacteria adjustments needed
        pw.println(numpos + numneg);
        pw.close();
    }
}
