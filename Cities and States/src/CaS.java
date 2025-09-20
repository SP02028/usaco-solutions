import java.io.*;
import java.util.*;

public class CaS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter pw = new PrintWriter("citystate.out");
        int len = Integer.parseInt(br.readLine());       
        Map<String, Integer> count = new HashMap<>();
        long total = 0;       
        for (int i = 0; i < len; i++) {
            StringTokenizer cityState = new StringTokenizer(br.readLine());
            String city = cityState.nextToken().substring(0, 2);
            String state = cityState.nextToken();           
            if (!city.equals(state)) {
                total += count.getOrDefault(state + city, 0);
            }
            count.put(city + state, count.getOrDefault(city + state, 0) + 1);
        }     
        pw.println(total);
        pw.close();
    }
}