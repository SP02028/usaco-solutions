import java.util.*;
import java.io.*;

public class SSS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter("div7.out");
    	//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	//PrintWriter pw =new PrintWriter(System.out);
        int len = Integer.parseInt(br.readLine());
        long[] arr = new long[len + 1];

        for (int i = 1; i <= len; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        long[] prefixes = prefixSum(arr);
        int maxlen = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            long val = prefixes[i] % 7;
            if (!map.containsKey(val)) {
                map.put(val, i);
            } else {
                maxlen = Math.max(maxlen, i - map.get(val));
            }
        }
        pw.println(maxlen);
        pw.close();
    }
    public static long[] prefixSum(long[] arr) {
        int n = arr.length;
        long[] pref = new long[n];
        if (n > 0) {
            pref[0] = arr[0];
            for (int i = 1; i < n; i++) {
                pref[i] = pref[i - 1] + arr[i];
            }
        }
        return pref;
    }
}

