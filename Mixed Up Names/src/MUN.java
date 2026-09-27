import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MUN {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = kattio.next();
        }
        String[] asc = new String[N];
        String[] desc = new String[N];
        for (int i = 0; i < N; i++) {
            asc[i] = sortAscend(words[i]);
            desc[i] = sortDescend(words[i]);
        }
        String[] sortedAsc = Arrays.copyOf(asc, N);
        Arrays.sort(sortedAsc);
        String[] sortedDesc = Arrays.copyOf(desc, N);
        Arrays.sort(sortedDesc);
        for (int i = 0; i < N; i++) {
            int forced_before = lowerBound(sortedDesc, asc[i]);
            int forced_after = N-upperBound(sortedAsc, desc[i]);
            int min = forced_before+1;
            int max = N- forced_after;
            kattio.println(min + " " + max);
        }
        kattio.close();
    }
    public static int lowerBound(String[] sortedArr, String key) {
        int lo = 0, hi = sortedArr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArr[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public static int upperBound(String[] sortedArr, String key) {
        int lo = 0, hi = sortedArr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArr[mid].compareTo(key) <= 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public static String sortAscend(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }
    public static String sortDescend(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
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

        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }

                    this.st = new StringTokenizer(line);
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
