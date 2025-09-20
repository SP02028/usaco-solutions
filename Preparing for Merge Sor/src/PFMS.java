import java.util.*;
import java.io.*;

public class PFMS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int len = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());      
        List<List<Integer>> ans = new ArrayList<>();      
        for(int n = 0; n<len;n++){
        	int a = Integer.parseInt(st.nextToken());
            int l = 0; 
            int r = ans.size();
            while (l != r) {
                int mid = (l + r) / 2;
                if (ans.get(mid).get(ans.get(mid).size() - 1) < a) r = mid;
                else l = mid + 1;
            }
            if (l == ans.size()) {
                List<Integer> newList = new ArrayList<>();
                newList.add(a);
                ans.add(newList);
            } else {
                ans.get(l).add(a);
            }
        }        
        for (List<Integer> i : ans) {
            for (int j : i) {
                pw.print(j + " ");
            }
            pw.println();
        }
        pw.close();
    }
}



