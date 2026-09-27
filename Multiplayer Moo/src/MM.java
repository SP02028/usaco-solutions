import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Multimoo (USACO) style solver.
 *
 * We compute two answers:
 *  1) ans1 = largest connected region made of a single value (4-direction adjacency)
 *  2) ans2 = largest connected region made of exactly two values (still 4-direction adjacency)
 *
 * This implementation follows the "C++ pair-of-values BFS" logic:
 *  - First compute ans1 by flood-filling same-value regions.
 *  - Track how many total cells each value has (total[value]).
 *  - Build a list of values present and sort by total descending for pruning.
 *  - For each pair (t1, t2) with potential to beat current ans2, run flood-fills restricted to {t1, t2}
 *    and take the best region size over those flood-fills.
 */
public class MM {

    // Grid dimension
    static int N;

    // grid[r][c] is the cow ID / color at cell (r,c)
    static int[][] grid;

    // Values in the original problem can be up to 1e6 (per your C++ code).
    static final int MAX_A = 1_000_000;

    // 4-direction movement (no diagonals)
    static final int[] DR = {1, 0, -1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) {
        Kattio kattio = new Kattio();

        N = kattio.nextInt();
        grid = new int[N][N];

        int[] total = new int[MAX_A + 1];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++)f {
                int v = kattio.nextInt();
                grid[r][c] = v;

                // Defensive bounds check (values are expected to be within [0, MAX_A]).
                if (0 <= v && v <= MAX_A) total[v]++;
            }
        }

        // -----------------------------
        // 2) One-cow answer (ans1)
        //    Flood-fill each unvisited cell for its single value
        //    Track the size of each same-value connected component
        // -----------------------------

        // seen[r][c] marks whether we have visited the cell during the one-cow flood-fills.
        boolean[][] seen = new boolean[N][N];

        // maxComp[v] = maximum component size among components of value v.
        // Not strictly required just to print ans1, but mirrors the C++ logic.
        int[] maxComp = new int[MAX_A + 1];

        // ans1 = best single-color region size found so far
        int ans1 = 0;

        // Queue for iterative BFS (avoids recursion depth issues)
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // Loop over every cell; if not visited, flood-fill its connected same-value region.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (seen[r][c]) continue;

                int color = grid[r][c];
                int cnt = 0; // size of this component

                // Start BFS from (r,c)
                seen[r][c] = true;
                q.addLast(new int[]{r, c});

                while (!q.isEmpty()) {
                    int[] cur = q.removeFirst();
                    int cr = cur[0], cc = cur[1];
                    cnt++;

                    // Explore 4 neighbors
                    for (int k = 0; k < 4; k++) {
                        int nr = cr + DR[k];
                        int nc = cc + DC[k];

                        // Bounds check
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                        // Already visited in this phase
                        if (seen[nr][nc]) continue;

                        // Only expand into cells of the same value
                        if (grid[nr][nc] != color) continue;

                        seen[nr][nc] = true;
                        q.addLast(new int[]{nr, nc});
                    }
                }

                // Update per-value max component (optional bookkeeping)
                if (0 <= color && color <= MAX_A) {
                    if (cnt > maxComp[color]) maxComp[color] = cnt;
                }

                // Update global best for one-cow
                if (cnt > ans1) ans1 = cnt;
            }
        }

        // Print the first answer
        kattio.println(ans1);

        // -----------------------------
        // 3) Prepare list of values that actually appear (vals)
        //    We'll only consider pairs among values that exist in the grid.
        // -----------------------------
        ArrayList<Integer> vals = new ArrayList<>();
        for (int v = 0; v <= MAX_A; v++) {
            if (total[v] > 0) vals.add(v);
        }

        // Sort values by descending frequency (total[]), like C++ cmp.
        // This enables pruning: for fixed t1, when we iterate t2 in sorted order,
        // total[t1] + total[t2] only decreases as t2 moves forward.
        Collections.sort(vals, (a, b) -> Integer.compare(total[b], total[a]));

        // -----------------------------
        // 4) Two-cow answer (ans2)
        //
        // For each pair of values (t1,t2), we run flood-fills restricted to cells whose value is t1 or t2.
        // For that restricted grid, the largest connected component size is a candidate for ans2.
        //
        // Pruning:
        //  - If total[t1] + total[t2] <= ans2, then even if all those cells were connected,
        //    it wouldn't beat the current best, so skip.
        // -----------------------------
        int ans2 = ans1; // ans2 is at least ans1 (a 1-color region is also a 2-color region)

        int m = vals.size();

        // seen2[r][c] is the visited grid for the current (t1,t2) pair.
        // We must clear this for each pair (or use a token technique; we keep it simple like your C++).
        boolean[][] seen2 = new boolean[N][N];

        // Queue for BFS in the two-cow phase
        ArrayDeque<int[]> q2 = new ArrayDeque<>();

        // Outer loop picks the first value t1
        for (int i = 0; i < m; i++) {
            int t1 = vals.get(i);

            // Inner loop picks the second value t2 > t1 in the sorted list
            for (int j = i + 1; j < m; j++) {
                int t2 = vals.get(j);

                // Prune pairs that cannot possibly beat current ans2.
                // Because vals is sorted by total descending, once this fails,
                // all later t2 will have total <= current t2, so we can break.
                if (total[t1] + total[t2] <= ans2) break;

                // Clear seen2 for this (t1,t2) pair.
                // (O(N^2) per pair; this mirrors the brute-force approach in the C++ code.)
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        seen2[r][c] = false;
                    }
                }

                // bestPair tracks the best restricted-component size for this specific value pair (t1,t2)
                int bestPair = 0;

                // Scan all cells; whenever we find an unvisited cell that is either t1 or t2,
                // BFS flood-fill the connected component under the rule "cells must be t1 or t2".
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        int v = grid[r][c];

                        // Skip cells that aren't in this pair
                        if (v != t1 && v != t2) continue;

                        // Skip cells already visited for this pair
                        if (seen2[r][c]) continue;

                        int cnt = 0; // size of this restricted component

                        // Start BFS
                        seen2[r][c] = true;
                        q2.addLast(new int[]{r, c});

                        while (!q2.isEmpty()) {
                            int[] cur = q2.removeFirst();
                            int cr = cur[0], cc = cur[1];
                            cnt++;

                            // Expand to 4 neighbors if they are t1 or t2
                            for (int k = 0; k < 4; k++) {
                                int nr = cr + DR[k];
                                int nc = cc + DC[k];

                                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                                if (seen2[nr][nc]) continue;

                                int nv = grid[nr][nc];
                                if (nv != t1 && nv != t2) continue;

                                seen2[nr][nc] = true;
                                q2.addLast(new int[]{nr, nc});
                            }
                        }

                        // Update best component for this pair, and global ans2
                        if (cnt > bestPair) bestPair = cnt;
                        if (bestPair > ans2) ans2 = bestPair;
                    }
                }
            }
        }

        // Print the second answer
        kattio.println(ans2);
        kattio.close();
    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
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
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
