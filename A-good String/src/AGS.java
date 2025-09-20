import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AGS {

    // Recursive function to calculate minimum changes
    public static int calc(String s, char c) {
        if (s.length() == 1) {
            return s.charAt(0) != c ? 1 : 0;
        }
        int mid = s.length() / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid);

        // Cost for left half being "good"
        int costLeft = calc(left, (char)(c + 1));
        int wrongInRight = 0;
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) != c) {
                wrongInRight++;
            }
        }
        costLeft += wrongInRight;

        // Cost for right half being "good"
        int costRight = calc(right, (char)(c + 1));
        int wrongInLeft = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != c) {
                wrongInLeft++;
            }
        }
        costRight += wrongInLeft;

        return Math.min(costLeft, costRight);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim()); // Number of test cases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // Read the length of the string
            String s = br.readLine().trim(); // Read the string
            pw.println(calc(s, 'a')); // Call calc and print the result
        }
        pw.flush();
        pw.close();
    }
}
