import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YY {
public static void main(String[] args) {
    Kattio kattio = new Kattio();
    int T = kattio.nextInt();
    while(T-->0){
        String string =  kattio.next();
        char[] str = string.toCharArray();
        int Yct = 0;
        for (int i = 0; i < str.length; i++) {
           if(str[i]=='Y'){
               Yct++;
           }

        }
        if(Yct>1){
            kattio.println("NO");
        }else{
            kattio.println("YES");
        }
    }
    kattio.close();
}
    static class Kattio extends PrintWriter {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public Kattio() { super(System.out); }

        String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
