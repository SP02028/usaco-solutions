import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AS {
    static void remove(int x, int y, char[][] sky, int N) {
        if (x < N && y < N) {
            if (sky[x][y] == 'G') {
                sky[x][y] = '*';
            }
            if (sky[x][y] == 'B') {
                sky[x][y] = 'G';
            }
        }
    }

    static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 0;
        char[][] sky = new char[N][];
        
        for (int i = 0; i < N; i++) {
            sky[i] = br.readLine().toCharArray();
        }
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                // check if no stars are present
                if (sky[row][col] == 'W' || sky[row][col] == '*') {
                    continue;
                }
                // CASE: least one star present at (Row, col)
                remove(row, col, sky, N);
                remove(row + B, col + A, sky, N);
                count++;
                // CASE: star still remains at (row,col)
                if (sky[row][col] == 'G') {
                    if (row >= B && col >= A && sky[row - B][col - A] == '*') {
                        count++;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            out.println(solution());
        }
        out.flush();
    }
}
