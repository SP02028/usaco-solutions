import java.util.*;
import java.io.*;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int x = 0;
            int sum = 0;
            //smallest x where sum >= num
            while (sum < num) {
                x++;
                sum += x;
            }
            // If sum - num == 1, take an extra step
            if (sum - num == 1) {
                x++;
            }

            pw.println(x);
        }
        pw.close();
    }
}
