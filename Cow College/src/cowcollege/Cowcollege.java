package cowcollege;

import java.util.*;
import java.io.*;

public class Cowcollege {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        long x = Long.parseLong(r.readLine());
        List<Long> arr = new ArrayList<Long>();
        StringTokenizer st = new StringTokenizer(r.readLine());
	    int n = Integer.parseInt(st.nextToken());
        StringTokenizer t = new StringTokenizer(r.readLine());
        for (long i = 0; i < n; i++) {
                long num = Long.parseLong(t.nextToken());
                arr.add(num);
            
        }
        Collections.sort(arr);
        Map<Long, Long> m = new HashMap<Long, Long>();
        for(long ele : arr) {
            m.put(ele, ele * (arr.size() - arr.indexOf(ele)));
        }       
        long max = 0;
        long keyWithMaxValue = 0;       
        for(Long key : m.keySet()) {
            if(m.get(key) > max) {
                max = m.get(key);
                keyWithMaxValue = key;
            } else if(m.get(key) == max && key < keyWithMaxValue) {
                keyWithMaxValue = key;
            }
        }       
        System.out.println(max + " " + keyWithMaxValue);
    }
}
