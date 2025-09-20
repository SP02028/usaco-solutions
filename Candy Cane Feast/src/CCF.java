import java.io.*;
import java.util.*;
public class CCF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());        
        int numcows = Integer.parseInt(st.nextToken());
        int numcanes = Integer.parseInt(st.nextToken());     
        int[] cows = new int[numcows];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numcows; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }        
        int[] canes = new int[numcanes];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numcanes; i++) {
            canes[i] = Integer.parseInt(st.nextToken());
        }       
        for (int x : canes) {//iterates over each candy cane size
            int start = 0;
            for (int j = 0; j < numcows; j++) {//determine how many candy canes each cow can consume
                if (x <= start) {//breaks if the candy cane size is less than or equal to the candy canes consumed
                    break;
                }
                int a = cows[j];
                int val = Math.min(a, x); //min of cows size and candy cane size
                int d = val - start; //difference between val and candy canes consumed so far, how many more candy canes can be given
                //to the cow
                if (d > 0) {
                    cows[j] += d; //if candy canes can be given, then give the cow the candy canes and increase its size
                }
                if (val > start) {
                    start = val; //make start reflect the new number of distributed candy canes
                }
            }
        }       
        for (int w : cows) {
            pw.println(w);
        }
        pw.close();
    }
}