import java.io.*;
import java.util.*;
public class AE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long N = Long.parseLong(br.readLine());
        long[][] artworks = new long[(int) N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            artworks[i][0] = Long.parseLong(st.nextToken()); 
            artworks[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(artworks, Comparator.comparingLong(a -> a[0]));
        long max = Long.MIN_VALUE;
        int l = 0;
       long total = 0;
        for (int r = 0; r < N; r++) {
            total += artworks[r][1]; 
            while (l <= r && total < (artworks[r][0] - artworks[l][0])) {
                total -= artworks[l][1]; //update window
                l++;
            }
            max = Math.max(max, total - (artworks[r][0] - artworks[l][0]));//find the new max of the window
        }
        pw.println(max);
        pw.close();
    }
}
