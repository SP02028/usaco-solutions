import java.io.*;
import java.util.*;

public class MM {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int G = kattio.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] log = new int[N][3];
        for (int i = 0; i < N; i++) {
            log[i][0] = kattio.nextInt();
            log[i][1] = kattio.nextInt();
            log[i][2] = kattio.nextInt();
            map.put(log[i][1], G);
        }
        Arrays.sort(log, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> milks = new HashMap<>();

        int baseline = N + 1; // "plenty of other cows" always at G
        milks.put(G, baseline + map.size());

        priorityQueue.add(G);
        int count = 0;
        for (int[] l : log) {

            while (!milks.containsKey(priorityQueue.peek())) {
                priorityQueue.poll();
            }

            int cow = l[1];
            int amount = map.get(cow);
            int prevmax = priorityQueue.peek();
            int prevmaxcount = milks.get(prevmax);
            boolean prevtop = amount == prevmax;
            milks.put(amount, milks.get(amount) - 1);
            if (milks.get(amount) == 0) {
                milks.remove(amount);
            }
            amount += l[2];
            map.put(cow, amount);
            milks.put(amount, milks.getOrDefault(amount, 0) + 1);
            priorityQueue.add(amount);
            while (!milks.containsKey(priorityQueue.peek())) {
                priorityQueue.poll();
            }
            int currmax = priorityQueue.peek();
            int currmaxcount = milks.get(currmax);
            boolean istop = amount == currmax;
            if (prevtop) {
                if (!istop || prevmaxcount != currmaxcount) {
                    count++;
                }
            } else if (istop) {
                count++;
            }
        }

        kattio.println(count);
        kattio.close();
    }

    static class Kattio extends PrintWriter {
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
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        @Override
        public void close() {
            super.close();
            try {
                r.close();
            } catch (IOException ignored) {}
        }
    }
}
