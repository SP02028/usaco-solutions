import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int[][] bessie = new int[m][2];
        int[][] limit = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer t = new StringTokenizer(r.readLine());
            limit[i][0] = Integer.parseInt(t.nextToken()); 
            limit[i][1] = Integer.parseInt(t.nextToken()); 
        }
        for (int j = 0; j < m; j++) {
            StringTokenizer s = new StringTokenizer(r.readLine());
            bessie[j][0] = Integer.parseInt(s.nextToken()); 
            bessie[j][1] = Integer.parseInt(s.nextToken()); 
        }
        int[] bessieSpeeds = new int[100];
        int[] limitSpeeds = new int[100];

        int position = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < bessie[i][0]; j++) {
                bessieSpeeds[position++] = bessie[i][1];
            }
        }

        position = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < limit[i][0]; j++) {
                limitSpeeds[position++] = limit[i][1];
            }
        }

        int maxDifference = 0;
        for (int i = 0; i < 100; i++) {
            maxDifference = Math.max(maxDifference, bessieSpeeds[i] - limitSpeeds[i]);
        }

        pw.println(maxDifference);
        pw.close();
    }
}