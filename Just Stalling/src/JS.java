import java.util.*;
import java.io.*;

public class JS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int[] cowheights = new int[N + 1]; 
        int[] stallheights = new int[N + 1];       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cowheights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cowheights, 1, N + 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { 
            stallheights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stallheights, 1, N + 1);      
        long ans = 1;
        int pos2 = N;
        
        for (int i = N; i >= 1; i--) {
            while (pos2 > 0 && stallheights[pos2] >= cowheights[i]) {
                pos2--;
            }
            ans *= (i - pos2);
        }       
        pw.println(ans);
        pw.close();
    }
}
