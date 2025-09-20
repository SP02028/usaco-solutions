import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            StringTokenizer s = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(s.nextToken());
            StringTokenizer t = new StringTokenizer(r.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                arr.add(Integer.parseInt(t.nextToken()));
            }

            int sum = 0;
            for (int ele : arr) {
                sum += ele;
            }
            if(sum ==0) {
            	pw.println(0);
            	break;
            }
            for (int j = 1; j <= sum; j++) { 
                if (sum % j != 0) {
                    continue; 
                }

                int cursum = 0;
                boolean valid = true;

                for (int h : arr) {
                    cursum += h;
                    if (cursum > j) {
                        valid = false;
                        break;
                    } else if (cursum == j) {
                        cursum = 0; 
                    }
                }

                if (valid) {
                    pw.println(N - (sum / j));
                    break; 
                }
            }
        }
        pw.close();
    }
}

