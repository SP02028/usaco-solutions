import java.io.*;
import java.util.*;

public class HighCardWins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter("highcard.out");
        int n = Integer.parseInt(br.readLine().trim());
        
        List<Integer> Bessie = new ArrayList<>();
        for (int i = 1; i <= 2 * n; i++) {
            Bessie.add(i);
        }
        
        List<Integer> Elsie = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int temp = Integer.parseInt(br.readLine().trim());
            Elsie.add(temp);
            Bessie.remove(Integer.valueOf(temp));
        }
        
        Collections.sort(Elsie);
        Collections.sort(Bessie);
        
        int count = 0;
        int bIndex = 0;
        
        for (int eIndex = 0; eIndex < n; eIndex++) {
            while (bIndex < n && Bessie.get(bIndex) <= Elsie.get(eIndex)) {
                bIndex++;
            }
            if (bIndex < n) {
                count++;
                bIndex++;
            }
        }
        
        pw.println(count);
        pw.close();
    }
}