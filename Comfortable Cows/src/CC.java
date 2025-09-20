import java.util.*;
import java.io.*;

public class CC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());
        boolean[][] numcows = new boolean[1001][1001];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int countcomfy = 0;

        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx <= 1000 && ny >= 0 && ny <= 1000 && numcows[nx][ny]) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int adjX = nx + dx[k];
                        int adjY = ny + dy[k];
                        if (adjX >= 0 && adjX <= 1000 && adjY >= 0 && adjY <= 1000 && numcows[adjX][adjY]) {
                            count++;
                        }
                    }
                    if (count == 3) {
                        countcomfy--;
                    }
                }
            }
            
            numcows[x][y] = true;
            
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx <= 1000 && ny >= 0 && ny <= 1000 && numcows[nx][ny]) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int adjX = nx + dx[k];
                        int adjY = ny + dy[k];
                        if (adjX >= 0 && adjX <= 1000 && adjY >= 0 && adjY <= 1000 && numcows[adjX][adjY]) {
                            count++;
                        }
                    }
                    if (count == 3) {
                        countcomfy++;
                    }
                }
            }
            
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int adjX = x + dx[j];
                int adjY = y + dy[j];
                if (adjX >= 0 && adjX <= 1000 && adjY >= 0 && adjY <= 1000 && numcows[adjX][adjY]) {
                    count++;
                }
            }
            if (count == 3) {
                countcomfy++;
            }
            
            pw.println(countcomfy);
        }
        
        pw.close();
    }
}


