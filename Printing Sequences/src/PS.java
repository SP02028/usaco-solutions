import java.util.*;
import java.io.*;
public class PS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];//1 index
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[][] results = new int[n + 1][n + 1];//store prev computed results
            for (int[] row : results) {
                Arrays.fill(row, -1); 
            }
            // Check if the entire array can be printed with k or fewer operations
            if (solve(arr, results, 1, n) <= k) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
    // Recursive function to compute the minimum number of print statements
    static int solve(int[] arr, int[][] results, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (results[i][j] != -1) {
            return results[i][j]; //the result has been computed
        }
        int minOperations = Integer.MAX_VALUE;
        // Check for periodicity
        for (int x = 1; x <= (j - i + 1) / 2; x++) {//for each len until half the subarray, see if the period can be x
            if ((j - i + 1) % x == 0) { //can the subarray be divided into sequence of length x?
                boolean isPeriodic = true;
                for (int k = i + x; k <= j; k++) {
                    if (arr[k] != arr[k - x]) { //if the period is x, is k-x not the same?
                        isPeriodic = false;//break if so
                        break;
                    }
                }
                if (isPeriodic) {//else it is periodic and the period is x
                    minOperations = Math.min(minOperations, solve(arr, results, i, i + x - 1)); //so now we can repeat it on the
                    //first segment of the subarray that made up the period
                }
            }
        }
        // Consider splitting
        for (int split = i; split < j; split++) {//all possible split points
            minOperations = Math.min(minOperations, solve(arr, results, i, split) + solve(arr, results, split + 1, j));
            //see if the minimum operations changes if we split the subarray
            /*If a subarray cannot be made periodic with any period length, 
             * splitting allows the algorithm to handle each part separately.
             *  This is crucial for subarrays that do not exhibit a simple repeating pattern.
             *  By splitting the subarray at different points, 
             *  the algorithm can recursively solve each part and combine the results. 
             *  This helps in finding the optimal way to print the entire subarray with the fewest operations.
	*/
        }
        results[i][j] = minOperations; // Store the result in the results table
        return minOperations;
    }
}