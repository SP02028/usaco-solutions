import java.io.*;
import java.util.*;

public class IS {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int T = io.nextInt();
        while(T-->0) {
            int n = io.nextInt();
            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = io.next();
            }

            int[][] counts = new int[n][5];
            int[] lengths = new int[n];

            for (int i = 0; i < n; i++) {
                lengths[i] = words[i].length();
                for (char ch : words[i].toCharArray()) {
                    if (ch >= 'a' && ch <= 'e') {
                        counts[i][ch - 'a']++;
                    }
                }
            }

            int max = 0;
            for (int c = 0; c < 5; c++) {
                // Calculate scores for this letter
                Integer[] scores = new Integer[n];
                for (int i = 0; i < n; i++) {
                    scores[i] = (2 * counts[i][c]) - lengths[i];
                }
                Arrays.sort(scores, Collections.reverseOrder());
                int count = 0;
                int pref = 0;

                for (int i = 0; i < n; i++) {
                    pref += scores[i];
                    if (pref > 0) {
                        count++;
                    } else {
                        break;
                    }
                }

                max = Math.max(max, count);
            }

        io.println(max);}
        io.close();
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
    public Kattio(String problemName) throws IOException {
        super(problemName + ".out");
        r = new BufferedReader(new FileReader(problemName + ".in"));
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
