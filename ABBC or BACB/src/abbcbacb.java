import java.util.*;
import java.io.*;

public class abbcbacb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            String str = br.readLine();
            int coins = 0;

            char[] strarr = str.toCharArray();
            if (strarr[0] == strarr[strarr.length - 1] && strarr[0] == 'A') {
                if (str.contains("BB")) {
                    for (char c : strarr) {
                        if (c == 'A') {
                            coins++;
                        }
                    }
                } else {
                    ArrayList<Integer> arr = new ArrayList<>();
                    int count = 0;

                    for (char c : strarr) {
                        if (c == 'A') {
                            count++;
                        } else {
                            if (count > 0) {
                                arr.add(count);
                            }
                            count = 0;
                        }
                    }
                    if (count > 0) {
                        arr.add(count);
                    }
                    Collections.sort(arr);
                    
                    for (int j = 1; j < arr.size(); j++) {
                        coins += arr.get(j);
                    }
                }
            } else {
                for (char c : strarr) {
                    if (c == 'A') {
                        coins++;
                    }
                }
            }
            pw.println(coins);
        }
        pw.close();
    }
}



