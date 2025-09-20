import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // User input and setting up
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken()); // Number of sequences
        int M = Integer.parseInt(st.nextToken()); // Length of each sequence
        String[][] spotty = new String[N][M];
        String[][] plain = new String[N][M];

        // Reading spotty array
        for (int i = 0; i < N; i++) {
            String line = r.readLine();
            for (int j = 0; j < M; j++) {
                spotty[i][j] = Character.toString(line.charAt(j));
            }
        }

        // Reading plain array
        for (int i = 0; i < N; i++) {
            String line = r.readLine();
            for (int j = 0; j < M; j++) {
                plain[i][j] = Character.toString(line.charAt(j));
            }
        }

        int count = 0;

        // Complete search
        for (int a = 0; a < M - 2; a++) {
            for (int b = a + 1; b < M - 1; b++) {
                for (int c = b + 1; c < M; c++) {
                    boolean common = false;

                    for (int i = 0; i < N; i++) {
                        String spotty_sub = spotty[i][a] + spotty[i][b] + spotty[i][c];
                        for (int j = 0; j < N; j++) {
                            String plain_sub = plain[j][a] + plain[j][b] + plain[j][c];
                            if (spotty_sub.equals(plain_sub)) {
                                common = true;
                                break;
                            }
                        }
                        if (common) {
                        	break;
                        }
                    }

                    if (!common) {
                        count++;
                    }
                }
            }
        }

        pw.println(count);
        pw.close();
    }
}
