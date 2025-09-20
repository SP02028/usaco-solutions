import java.util.*;
import java.io.*;

public class MooOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            ArrayList<Character> str = new ArrayList<>();
            char[] line = br.readLine().toCharArray();
            for (char c : line) {
                str.add(c);
            }
            
            int count = 0;

            // Ensure first character is 'M'
            while (!str.isEmpty() && str.get(0) != 'M') {
                str.remove(0);
                count++;
            }

            // Reduce to size 3 if needed
            while (str.size() > 3) {
                str.remove(str.size() - 1);
                count++;
            }

            if (str.size() == 3) {
                if (str.get(2) == 'M') {
                    str.set(2, 'O');
                    count++;
                }
                if (str.get(0) == 'M' && str.get(1) == 'O' && str.get(2) == 'O') {
                    pw.println(count);
                } else {
                    pw.println(-1);
                }
            } else {
                pw.println(-1);
            }
        }
        pw.close();
    }
}
