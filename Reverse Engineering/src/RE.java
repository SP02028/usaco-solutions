import java.util.*;
import java.io.*;

public class RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(nextNonEmptyLine(br));
            int lenstr = Integer.parseInt(st.nextToken());
            int nument = Integer.parseInt(st.nextToken());
            int[][] input = new int[nument][lenstr];
            int[] output = new int[nument];
            ArrayList<Integer> remainingpos = new ArrayList<>();
            for (int i = 0; i < nument; i++) {
                st = new StringTokenizer(nextNonEmptyLine(br));
                String entry = st.nextToken();
                for (int j = 0; j < lenstr; j++) {
                    input[i][j] = entry.charAt(j) - '0';
                }
                output[i] = Integer.parseInt(st.nextToken()); 
                remainingpos.add(i);
            }
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i = 0; i < lenstr; i++) {
                    Set<Integer> oneout = new HashSet<>();
                    Set<Integer> zeroout = new HashSet<>();
                    ArrayList<Integer> poswzero = new ArrayList<>();
                    ArrayList<Integer> poswone = new ArrayList<>();
                    for (int e : remainingpos) {
                        if (input[e][i] == 0) {
                            zeroout.add(output[e]);
                            poswzero.add(e);
                        } else {
                            oneout.add(output[e]);
                            poswone.add(e);
                        }
                    }
                    if (zeroout.size() == 1) {
                        remainingpos.removeAll(poswzero);
                        changed = true;
                    }
                    if (oneout.size() == 1) {
                        remainingpos.removeAll(poswone);
                        changed = true;
                    }
                }
            }
            if (remainingpos.isEmpty()) {
                pw.println("OK");
            } else {
                pw.println("LIE");
            }
        }
        pw.close();
    }
    private static String nextNonEmptyLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && line.isEmpty());
        return line;
    }
}

