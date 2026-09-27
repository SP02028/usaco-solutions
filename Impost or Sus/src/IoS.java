import java.io.*;
import java.util.StringTokenizer;

public class IoS {

public static void main(String[] args) {
    Kattio IO = new Kattio();
    int N = IO.nextInt();
    while(N-->0){
        String string = IO.next();
        if(!string.contains("u")){
            IO.println(0);
        }
        int first = string.indexOf('u');
        StringBuilder string1 = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(i!=first){
                string1.append('s');
            }
            else{
                string1.append("u");
            }
        }
        int ops =0;
        for (int i = 0; i < string.length(); i++) {
            if(string1.charAt(i)!=string.charAt(i)){
                ops++;
            }
        }
        if(string.length()%2!=0&& string.length()%3!=0){
            IO.println(ops);
            continue;
        }
        else{
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3= new StringBuilder();
            if(string.length()%2==0){
                for (int i = 0; i < string.length()-1; i+=2) {
                    str2.append("su");
                }
            }
            if(string.length()%3==0){
                for (int i = 0; i < string.length()-2; i+=3) {
                    str3.append("sus");
                }
            }
            int ops2 = 0;
            int ops3= 0;
            boolean pos2 = true;
            boolean pos3 = true;
            for (int i = 0; i < string.length(); i++) {
                if(!str2.isEmpty() && str2.charAt(i)!=string.charAt(i)){
                    if (string.charAt(i) == 's') {
                        pos2 = false;
                        break;
                    }
                    else{
                        ops2++;
                    }
                }
                if(!str3.isEmpty() && str3.charAt(i)!=string.charAt(i)){
                    if (string.charAt(i) == 's') {
                        pos3 = false;
                        break;
                    }
                    else{
                        ops3++;
                    }
                }
            }
            if(!pos2&& !pos3){
                IO.println(ops);
            }
            else if(!pos3){
                IO.println(ops2);
            }
            else if(!pos2){
                IO.println(ops3);
            }
            else{
                IO.println(Math.min(ops, Math.min(ops2, ops3)));
            }
        }
    }
    IO.close();
}
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // Standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // Returns null if no more input
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
