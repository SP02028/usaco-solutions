import java.io.*;
import java.util.*;

public class feb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int min = 0;
        int max = 0;        
        int curr = 0;
        while (curr < len) {
            // Skip over 'F' characters to find the first non-'F' character
            while (curr < len && str.charAt(curr) == 'F') {
                curr++;
            }
            if(curr==len) {
            	break;
            }
            int next = curr + 1;
            // Skip over 'F' characters to find the next non-'F' character
            while (next < len && str.charAt(next) == 'F') {
                next++;
            }
            if (next == len) {
                // If we've reached the end of the string, break out of the loop
                break;
            }          
            int numF = next - curr - 1; // Number of 'F's between curr and next           
            if (str.charAt(next) == str.charAt(curr)) {
                // Case 1: Characters at curr and next are the same (e.g., BFFFFFB)
                int length = numF + 2;           
                // Calculate min: If length is even, we can have one mismatch
                if (length % 2 == 0) {
                    min += 1;
                } else {
                    min += 0;
                }    
                // Calculate max: All but one can be the same
                max += length - 1;
            } else {
                // Case 2: Characters at curr and next are different (e.g., BFFFFFE)
                int length = numF + 2;
                // Calculate min: If length is odd, we can have one mismatch
                if (length % 2 == 0) {
                    min += 0;
                } else {
                    min += 1;
                }
                // Calculate max: All but two can be the same
                max += length - 2;
            }
            curr = next; // Move curr to the next non-F character
        }
        // Count Fs at the beginning and end of the string
        int numbegF = 0;
        while (numbegF < len && str.charAt(numbegF) == 'F') {
            numbegF++;
        }  
        int numendF = 0;
        while (numendF < len && str.charAt(len - 1 - numendF) == 'F') {
            numendF++;
        }
        if (numbegF == len) {
            // If the entire string is F's, set min and max accordingly
            min = 0;
            max = len - 1;
        } else {
            // Adjust max for F's at the beginning and end
            max += numbegF;
            max += numendF;
        }
        List<Integer> excitements = new ArrayList<>();
        if (numbegF == 0 && numendF == 0) {
            // If no F's at the start or end, increment by 2
            assert ((max - min) % 2 == 0);
            for (int i = min; i <= max; i += 2) {
                excitements.add(i);
            }
        } else {
            // Otherwise, increment by 1
            for (int i = min; i <= max; i++) {
                excitements.add(i);
            }
        } 
        pw.println(excitements.size());
        for (int i : excitements) {
            pw.println(i);
        }
        
        pw.close();
    } 
}

