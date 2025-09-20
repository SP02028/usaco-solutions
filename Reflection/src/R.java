import java.io.*;
import java.util.*;
public class R {
    public static int upds(int x, int y, int n, char[][] grid) {
        int cntA = 0, cntB = 0;
        int[][] points = {
            {x, y}, {n - x + 1, y}, {x, n - y + 1}, {n - x + 1, n - y + 1}
        };
        
        for (int i = 0; i < 4; i++) {
            if (grid[points[i][0]][points[i][1]] == '.') {
                cntA++;
            } else {
                cntB++;
            }
        }
        
        return Math.min(cntA, cntB);
    }
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter pw= new PrintWriter(System.out);
    	StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        
        char[][] grid = new char[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                grid[i][j] = s.charAt(j - 1);
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = n / 2 + 1; j <= n; j++) {
                cnt += upds(i, j, n, grid);
            }
        }
        
        pw.println(cnt);
        while (u > 0) {
        	st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            cnt -= upds(x, y, n, grid);
            if (grid[x][y] == '.') {
                grid[x][y] = '*';
            } else {
                grid[x][y] = '.';
            }
            cnt += upds(x, y, n, grid);
            
            pw.println(cnt);
            u--;
        }
        
        pw.close();
    }
}