import java.io.*;
import java.util.*;
public class XSUM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);       
        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++) {
        	 String[] dims = br.readLine().split(" ");
             int rows = Integer.parseInt(dims[0]);
             int cols = Integer.parseInt(dims[1]);
             int[][] matrix = new int[rows][cols];
             for (int i = 0; i < rows; i++) {
                 String[] values = br.readLine().split(" ");
                 for (int j = 0; j < cols; j++) {
                     matrix[i][j] = Integer.parseInt(values[j]);
                 }
             }
             int max = 0;
             for (int i = 0; i < rows; i++) {
                 for (int j = 0; j < cols; j++) {
                     int currsum = 0;
                     int x = i, y = j;                    
                     while (x >= 0 && y >= 0) {
                         currsum += matrix[x][y];
                         x--;
                         y--;
                     }
                     x = i;
                     y = j;
                     while (x < rows && y >= 0) {
                         currsum += matrix[x][y];
                         x++;
                         y--;
                     }
                     x = i;
                     y = j;
                     while (x >= 0 && y < cols) {
                         currsum += matrix[x][y];
                         x--;
                         y++;
                     }
                     x = i;
                     y = j;
                     while (x < rows && y < cols) {
                         currsum += matrix[x][y];
                         x++;
                         y++;
                     }
                     currsum -= matrix[i][j] * 3;
                     
                     max = Math.max(max, currsum);
                 }
             }

             out.println(max);
                 }
        
        out.flush();
    }

       
}
