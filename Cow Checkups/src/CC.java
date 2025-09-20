import java.util.*;
import java.io.*;

public class CC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Read the length of the sequences
        int len = Integer.parseInt(br.readLine());

        // Arrays to store the sequences and prefix/suffix counts
        int[] seq1 = new int[len + 1];  // First sequence (1-based indexing)
        int[] seq2 = new int[len + 1];  // Second sequence (1-based indexing)
        int[] goodprefix = new int[len + 2]; // Good prefix counts (1-based indexing)
        int[] goodsuffix = new int[len + 2]; // Good suffix counts (1-based indexing)
        int[] frq = new int[len + 2];  // Frequency of total good pairs (0-based indexing)
        int[][] count = new int[len + 2][len + 2]; // Stores counts of good pairs

        // Step 1: Read the first sequence and store it in seq1
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            seq1[i] = Integer.parseInt(st.nextToken());
        }

        // Step 2: Read the second sequence and store it in seq2, while initializing goodprefix and goodsuffix
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            seq2[i] = Integer.parseInt(st.nextToken());

            // Initialize goodprefix and goodsuffix based on matching elements
            if (seq1[i] == seq2[i]) {
                goodprefix[i]++;
                goodsuffix[i]++;
            }
        }

        // Step 3: Compute cumulative goodprefix counts (number of matches from the start up to index i)
        for (int i = 1; i <= len; i++) {
            goodprefix[i] += goodprefix[i - 1];
        }

        // Step 4: Compute cumulative goodsuffix counts (number of matches from the end up to index i)
        for (int i = len; i >= 1; i--) {
            goodsuffix[i] += goodsuffix[i + 1];
        }

        // Step 5: Calculate counts of good pairs for each subarray (i, j)
        // This part counts how many times seq1[i] matches seq2[j] and seq1[j] matches seq2[i]
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (i != j) {
                    if (seq1[i] == seq2[j]) {
                        count[i][j]++;
                    }
                    if (seq1[j] == seq2[i]) {
                        count[i][j]++;
                    }
                } else {
                    if (seq1[i] == seq2[i]) {
                        count[i][j]++;
                    }
                }
            }
        }

        // Step 6: Accumulate counts for subarrays of different lengths (optimization step)
        // This step propagates the counts across subarray lengths
        for (int length = 1; length <= len; length++) {
            for (int L = 1; L + length - 1 <= len; L++) {
                count[L - 1][L + length] += count[L][L + length - 1];
            }
        }

        // Step 7: Calculate total good pairs for each subarray (i, j) and update frequency array
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                // Calculate total good pairs by considering the matching pairs in subarray (i, j)
                // Also include goodprefix (matches before i) and goodsuffix (matches after j)
                int total_good = count[i][j] + goodprefix[i - 1] + goodsuffix[j + 1];
                frq[total_good]++;
            }
        }

        // Step 8: Output the frequency of total good pairs
        for (int i = 0; i <= len; i++) {
            out.println(frq[i]);
        }

        out.close();
    }
}
