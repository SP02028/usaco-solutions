import java.util.*;
import java.io.*;
public class ME {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        char[] dir = br.readLine().toCharArray();
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        for (int milk : arr) {
            sum += milk;
        }
        for (int i = 0; i < N; i++) {
            // Check for RtL
            if (dir[i] == 'R' && dir[(i + 1) % N] == 'L') {
                // Start from the cow before curr R
                int j = (i - 1 + N) % N;
                long total = 0; 
                // follow chain backwards while the dir = R
                while (dir[j] == 'R') {
                    total += arr[j]; // add milk from cows to total accumulated
                    j = (j - 1 + N) % N;
                }
                // Subtract the minimum of the accumulated milk and M from the total milk
                sum -= Math.min(total, M);
               /// pw.println(total);
               // pw.println(M);
            }
            // Check for LtR
            if (dir[i] == 'L' && dir[(i - 1 + N) % N] == 'R') {
                // Start from the cow after curr L
                int j = (i + 1) % N;
                long total = 0;
                // follow chain forwards while the dir = L
                while (dir[j] == 'L') {
                    total += arr[j]; // add milk from cows to total accumulated
                    j = (j + 1) % N; 
                }
                // Subtract the minimum of the accumulated milk and M from the total milk
                sum -= Math.min(total, M);
              //  pw.println(total);
               // pw.println(M);
            }
        }
        pw.println(sum);
        pw.close();
    }
}
