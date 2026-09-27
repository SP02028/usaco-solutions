import java.util.*;
import java.io.*;
public class AB {
    public static int goClosed(String s) {
        int cntO = 0;
        int cntC = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cntO++;
            } else {
                cntC++;
            }

            if (cntC > cntO) {
                return cntC;
            }
        }
        return 0;
    }
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
      Kattio kattio = new Kattio();
      String str = kattio.next();
       int ans1 = goClosed(str);
        str = reverse(str);
        str = flip(str);
        int ans2 = goClosed(str);

        kattio.println(Math.max(ans1, ans2));

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
