import java.io.*;

public class SFAM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());     
        for(int tc=0;tc<t;tc++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            boolean found = false;
              for (int i = 0; i < n; i++) {
                int x = s.charAt(i) - '0';
                if (isComposite(x)) {
                    out.println(1);
                    out.println(x);
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            outerLoop:
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int p = s.charAt(i) - '0';
                    int q = s.charAt(j) - '0';
                    int x = p * 10 + q;
                    if (isComposite(x)) {
                        out.println(2);
                        out.println(x);
                        found = true;
                        break outerLoop;
                    }
                }
            }           
            if (found) {
                continue;
            }
            out.println(n);
            out.println(s);
        }        
        out.close();
    }
 // Function to check if a number is composite (not prime)
    static boolean isComposite(int n) {
        if (n == 1) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}

