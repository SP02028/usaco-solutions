import java.util.*;
import java.io.*;
public class CTT {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
       for(int tc = 0; tc<t;tc++){
    	   StringTokenizer st= new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = (long) Integer.parseInt(st.nextToken());
            st= new StringTokenizer(br.readLine());
           long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(a);
            int teamnum = 0;
            int currcount = 0;
            for (int i = n - 1; i >= 0; i--) {
                currcount++;
                if (a[i] * currcount >= x) {
                    teamnum++;
                    currcount = 0;
                }
            }
            System.out.println(teamnum);
        }
        pw.close();
    }
}
