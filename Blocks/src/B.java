import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        String[] v = new String[4];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            v[i] = br.readLine();
        }

        while (n-- > 0) {
            String s = br.readLine();
            List<Integer> vv = Arrays.asList(0, 1, 2, 3);
            boolean okOverall = false;

            do {
                boolean ok = true;
                for (int j = 0; ok && j < s.length(); j++) {
                    ok = false;
                    for (char c : v[vv.get(j)].toCharArray()) {
                        if (c == s.charAt(j)) {
                            ok = true;
                            break;
                        }
                    }
                }
                okOverall |= ok;
            } while (nextPermutation(vv));

            out.println(okOverall ? "YES" : "NO");
        }
        out.close();
    }

    private static boolean nextPermutation(List<Integer> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i) >= list.get(i + 1)) i--;

        if (i < 0) return false;

        int j = list.size() - 1;
        while (list.get(j) <= list.get(i)) j--;

        Collections.swap(list, i, j);
        Collections.reverse(list.subList(i + 1, list.size()));

        return true;
    }
}

