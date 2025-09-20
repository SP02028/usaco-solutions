import java.io.*;
import java.util.*;

public class cq {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        List<int[]> reserved = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (line[j] == '*') {
                    reserved.add(new int[]{j, i});
                }
            }
        }
        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 7};
        int count = 0;
        List<List<Integer>> permutations = getAllPermutations(arr2);
        for (List<Integer> permutation : permutations) {
            boolean taken = false;
            int[][] positions = new int[8][2];
            for (int n = 0; n < 8; n++) {
                positions[n][0] = n;
                positions[n][1] = permutation.get(n);
                for (int[] res : reserved) {
                    if (res[0] == positions[n][0] && res[1] == positions[n][1]) {
                        taken = true;
                        break;
                    }
                }
                if (taken) break;
            }
            if (taken) continue;
            if (!hasDiagonalConflict(positions)) {
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
    private static boolean hasDiagonalConflict(int[][] positions) {
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        for (int[] pos : positions) {
            int d1 = pos[0] - pos[1]; // Row - Col
            int d2 = pos[0] + pos[1]; // Row + Col
            if (diag1.contains(d1) || diag2.contains(d2)) {
                return true;
            }
            diag1.add(d1);
            diag2.add(d2);
        }
        return false;
    }
    public static List<List<Integer>> getAllPermutations(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permuteAndStore(arr, 0, result);
        return result;
    }
    private static void permuteAndStore(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permuteAndStore(arr, index + 1, result);
            swap(arr, i, index);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
