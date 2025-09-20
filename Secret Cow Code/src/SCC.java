import java.io.*;
import java.util.*;

public class SCC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken(); 
        long index = Long.parseLong(st.nextToken());
        pw.println(findcharat(str, index - 1));
        pw.close(); // Close the file to save the result
    }
    // Recursive function to find the character at a specific index
    public static char findcharat(String str, long index) {
        // Base case: if the index is within the original string, return the character directly
        if (index < str.length()) {
            return str.charAt((int) index); 
        }        
        // Calculate the length of F_k(s) to find the "parent" string that contains the index
        long length = str.length(); // Start with the length of the original string
        while (2 * length <= index) { // Double the length until it surpasses the target index
            length *= 2;
        }      
        // Special case: if the index is the first character of the second half
        if (length == index) {
            return findcharat(str, length - 1); // Map to the last character of the previous string
        }     
        // General case: adjust the index to map it back to the previous string
        return findcharat(str, index - length - 1);
    }
}

