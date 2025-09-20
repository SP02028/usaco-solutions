import java.io.*;
import java.util.*;

public class IntoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Read the first line for N and the "useless" integer
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int useless = Integer.parseInt(st.nextToken());

        // Read the numbers from the second line
        String[] inputNumbers = br.readLine().trim().split(" ");
        if (inputNumbers.length != N) {
            pw.println("Invalid input: Expected " + N + " numbers.");
            pw.close();
            return;
        }

        // Initialize arrays and structures
        int[] nums = new int[N];
        HashSet<Integer> distinct = new HashSet<>();
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        HashMap<Integer, Integer> otn = new HashMap<>();
        int count = 0;

        // Parse numbers
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputNumbers[i]);
            distinct.add(nums[i]);
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
        }

        // Handle single distinct value case
        if (occurrences.keySet().size() == 1) {
            pw.println(0);
            pw.close();
            return;
        }

        // Determine the maximum occurring element
        int maxele = Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey();
        otn.put(maxele, maxele);

        // Process elements for block adjustments
        for (int i = 1; i < N - 1; i++) { // Avoid boundary elements
            int ele = nums[i];

            if (otn.containsKey(ele)) {
                if (otn.get(ele) == ele) {
                    continue;
                } else {
                    count++;
                }
            } else {
                if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                    otn.put(ele, nums[i - 1]);
                } else {
                    count++;
                }
            }
        }

        // Output the result
        pw.println(count);
        pw.close();
    }
}


