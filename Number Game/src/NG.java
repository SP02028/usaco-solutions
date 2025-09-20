import java.io.*;

public class NG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean lose = (n == 1);
            
            if (n > 2 && n % 2 == 0) {
                if ((n & (n - 1)) == 0) {
                    lose = true;
                } else if (n % 4 != 0 && checkPrime(n / 2)) {
                    lose = true;
                }
            }
            
            if (lose) {
                pw.println("FastestFinger");
            } else {
                pw.println("Ashishgup");
            }
        }
        br.close();
        pw.close();
    }
    
    private static boolean checkPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }
}
