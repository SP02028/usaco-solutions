import java.util.*;
import java.io.*;

public class cs1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] str = st.nextToken().toCharArray();
        Arrays.sort(str);
        int uniquePermutations = rearrange(str);
        pw.println(uniquePermutations);
        pw.flush(); // Ensure this output appears before permutations
        permute(str, 0, str.length - 1);
        pw.close();
    }

    // Generate permutations in lexicographic order
    public static void permute(char[] a, int l, int r) {
        if (l == r) {
            System.out.println(new String(a));
        } else {
            for (int i = l; i <= r; i++) {
                if (i != l && a[i] == a[l]) {
                    continue; // Skip duplicates
                }
                swap(a, l, i);
                permute(a, l + 1, r);
                swap(a, l, i); // Backtrack
            }
        }
    }

    // Swap helper function
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Factorial calculation
    public static int factorial(int x) {
        int temp = 1;
        for (int i = x; i > 0; i--) {
            temp *= i;
        }
        return temp;
    }

    // Calculate number of unique arrangements
    public static int rearrange(char[] r) {
        Map<Character, Integer> m = new HashMap<>();
        for (char ele : r) {
            m.put(ele, m.getOrDefault(ele, 0) + 1);
        }

        int len = factorial(r.length);
        for (int num : m.values()) {
            len /= factorial(num);
        }
        return len;
    }
}

