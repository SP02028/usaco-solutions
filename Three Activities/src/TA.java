import java.util.*;
import java.io.*;

public class TA {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < tc; i++) {
            int len = Integer.parseInt(br.readLine().trim());
            int[] skiing = new int[len];
            int[] movie = new int[len];
            int[] games = new int[len];
            
            StringTokenizer t = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                skiing[j] = Integer.parseInt(t.nextToken());
            }
            
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                movie[j] = Integer.parseInt(str.nextToken());
            }
            
            StringTokenizer string = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                games[j] = Integer.parseInt(string.nextToken());
            }
            
            int[] sk = top3(skiing);
            int[] m = top3(movie);
            int[] g = top3(games);
            
            int ans = 0;
            for (int k : sk) {
                for (int o : m) {
                    for (int a : g) {
                        if (k != o && o != a && a != k) {
                            ans = Math.max(ans, skiing[k] + movie[o] + games[a]);
                        }
                    }
                }
            }
            pw.println(ans);
        }
        pw.close();
    }

    public static int[] top3(int[] arr) {
        int max1 = -1;
        int max2 = -1;
        int max3 = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (max1 == -1 || arr[i] > arr[max1]) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (max2 == -1 || arr[i] > arr[max2]) {
                max3 = max2;
                max2 = i;
            } else if (max3 == -1 || arr[i] > arr[max3]) {
                max3 = i;
            }
        }
        return new int[] {max1, max2, max3};
    }
}
