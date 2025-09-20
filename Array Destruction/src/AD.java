import java.io.*;
import java.util.*;
public class AD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());      
        for(int tc = 0;tc<t;tc++){
            int n = Integer.parseInt(br.readLine());
            n = n*2;
            ArrayList<Integer> a = new ArrayList<>();
            TreeMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());          
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                a.add(val);
                m.put(val, m.getOrDefault(val, 0) + 1);
            }
            Collections.sort(a, Collections.reverseOrder());
            boolean notpossible = true;            
            for (int i = 1; i < n; i++) {
                TreeMap<Integer, Integer> b = new TreeMap<>(m);
                int x = a.get(0) + a.get(i);
                int x1 = x;
                int a1 = a.get(0), a2 = a.get(i);
                List<int[]> v = new ArrayList<>();
                boolean valid = true;               
                while (!b.isEmpty()) {
                    if (b.getOrDefault(a1, 0) > 0) {
                        b.put(a1, b.get(a1) - 1);
                        if (b.get(a1) == 0) {
                        	b.remove(a1);
                        }
                    } else {
                        valid = false;
                        break;
                    }
                    if (b.getOrDefault(a2, 0) > 0) {
                        b.put(a2, b.get(a2) - 1);
                        if (b.get(a2) == 0) {
                        	b.remove(a2);
                        }
                    } else {
                        valid = false;
                        break;
                    }            
                    int[] arr = {a1,a2};
                    v.add(arr);
                    x = Math.max(a1, a2);
                    if (b.isEmpty()) {
                    	break;
                    }
                    a1 = b.firstKey();
                    a2 = x - a1;
                }            
                if (valid) {
                    pw.println("YES");
                    pw.println(x1);
                    for (int[] pair : v) {
                        pw.println(pair[0] + " " + pair[1]);
                    }
                    notpossible = false;
                    break;
                }
            }            
            if (notpossible) {
                pw.println("NO");
            }
        }
        pw.close();
    }
}
