import java.util.*;
import java.io.*;

public class ST {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine()); // num pairs
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Input read
        ArrayList<Integer> notused = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            notused.add(i);
        }
        int count = 0;
        while (!notused.isEmpty()) {
            // Find rightmost element that has not been paired
            int rightmostele = -1;
            int indexofrightmostele = -1;
            for (int i = len * 2 - 1; i >= 0; i--) {
                if (notused.contains(arr[i])) {
                    notused.remove(Integer.valueOf(arr[i])); // Fix removal of Integer value
                    rightmostele = arr[i];
                    indexofrightmostele = i;
                    break;
                }
            }
            // Find leftmost occurrence
            int indexofleftmostele = -1;
            for (int i = 0; i < len * 2; i++) {
                if (arr[i] == rightmostele) {
                    indexofleftmostele = i;
                    break;
                }
            }
            // Swap until they are adjacent
            while (indexofleftmostele + 1 <= indexofrightmostele && arr[indexofleftmostele] != arr[indexofleftmostele + 1]) {
                swap(arr, indexofleftmostele, indexofleftmostele + 1);
                indexofleftmostele++;
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

