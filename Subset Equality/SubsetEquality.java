/**
 * Problem: Subset Equality
 * 
 * This solution determines if two strings become equal after removing
 * all characters in a given subset. Uses two-pointer technique.
 * 
 * Approach:
 * - For each query with a set of characters to remove
 * - Use two pointers to traverse both strings simultaneously
 * - Skip characters that are in the removal set
 * - Check if non-skipped characters match at each position
 * - Answer "Y" if all remaining characters match, "N" otherwise
 * 
 * Time Complexity: O(Q * (|a| + |b|)) where Q is number of queries
 * Space Complexity: O(1) per query
 */
import java.io.*;
import java.util.*;

public class Subset {
    /**
     * Main method that processes subset equality queries.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String a = r.readLine();
        String b = r.readLine();
        int queries = Integer.parseInt(r.readLine());

        for (int i = 0; i < queries; i++) {
            String h = r.readLine();
            boolean[] letters = new boolean[18]; // Track which letters to remove

            // Mark all letters in removal set
            for (int j = 0; j < h.length(); j++)
                letters[h.charAt(j) - 'a'] = true;

            int pointer1 = 0;
            int pointer2 = 0;

            // Two-pointer approach: skip removable letters, match others
            while (pointer1 < a.length() && pointer2 < b.length()) {
                if (a.charAt(pointer1) == b.charAt(pointer2)) {
                    // Characters match, advance both
                    pointer1++;
                    pointer2++;
                } else if (!letters[a.charAt(pointer1) - 'a']) {
                    // Character in a is not removable but doesn't match
                    pointer1++;
                } else if (!letters[b.charAt(pointer2) - 'a']) {
                    // Character in b is not removable but doesn't match
                    pointer2++;
                } else {
                    // Both are removable but different - strings won't match
                    break;
                }
            }

            if (pointer1 == a.length() && pointer2 == b.length()) {
                pw.print("Y");
            } else {
                // Skip remaining removable characters
                while (pointer1 < a.length() && !letters[a.charAt(pointer1) - 'a'])
                    pointer1++;
                while (pointer2 < b.length() && !letters[b.charAt(pointer2) - 'a'])
                    pointer2++;

                if (pointer1 == a.length() && pointer2 == b.length())
                    pw.print("Y");
                else
                    pw.print("N");
            }
        }
        pw.close();
    }
}
