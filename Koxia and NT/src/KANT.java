import java.util.*;
import java.io.*;
public class KANT {
    public static void main(String[] args) throws IOException {
    	//You didn't even notice the fact that in order for the gcd to be one, no two numbers could be divisible by the same prime
    	//this is the key observation, nevermind simulating adding and brute forcing, this is much more efficient
    	//and much easier to implement.
    	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	        PrintWriter pw = new PrintWriter(System.out);
    	        StringTokenizer st;
    	        int T = Integer.parseInt(br.readLine());
    	        for (int t = 0; t < T; t++) {
    	            int n = Integer.parseInt(br.readLine());
    	            long[] arr = new long[n + 1];
    	            st = new StringTokenizer(br.readLine());
    	            for (int i = 1; i <= n; i++) {
    	                arr[i] = Long.parseLong(st.nextToken());
    	            }
    	            boolean distinct = true;
    	            Arrays.sort(arr, 1, n + 1);
    	            for (int i = 1; i < n; i++) {
    	                if (arr[i] == arr[i + 1]) {
    	                    distinct = false;
    	                    break;
    	                }
    	            }
    	            if (distinct == false) {
    	                pw.println("NO");
    	                continue;
    	            }
    	            boolean primesdistinct = true;
    	            for (int mod = 2; mod <= n / 2; mod++) {
    	                int[] primefreq = new int[mod];
    	                for (int i = 1; i <= n; i++) {
    	                    primefreq[(int) (arr[i] % mod)]++;
    	                }
    	                int min = primefreq[0];
    	                for (int j = 1; j < mod; j++) {
    	                    if (primefreq[j] < min) {
    	                        min = primefreq[j];
    	                    }
    	                }
    	                if (min >= 2) {
    	                    primesdistinct = false;
    	                    break;
    	                }
    	            }
    	            if (primesdistinct == true) {
    	                pw.println("YES");
    	            } else {
    	                pw.println("NO");
    	            }
    	        }
    	        pw.close();
    	    }
    	}
