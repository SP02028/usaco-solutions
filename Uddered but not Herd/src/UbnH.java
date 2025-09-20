import java.util.*;
import java.io.*;

public class UbnH {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String alpha = br.readLine();
        String fjheard = br.readLine();
        int numheard = 1;
        char lastchar = fjheard.charAt(0);

        for (int i = 1; i < fjheard.length(); i++) {
            if (alpha.indexOf(fjheard.charAt(i)) > alpha.indexOf(lastchar)) {
                lastchar = fjheard.charAt(i);
            } else {          	
                numheard++;
                lastchar = fjheard.charAt(i);
            }
        }
        pw.println(numheard);
        pw.close();
    }
}
