import java.util.*;
import java.io.*;

public class BT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int len = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());      
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[len + 1];       
        for (int i = 1; i <= len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }       
        Arrays.sort(arr);      
        int numteams = 0;
        int lastputonteam = 1;
        int n = len;
        
        while (n > 0) {
            int nummembers = (int) Math.ceil((double) (power + 1) / arr[n]);
        if (lastputonteam + nummembers - 1 > len) {
                break;
            }
            lastputonteam += nummembers;
            numteams++;
            n--;
        }        
        pw.println(numteams);
        pw.close();
    }
}
