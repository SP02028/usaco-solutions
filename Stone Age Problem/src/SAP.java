import java.io.*;
import java.util.*;

public class SAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long sum = 0;
        int gIdx = -1;
        int gVal = 0;
        int[] idx = new int[n];
        int[] val = new int[n];
        Arrays.fill(idx, -1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
            sum += val[i];
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                int newVal = Integer.parseInt(st.nextToken());
                int curVal;
                if (idx[pos] < gIdx) {
                    curVal = gVal;
                } else {
                    curVal = val[pos];
                }
               sum -= curVal;
                sum += newVal;
             val[pos] = newVal;
                idx[pos] = i;
            } else if (type == 2) {
                int newGVal = Integer.parseInt(st.nextToken());
                gIdx = i;
                gVal = newGVal;
                sum = (long) n * newGVal;
            }
            pw.println(sum);
        }
        pw.close();
    }
}
