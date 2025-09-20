import java.io.*;
import java.util.*;

public class A2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] cows = new String[n];
        for (int i = 0; i < n; i++) {
            cows[i] = st.nextToken();
        }

        Map<String, Integer> cowindexes = new HashMap<>();
        char[][] sen = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(sen[i], '?'); 
            cowindexes.put(cows[i], i);
            sen[i][i] = 'B';
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine()); 
            String[] order = new String[n];
            for (int j = 0; j < n; j++) {
                order[j] = st.nextToken();
            }

            int groupnum = 0;
            int[] g = new int[n];

            for (int j = 1; j < n; j++) {
                if (order[j].compareTo(order[j - 1]) < 0) {
                    groupnum++;
                }
                g[j] = groupnum; 
            }

            for (int j = 0; j < n; j++) {
                for (int m = j + 1; m < n; m++) {
                    if (g[j] < g[m]) { 
                        int i1 = cowindexes.get(order[j]); 
                        int i2 = cowindexes.get(order[m]);
                        sen[i2][i1] = '1';
                        sen[i1][i2] = '0';
                    }
                }
            }
        }

        for (char[] row : sen) {
            pw.println(new String(row));
        }
        
        pw.close();
    }
}
