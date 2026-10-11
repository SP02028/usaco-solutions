import java.io.*;
import java.util.*;

public class MM {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] grid;
    static int comps =0;
    static    Map<Integer, List<Integer>> columnMap = new HashMap<>();
    static int K;
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        N = kattio.nextInt();
        K = kattio.nextInt();
        grid = new int[N][10];
        visited = new boolean[N][10];
        for (int i = 0; i < N; i++) {
            String line = kattio.next();
            for (int j = 0; j < 10; j++) {
                grid[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        while(true){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    if(!visited[i][j] && grid[i][j]!= 0){
                        bfsComponent(i, j, grid[i][j]);
                    }
                }
            }
            if(comps ==0) break;
            int[][] grid2 = new int[N][10];
            for (int i = 0; i < 10; i++) {
                int[] freq = new int[N];
                for (int j : columnMap.getOrDefault(i, Collections.emptyList())) {
                    grid2[j][i]=0;
                    freq[j]++;
                }
                int currrow =N-1;
                for (int j = N-1; j >=0; j--) {
                    if(freq[j] ==0){
                        grid2[currrow][i]= grid[j][i];
                        currrow--;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j] = grid2[i][j];
                }
            }
            //reset
            columnMap.clear();
            comps=0;
            visited = new boolean[N][10];
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                kattio.print(grid[i][j]);
            }
            kattio.println();
        }
        kattio.close();
    }

    public static void bfsComponent(int startR, int startC, int targetValue) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<int[]> currentComponent = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        visited[startR][startC] = true;
        queue.add(new int[]{startR, startC});
        currentComponent.add(new int[]{startR, startC});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir : DIRECTIONS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] == targetValue) {

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    currentComponent.add(new int[]{nr, nc});
                }
            }
        }

        if (currentComponent.size() >= K) {
            comps++;
            for (int[] cell : currentComponent) {
                int r = cell[0];
                int c = cell[1];
                columnMap.putIfAbsent(c, new ArrayList<>());
                columnMap.get(c).add(r);
            }
        }
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { return null; }
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
