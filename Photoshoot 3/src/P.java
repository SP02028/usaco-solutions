import java.util.*;
import java.io.*;

public class P {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] b = new int[len - 1];
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            sum += b[i];
        }
        int leastworkinga = 1;
        for (int i = 1; i <= len; i++) {
            Set<Integer> m = new HashSet<>();
            m.add(i);
            int[] arr = new int[len];
            arr[0] = i;
            boolean allsatisfy = true;
            int x = 1;
            for (int n : b) {
                int nextNum = n - arr[x - 1];
                if (nextNum <= 0 || nextNum > len || m.contains(nextNum)) { 
                    allsatisfy = false;
                    break;
                }
                m.add(nextNum);
                arr[x] = nextNum;
                x++;
            }
            if (allsatisfy && m.size() == len) { 
                leastworkinga = i;
                break;
            }
        }
        int[] a = new int[len];
        a[0] = leastworkinga;
        for (int i = 1; i < len; i++) {
            a[i] = b[i - 1] - a[i - 1];
        }

        int x = 0;
        for (int num : a) {
            if (x > 0) {
                pw.print(" ");
            }
            pw.print(num);
            x++;
        }
        pw.close();
    }
}

