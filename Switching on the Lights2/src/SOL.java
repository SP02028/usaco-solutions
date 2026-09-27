import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class SOL {
    static List<int[]>[][] lights; // lights[x][y] = list of rooms (a,b) that a switch in (x,y) can light up
    static boolean[][] lit;        // lit[r][c] = true if the room's light has been turned on (by anyone, anytime)
    static boolean[][] visited;    // visited[r][c] = true if Bessie can actually walk into this room
    static int N;
    static int roomCount = 0;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        N = io.nextInt();
        int M = io.nextInt();
        lights = new List[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                lights[i][j] = new ArrayList();
            }
        }

        for (int i = 0; i < M; ++i) {
            int x = io.nextInt() - 1;
            int y = io.nextInt() - 1;
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            lights[x][y].add(new int[]{a, b});
        }

        lit = new boolean[N][N];
        visited = new boolean[N][N];
        lit[0][0] = true;
        // We use a BFS approach where a node only enters the queue once it becomes VISITED
        // (i.e. reachable). This guarantees: by the time we pop a node and process its
        // switches, Bessie is guaranteed to actually be able to stand in that room.
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] currnode = queue.poll();

            // currnode just became visited. Check its 4 grid neighbors: if a neighbor is
            // already LIT (maybe lit earlier by some unrelated switch) but not yet visited,
            // it's now reachable through currnode, so mark it visited and enqueue it.
            for (int d = 0; d < 4; d++) {
                int nr = currnode[0] + dr[d];
                int nc = currnode[1] + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (lit[nr][nc] && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            // Since currnode is visited, Bessie is physically standing here, so she's allowed
            // to use every switch located in this room. Each switch lights up its target room
            // (nbr), regardless of whether nbr itself is reachable
            List<int[]> neighbors = lights[currnode[0]][currnode[1]];
            for (int[] nbr : neighbors) {
                if (!lit[nbr[0]][nbr[1]]) {
                    lit[nbr[0]][nbr[1]] = true; // the switch turns this room's light on
                }
                // The room we just lit might ALREADY be sitting right next to a visited room
                // Check its 4 neighbors now: if any is visited, this room is reachable too.
                if (!visited[nbr[0]][nbr[1]]) {
                    for (int d = 0; d < 4; d++) {
                        int nr = nbr[0] + dr[d];
                        int nc = nbr[1] + dc[d];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && visited[nr][nc]) {
                            visited[nbr[0]][nbr[1]] = true;
                            queue.add(nbr);
                            break; // one visited neighbor is enough, no need to keep checking
                        }
                    }
                }
            }
        }

        for (boolean[] l : lit) {
            for (boolean i : l) {
                if (i) roomCount++;
            }
        }
        io.println(roomCount);
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            this.r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (this.st == null || !this.st.hasMoreTokens()) {
                    this.st = new StringTokenizer(this.r.readLine());
                }
                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public double nextDouble() {
            return Double.parseDouble(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}