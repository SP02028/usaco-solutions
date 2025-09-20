import java.io.*;
import java.util.*;

public class mooing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        Map<String, Integer> frequencies = new HashMap<>();
        Set<String> valid = new HashSet<>();
        // Find the initial strings
        for (int i = 0; i < n - 2; i++) {
            if (s[i] != s[i + 1] && s[i + 1] == s[i + 2]) {
                String moo = new String(s, i, 3);
                frequencies.put(moo, frequencies.getOrDefault(moo, 0) + 1);
                if (frequencies.get(moo) >= f) {
                    valid.add(moo);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            // Undo updates
            for (int start = i - 2; start <= i; start++) {
                if (start < 0 || start + 2 >= n) {
                    continue;
                }
                if (s[start] != s[start + 1] && s[start + 1] == s[start + 2]) {
                    String moo = new String(s, start, 3);
                    frequencies.put(moo, frequencies.get(moo) - 1);
                }
            }

            char orig = s[i];
            // Try each new letter
            for (char letter = 'a'; letter <= 'z'; letter++) {
                s[i] = letter;
                for (int start = i - 2; start <= i; start++) {
                    if (start < 0 || start + 2 >= n) {
                        continue;
                    }
                    if (s[start] != s[start + 1] && s[start + 1] == s[start + 2]) {
                        String moo = new String(s, start, 3);
                        frequencies.put(moo, frequencies.getOrDefault(moo, 0) + 1);
                        if (frequencies.get(moo) >= f) {
                            valid.add(moo);
                        }
                    }
                }
                for (int start = i - 2; start <= i; start++) {
                    if (start < 0 || start + 2 >= n) {
                        continue;
                    }
                    if (s[start] != s[start + 1] && s[start + 1] == s[start + 2]) {
                        String moo = new String(s, start, 3);
                        frequencies.put(moo, frequencies.get(moo) - 1);
                    }
                }
            }
            s[i] = orig;
            // Redo updates
            for (int start = i - 2; start <= i; start++) {
                if (start < 0 || start + 2 >= n) {
                    continue;
                }
                if (s[start] != s[start + 1] && s[start + 1] == s[start + 2]) {
                    String moo = new String(s, start, 3);
                    frequencies.put(moo, frequencies.getOrDefault(moo, 0) + 1);
                }
            }
        }
        pw.println(valid.size());
        List<String> validList = new ArrayList<>(valid);
        Collections.sort(validList);
        for (String moo : validList) {
            pw.println(moo);
        }
        pw.close();
    }
}
