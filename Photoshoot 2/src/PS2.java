import java.io.*;
import java.util.*;

public class PS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int[] v = new int[n];
        int[] v2 = new int[n];
        
        String[] input1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(input1[i]) - 1;
        }

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            v2[i] = Integer.parseInt(input2[i]) - 1;
        }
        
        int[] pos = new int[n];
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos[v[i]] = i;
            pos2[v2[i]] = i;
        }
        
        int[] swapped = new int[n];
        
        int ans = 0;
        int posFirst = 0;
        for (int i = 0; i < n; i++) {
            while (posFirst < n && swapped[v[posFirst]] == 1) {
                posFirst++;
            }
            if (v[posFirst] == v2[i]) {
                posFirst++;
            } else {
                ans++;
                swapped[v2[i]] = 1;
            }
        }
        
        pw.println(ans);
        pw.close();
    }
}
