import java.util.*;
import java.io.*;

public class INotDS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            long sum = 0;
            long k = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                sum += arr[i];
            }
            
            // First check if sum is greater than k
            if (sum <= k) {
                // If sum < k return 0
                pw.println(n);
                continue;
            } else {
                // If everything is not removed then half of the moves affect a prefix, other half affects a suffix
                // For one half, keep vals starting from beginning zero until you can't do so anymore
                // Repeat from second half
                long firsthalfk = k / 2;
                long secondhalfk = k / 2;
                if (k % 2 == 1) {
                    firsthalfk = k / 2 + 1;
                }
                //  pw.println(firsthalfk);
                //  pw.println(secondhalfk);
                int firstpos = 0;
                int lastpos = n - 1;
                while (firsthalfk > 0) {
                    if (arr[firstpos] < firsthalfk) {
                        firsthalfk -= arr[firstpos];
                        arr[firstpos] = 0;
                        firstpos++;
                    } else {
                        arr[firstpos] -= firsthalfk;
                        firsthalfk = 0;
                    }
                    /*  for(int a: arr) {
                        pw.print(a + " ");
                    }
                    pw.println();*/
                }
                while (secondhalfk > 0) {
                    if (arr[lastpos] < secondhalfk) {
                        secondhalfk -= arr[lastpos];
                        arr[lastpos] = 0;
                        lastpos--;
                    } else {
                        arr[lastpos] -= secondhalfk;
                        secondhalfk = 0;
                    }
                    /*  for(int a: arr) {
                        pw.print(a + " ");
                    }
                    pw.println();*/
                }
                int count = 0;
                for (long a : arr) {
                    if (!(a > 0)) {
                        count++;
                    }
                }
                pw.println(count);
            }
        }
        pw.close();
    }
}

