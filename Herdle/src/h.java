import java.util.*;
import java.io.*;

public class h {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        char[][] oggrid = new char[3][3];
        char[][] guess = new char[3][3];
        Map<Character, Integer> freq = new HashMap<>();
        
        // Use the map to store frequencies of letters
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            for (int j = 0; j < 3; j++) {
                oggrid[i][j] = line.charAt(j);
                freq.put(oggrid[i][j], freq.getOrDefault(oggrid[i][j], 0) + 1);
            }
        }       
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            for (int j = 0; j < 3; j++) {
                guess[i][j] = line.charAt(j);
            }
        }
        // Guess and og populated
        int green = 0;
        int yellow = 0;
        //greens
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (oggrid[i][j] == guess[i][j]) {
                    green++;
                    int val = freq.get(guess[i][j]) - 1;
                    freq.replace(guess[i][j], val);
                }
            }
        }
        //yellows
                for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (oggrid[i][j] != guess[i][j] && freq.containsKey(guess[i][j]) && freq.get(guess[i][j]) > 0) {
                    yellow++;
                    int val = freq.get(guess[i][j]) - 1;
                    freq.replace(guess[i][j], val);
                }
            }
        }       
        pw.println(green);
        pw.println(yellow);
        pw.close();
    }
}
