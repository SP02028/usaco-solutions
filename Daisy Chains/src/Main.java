import java.io.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] flowers = new int[n];
        StringTokenizer t = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++) {
            flowers[i] = Integer.parseInt(t.nextToken());
        }
        List<List<Integer>> allSubsets = new ArrayList<>();
        int maxLength = n;
        for (int length = 1; length <= maxLength; length++) {
            for (int start = 0; start <= n - length; start++) {
                List<Integer> curr = new ArrayList<>();
                for (int i = start; i < start + length; i++) {
                    curr.add(flowers[i]);
                }
                allSubsets.add(curr);
            }
        }
        int count = 0;
        for (List<Integer> subset : allSubsets) {
            int sum = 0;
            for (int ele : subset) {
                sum += ele;
            }
            double average = (double) sum / subset.size();
            if (average == (int) average && subset.contains((int) average)) {
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}
