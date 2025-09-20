import java.io.*;
import java.util.*;

public class madeUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        StringTokenizer t = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(t.nextToken()));
        }

        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(s.nextToken()));
        }

        StringTokenizer r = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C.add(Integer.parseInt(r.nextToken()));
        }
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int n =0;
        for (int ele : A) {     	
            HashSet<Integer> temp = new HashSet<>();
            if (B.contains(ele)) {
                ArrayList<Integer> vindex = new ArrayList<>();
                for (int i = 0; i < B.size(); i++) {
                    if (B.get(i) == ele) {
                        vindex.add(i + 1);
                    }
                }
                for (int index : vindex) {
                    for (int ele3 : C) {
                        if (ele3 == index) {
                            temp.add(ele3);
                        }
                    }
                }
            }
            map.put(n, temp);
            n++;
        }
        int count = 0;
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            count += entry.getValue().size();
        }
        pw.println(count); 
        pw.close();
    }
}

