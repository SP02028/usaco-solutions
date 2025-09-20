import java.util.*;
import java.io.*;

public class SG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(nextNonEmptyLine(br));
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            // Read grid size
            st = new StringTokenizer(nextNonEmptyLine(br));
            int gridlen = Integer.parseInt(st.nextToken());
            char[][] grid = new char[gridlen][gridlen];            
            for (int i = 0; i < gridlen; i++) {
                String line = nextNonEmptyLine(br);
                grid[i] = line.toCharArray();
            }
            // Read stamp size
            st = new StringTokenizer(nextNonEmptyLine(br));
            int stamplen = Integer.parseInt(st.nextToken());
            char[][] stampr360 = new char[stamplen][stamplen];
            for (int i = 0; i < stamplen; i++) {
                String line = nextNonEmptyLine(br);
                stampr360[i] = line.toCharArray();
            }
            char[][] stampr90 = rotateStamp(stampr360, stamplen);
            char[][] stampr180 = rotateStamp(stampr90, stamplen);
            char[][] stampr270 = rotateStamp(stampr180, stamplen);
            boolean[][] visited = new boolean[gridlen][gridlen];
            char[][][] rotations = {stampr360, stampr90, stampr180, stampr270};
            for (char[][] stamp : rotations) {
                for (int i = 0; i <= gridlen - stamplen; i++) {
                    for (int j = 0; j <= gridlen - stamplen; j++) {
                        if (canStamp(grid, stamp, i, j)) {
                            applyStamp(visited, stamp, i, j);
                        }
                    }
                }
            }
            boolean isStamped = true;
            outer:
            for (int i = 0; i < gridlen; i++) {
                for (int j = 0; j < gridlen; j++) {
                    if (grid[i][j] == '*' && !visited[i][j]) {
                        isStamped = false;
                        break outer;
                    }
                }
            }
            pw.println(isStamped ? "YES" : "NO");
        }
        pw.close();
    }
    private static String nextNonEmptyLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && line.isEmpty());
        return line; 
    }
    public static char[][] rotateStamp(char[][] stamp, int k) {
        char[][] newStamp = new char[k][k];
        for (int L = 0; L < k; L++) {
            for (int C = 0; C < k; C++) {
                newStamp[C][k - 1 - L] = stamp[L][C];
            }
        }
        return newStamp;
    }
    public static boolean canStamp(char[][] grid, char[][] stamp, int x, int y) {
        int k = stamp.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (stamp[i][j] == '*' && grid[x + i][y + j] == '.') {
                    return false; 
                }
            }
        }
        return true;
    }
    public static void applyStamp(boolean[][] visited, char[][] stamp, int x, int y) {
        int k = stamp.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (stamp[i][j] == '*') {
                    visited[x + i][y + j] = true;
                }
            }
        }
    }
}


