import java.util.*;
import java.io.*;

public class YC {

    static class Kattio extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        Kattio() {
            super(new BufferedOutputStream(System.out));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int k = io.nextInt();

        TreeSet<Integer> s = new TreeSet<>();
        ArrayList<Integer> dist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = io.nextInt();
            s.add((val + 11) / 12);
        }

        long ans = s.last();
        int lst = 0;

        while (!s.isEmpty()) {
            int sm = s.first();
            dist.add(sm - lst - 1);
            lst = sm;
            s.pollFirst();
        }

        dist.sort(Collections.reverseOrder());

        for (int i = 0; i < k - 1 && i < dist.size(); i++) {
            ans -= dist.get(i);
        }

        io.println(ans * 12);
        io.flush();
    }
}
