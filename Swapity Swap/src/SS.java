import java.util.*;
import java.io.*;

public class SS {

    public static void main(String[] args) throws IOException {
       // BufferedReader br = new BufferedReader(new FileReader("swap.in"));
      //  PrintWriter pw = new PrintWriter("swap.out");
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter pw =new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        // Store the original configuration
        int[] og = Arrays.copyOf(arr, N + 1);
        ArrayList<int[]> listofarr = new ArrayList<>();
        listofarr.add(Arrays.copyOf(arr, N + 1));
        boolean hasbreak = false;
        int count = 0;
        // Perform swaps until a cycle is detected
        while (true) {
            reverse(arr, A1, A2);
            reverse(arr, B1, B2);
            count++;
            // Check if the current configuration matches the original
            if (Arrays.equals(arr, og)) {
                hasbreak = true;
                break;
            } else {
                // Store the current configuration
                listofarr.add(Arrays.copyOf(arr, N + 1));
            }
        }
        // If a cycle is detected, use the cycle length to find the final configuration
        if (hasbreak) {
            arr = Arrays.copyOf(listofarr.get(K % count), N + 1);
        }
        for (int i = 1; i <= N; i++) {
            pw.println(arr[i]);
        }
        pw.close();
    }
    // Reverse the elements between pos1 and pos2 in the array
    public static void reverse(int[] arr, int pos1, int pos2) {
        while (pos1 < pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
            pos1++;
            pos2--;
        }
    }
}
