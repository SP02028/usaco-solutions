import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BB {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            int N = kattio.nextInt();
            boolean[] sd =  new boolean[N];
            //read in input and represent whether or not characters should be same or different in a boolean array
            String string = kattio.next();
            int C1 = 0;
            int C0 = 0;
            for (int i = 0; i < N; i++) {
                if (string.charAt(i) == '0') {
                    sd[i] = true;
                    C0++;
                }else{
                    sd[i] = false;
                    C1++;
                }
            }
            if (C1 % 2 != 0) {
                kattio.println("NO");
                continue;
            }
            if (sd[0] || sd[N - 1]) {
                kattio.println("NO");
                continue;
            }
            int count1 = 0;
            int count0 = 0;
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < N; i++) {
                char c = string.charAt(i);
                if (c == '1') {
                    count1++;
                    if (count1 <= C1 / 2) {
                        a.append('(');
                        b.append('(');
                    } else {
                        a.append(')');
                        b.append(')');
                    }
                } else{
                    count0++;
                    if(count0 %2==1){
                        a.append('(');
                        b.append(')');
                    }else {
                        a.append(')');
                        b.append('(');
                    }
                }
            }
            kattio.println("YES");
            kattio.println(a.toString());
            kattio.println(b.toString());
        }
        kattio.close();
    }
    public static boolean valid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if(curr=='('){
                stack.push('(');
            }else if(curr == ')'){
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
