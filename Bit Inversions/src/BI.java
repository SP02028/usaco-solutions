import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class BI {
    static     TreeSet<Integer> splits = new TreeSet<>();
static     TreeMap<Integer, Integer> blocks = new TreeMap<>();

    public static void main(String[] args) {
    Kattio kattio  = new Kattio();
    String string = kattio.next();
    int N  = kattio.nextInt();
    int[] updates = new int[N];
    for (int i = 0; i < N; i++) {
        updates[i] = kattio.nextInt();
    }
    splits.add(0);
    splits.add(string.length());
    blocks.put((string.length()),1);
    for (int i = 0; i < string.length()-1; i++) {
        if(string.charAt(i)!= string.charAt(i+1)){
            query(i+1);
        }
    }
    for(int update:updates){
        query(update-1);
        kattio.print(query(update) + " ");
    }
    kattio.close();
}
static int query(int a){
    long r =  Long.MAX_VALUE;
    boolean exists = splits.contains(a);
    Integer prev = splits.lower(a);
    Integer next = splits.higher(a);
    if(prev==null || next ==null){
        if(blocks.isEmpty()) return 0;
        else return blocks.lastKey();
    }
    if (exists) {
        splits.remove(a);
        decrementBlock(next - a);
        decrementBlock(a - prev);
        incrementBlock(next - prev);
    } else {
        splits.add(a);
        decrementBlock(next - prev);
        incrementBlock(next - a);
        incrementBlock(a - prev);
    }

    return blocks.lastKey();
}

    private static void incrementBlock(int size) {
        blocks.put(size, blocks.getOrDefault(size, 0) + 1);
    }

    private static void decrementBlock(int size) {
        int count = blocks.getOrDefault(size, 0);
        if (count <= 1) {
            blocks.remove(size);
        } else {
            blocks.put(size, count - 1);
        }
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