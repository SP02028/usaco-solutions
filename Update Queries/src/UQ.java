import java.util.*;
import java.io.*;
//love 1am coding
public class UQ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine()); 
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
            char[] s = br.readLine().toCharArray();
            int[] ind = new int[M]; 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                ind[i] = Integer.parseInt(st.nextToken()) - 1; 
            }            
            char[] c = br.readLine().toCharArray(); 
            Arrays.sort(c); 
            Set<Integer> uniqueIndices = new HashSet<>();
            List<Integer> sortedIndices = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (!uniqueIndices.contains(ind[i])) {
                    uniqueIndices.add(ind[i]);
                    sortedIndices.add(ind[i]);
                }
            }
         Collections.sort(sortedIndices);
            for (int i = 0; i < sortedIndices.size(); i++) {
                s[sortedIndices.get(i)] = c[i];
            }
            pw.println(new String(s));
        }
        pw.close();
    }
}

