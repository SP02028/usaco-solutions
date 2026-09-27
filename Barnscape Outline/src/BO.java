import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BO {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long W = kattio.nextInt();
        ArrayList<Long> heights = new ArrayList<>();
        long[][] coords = new long[N][2];
        for (int i = 0; i < N; i++) {
            long a =kattio.nextLong();
            long b = kattio.nextLong();
            coords[i] = new long[]{a,b};
            heights.add(b);
        }
        Stack<Long> stack = new Stack<>();
        long ans =0;
        if(heights.get(0)>0)stack.push(heights.get(0));
   //     System.out.println(heights.get(0));
        for (int i = 1; i < N; i++) {
            long curr = heights.get(i);
       //     System.out.println(curr);
            if(stack.isEmpty() || curr > stack.peek()){
                if(curr>0) stack.push(curr);
           //     System.out.println("Pushed");
            }
            else if(!stack.isEmpty() && curr < stack.peek()){
                while(!stack.isEmpty() && stack.peek()>curr){
             //       System.out.println(stack.peek() + " is popped");
                    stack.pop();

                    ans++;
                }
                if (stack.isEmpty() || stack.peek() < curr) {
                    //     System.out.println("We pushed the lesser height to the stack");
                    if(curr>0) stack.push(curr);
                }
            }
        }
        kattio.println(ans+stack.size());
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
