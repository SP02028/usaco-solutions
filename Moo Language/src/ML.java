import java.io.*;
import java.util.*;

public class ML {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        for (int q = 0; q < T; q++) {
            st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            List<String> nouns = new ArrayList<>();
            List<String> iverbs = new ArrayList<>();
            List<String> tverbs = new ArrayList<>();
            List<String> conjs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(r.readLine());
                String word = st.nextToken();
                char type = st.nextToken().charAt(0);

                if (type == 'n') {
                    nouns.add(word);
                } else if (type == 'i') {
                    iverbs.add(word);
                } else if (type == 't') {
                    tverbs.add(word);
                } else {
                    conjs.add(word);
                }
            }

            int ms = p + Math.min(p, conjs.size());
            String[] arr = new String[ms];

            int cur = 0;
            boolean type2 = false;

            if (nouns.size() >= ms * 2) {
                while (!tverbs.isEmpty() && cur < ms) {
                    type2 = true;
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + tverbs.remove(tverbs.size() - 1) + " " + nouns.remove(nouns.size() - 1);
                    cur++;
                }

                while (!iverbs.isEmpty() && cur < ms) {
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + iverbs.remove(iverbs.size() - 1);
                    cur++;
                }

                if (type2) {
                    while (!nouns.isEmpty() && c > 0) {
                        arr[0] += ", " + nouns.remove(nouns.size() - 1);
                        c--;
                    }
                }
            } else if (nouns.size() <= ms) {
                if (!tverbs.isEmpty() && nouns.size() == iverbs.size() + 1 && nouns.size() >= 2) {
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + tverbs.remove(tverbs.size() - 1) + " " + nouns.remove(nouns.size() - 1);
                    cur++;
                }

                while (!nouns.isEmpty() && !iverbs.isEmpty() && cur < ms) {
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + iverbs.remove(iverbs.size() - 1);
                    cur++;
                }

                while (!tverbs.isEmpty() && nouns.size() >= 2 && cur < ms) {
                    type2 = true;
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + tverbs.remove(tverbs.size() - 1) + " " + nouns.remove(nouns.size() - 1);
                    cur++;
                }

                if (type2) {
                    while (!nouns.isEmpty() && c > 0) {
                        arr[cur - 1] += ", " + nouns.remove(nouns.size() - 1);
                        c--;
                    }
                }
            } else {
                if (!tverbs.isEmpty() && nouns.size() > 1) {
                    type2 = true;
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + tverbs.remove(tverbs.size() - 1) + " " + nouns.remove(nouns.size() - 1);
                    cur++;
                }

                while (!tverbs.isEmpty() && nouns.size() - 2 >= Math.min(iverbs.size(), ms - cur) && cur < ms) {
                    type2 = true;
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + tverbs.remove(tverbs.size() - 1) + " " + nouns.remove(nouns.size() - 1);
                    cur++;
                }

                while (!iverbs.isEmpty() && !nouns.isEmpty() && cur < ms) {
                    arr[cur] = nouns.remove(nouns.size() - 1) + " " + iverbs.remove(iverbs.size() - 1);
                    cur++;
                }

                if (type2) {
                    while (!nouns.isEmpty() && c > 0) {
                        arr[0] += ", " + nouns.remove(nouns.size() - 1);
                        c--;
                    }
                }
            }

            String result = "";
            for (int a = 0; a < cur; ) {
                if (a + 1 < cur && !conjs.isEmpty() && arr[a] != null && arr[a + 1] != null) {
                    result += arr[a] + " " + conjs.remove(conjs.size() - 1) + " " + arr[a + 1] + ". ";
                    a += 2;
                } else {
                    result += arr[a] + ". ";
                    a++;
                }
            }

            pw.println(n - nouns.size() - iverbs.size() - tverbs.size() - conjs.size());
            pw.println(result.trim());
        }

        pw.close();
    }
}
