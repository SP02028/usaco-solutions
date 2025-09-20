import java.util.*;
import java.io.*;
 
public class NTD {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] d1 = new int[4];
            for (int i= 0; i < 4; i++) {
                d1[i] = Integer.parseInt(st.nextToken());
            }
            int[] d2 = new int[4];
            for (int i = 0; i < 4; i++) {
                d2[i] = Integer.parseInt(st.nextToken());
            }
            String answer = "no";
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    for (int k= 1; k <= 10; k++) {
                        for (int l = 1; l<= 10; l++) {
                            int[] d3 = {i, j, k, l};
                            if (beats(d1, d2) && beats(d2, d3) && beats(d3, d1)) {
                                answer = "yes";
                            }
                            if (beats(d2, d1) && beats(d1, d3) && beats(d3, d2)) {
                                answer = "yes";
                            }
                        }
                    }
                }
            }
            pw.println(answer);
        }
        pw.close();
    }
 
   public static boolean beats(int[] d1, int[] d2) {
        int diff = 0;
        for (int d : d1) {
            for (int i : d2) {
            	if((d-i) >0) {
            		diff+=1;
            	}
            	else if((d-i) <0) {
            		diff+=-1;
            	}
            }
        }
        if(diff>0) {
        	return true;
        }
        return false;
    }
}