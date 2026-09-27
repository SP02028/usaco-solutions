import java.io.*;
import java.util.*;

public class MazeTacToe {
    /*
     Representation of the maze:
     0 - wall (#)
     1 - empty space (.)
     2 - Bessie start (B)
     3 - O (part of a game piece in the maze)
     4 - M (part of another game piece in the maze)
    */

    static int n;  // Maze dimensions (n x n)
    static int[][][] arr = new int[50][50][3];  // Maze representation: [cell type, coord1, coord2]
    static List<int[]> startingPoints = new ArrayList<>();  // All interesting starting points (O/M/B nodes)
    static Map<String, List<int[]>> graph = new HashMap<>();  // Graph adjacency list
    static boolean[][] visited = new boolean[50][50];  // Tracks visited cells for BFS
    static Map<String, Boolean> vboards = new HashMap<>();  // Keeps track of visited states (board+position)
    static boolean[] gboards = new boolean[20000];  // Flags if a board state was reached
    static int[] bessie = new int[2];  // Bessie's starting coordinates (row, column)
    static int[][] adj = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // Directions for BFS movement

    // Helper function: Calculates a^b (a raised to the power b)
    static int pow(int a, int b) {
        if (b == 0) return 1;  // Base case: exponent is 0
        int ret = pow(a, b / 2);
        return (b % 2 == 0) ? ret * ret : ret * ret * a;
    }

    // Helper function: Checks if a move is within the bounds of the grid
    static boolean inGrid(int grid, int move) {
        // Traverse the grid representation and verify if the move affects a valid spot
        while (move >= 3) {
            grid /= 3;
            move /= 3;
        }
        return grid % 3 > 0;
    }

    // Helper function: Gets the element at index `ind` from the compact board representation
    static int getElement(int grid, int ind) {
        return (grid / pow(3, ind)) % 3;
    }

    // Helper function: Checks if the given board state is a winning one
    static boolean checkWinning(int grid) {
        // Checks all possible win conditions for 3x3 Tic-Tac-Toe board
        for (int i = 0; i < 3; i++) {
            // Row checks
            if (getElement(grid, 3 * i) == 1 && getElement(grid, 3 * i + 1) == 1 && getElement(grid, 3 * i + 2) == 2)
                return true;
            if (getElement(grid, 3 * i) == 2 && getElement(grid, 3 * i + 1) == 1 && getElement(grid, 3 * i + 2) == 1)
                return true;
            // Column checks
            if (getElement(grid, i) == 1 && getElement(grid, i + 3) == 1 && getElement(grid, i + 6) == 2)
                return true;
            if (getElement(grid, i) == 2 && getElement(grid, i + 3) == 1 && getElement(grid, i + 6) == 1)
                return true;
        }
        // Diagonal checks
        if (getElement(grid, 0) == 1 && getElement(grid, 4) == 1 && getElement(grid, 8) == 2) return true;
        if (getElement(grid, 0) == 2 && getElement(grid, 4) == 1 && getElement(grid, 8) == 1) return true;
        if (getElement(grid, 2) == 1 && getElement(grid, 4) == 1 && getElement(grid, 6) == 2) return true;
        if (getElement(grid, 2) == 2 && getElement(grid, 4) == 1 && getElement(grid, 6) == 1) return true;
        return false;
    }

    // Generates a coordinate key 
    static String coordKey(int x, int y) {
        return x + "," + y;
    }

    //Generates a board key 
    static String boardKey(int board, int x, int y) {
        return board + "," + x + "," + y;
    }

    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        n = kattio.nextInt();  // Read maze size

        // Read the maze and construct the initial representation
        for (int i = 0; i < n; i++) {
            String s = kattio.next();
            for (int j = 0; j < n; j++) {
                char ch = s.charAt(3 * j);
                if (ch == '#') {
                    arr[i][j][0] = 0;  // Wall
                } else if (ch == '.') {
                    arr[i][j][0] = 1;  // Empty
                } else if (ch == 'B') {
                    arr[i][j][0] = 2;  // Bessie
                    startingPoints.add(new int[]{i, j});
                    bessie[0] = i;
                    bessie[1] = j;
                } else if (ch == 'O' || ch == 'M') {
                    arr[i][j][0] = (ch == 'O' ? 3 : 4);  // 'O' or 'M'
                    arr[i][j][1] = s.charAt(3 * j + 1) - '0';
                    arr[i][j][2] = s.charAt(3 * j + 2) - '0';
                    startingPoints.add(new int[]{i, j});
                }
            }
        }

        // Build the graph (perform BFS to connect nodes reachable by '.')
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int[] p : startingPoints) {
            for (int i = 0; i < n; i++) Arrays.fill(visited[i], false);
            visited[p[0]][p[1]] = true;
            q.add(new int[]{p[0], p[1]});
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                for (int[] dir : adj) {
                    int nextm = curr[0] + dir[0];
                    int nextn = curr[1] + dir[1];
                    if (nextm >= 0 && nextm < n && nextn >= 0 && nextn < n && !visited[nextm][nextn]) {
                        visited[nextm][nextn] = true;
                        if (arr[nextm][nextn][0] == 1) {  // Empty space
                            q.add(new int[]{nextm, nextn});
                        }
                        if (arr[nextm][nextn][0] >= 2) {  // Connect nodes
                            String key = coordKey(p[0], p[1]);
                            graph.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{nextm, nextn});
                        }
                    }
                }
            }
        }

        // BFS to explore all reachable board states from Bessie's initial position
        ArrayDeque<int[]> b = new ArrayDeque<>();
        String bessieBoardKey = boardKey(0, bessie[0], bessie[1]);
        vboards.put(bessieBoardKey, true);  // Mark initial state visited
        gboards[0] = true;  // Mark the initial board state as valid
        b.add(new int[]{0, bessie[0], bessie[1]});  // Initial state
        while (!b.isEmpty()) {
            int[] curr = b.poll();
            String currCoordKey = coordKey(curr[1], curr[2]);
            if (graph.containsKey(currCoordKey)) {
                for (int[] p : graph.get(currCoordKey)) {
                    // Compute the board state after moving to p
                    int moveFirst = arr[p[0]][p[1]][0];
                    int moveSecond1 = arr[p[0]][p[1]][1];
                    int moveSecond2 = arr[p[0]][p[1]][2];
                    int movetoint = (moveFirst - 2) * pow(3, 3 * moveSecond1 + moveSecond2 - 4);
                    int newboard = curr[0];
                    if (!inGrid(newboard, movetoint)) {
                        newboard += movetoint;  // Update board state
                    }
                    String newKey = boardKey(newboard, p[0], p[1]);
                    if (!vboards.containsKey(newKey)) {
                        vboards.put(newKey, true);
                        gboards[newboard] = true;  // Mark this board state as reachable
                        if (!checkWinning(newboard)) {
                            b.add(new int[]{newboard, p[0], p[1]});
                        }
                    }
                }
            }
        }

        // Count all winning board states
        int tot = 0;
        for (int i = 0; i < pow(3, 9); i++) {
            if (gboards[i] && checkWinning(i)) {
                tot++;
            }
        }
        kattio.println(tot);  // Output the result
        kattio.close();
    }

    static class Kattio extends
            PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
