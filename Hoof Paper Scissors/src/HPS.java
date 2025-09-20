import java.io.*;
import java.util.*;

public class HPS {
    public static void main(String[] args) throws IOException {
      //  BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        List<int[]> vp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            vp.add(new int[]{first, second});
        }

        int maxscore = 0;
        int[] bt = {0, 1, 2};
        int[] poz = new int[3];

        do {
            for (int i = 0; i < 3; i++)
                poz[bt[i]] = i;
            int score = 0;
            for (int i = 0; i < n; i++) {
                if ((poz[vp.get(i)[0]] + 1) % 3 == poz[vp.get(i)[1]]) {
                    score++;
                }
            }
            maxscore = Math.max(maxscore, score);
        } while (nextPermutation(bt));

        pw.println(maxscore);
        pw.close();
    }

    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}

