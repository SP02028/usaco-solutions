import java.util.*;
import java.io.*;

public class acd {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter pw = new PrintWriter(System.out);

	        int N = Integer.parseInt(br.readLine());
	        ArrayList<Integer> d = new ArrayList<>();

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int[] finalval = new int[N];
	        for (int i = 0; i < N; i++) {
	            finalval[i] = Integer.parseInt(st.nextToken());
	        }

	        st = new StringTokenizer(br.readLine());
	        int[] intialval = new int[N];
	        for (int i = 0; i < N; i++) {
	            intialval[i] = Integer.parseInt(st.nextToken());
	            d.add(finalval[i] - intialval[i]);
	        }

	        int count = 0;

	        while (!d.isEmpty()) {
	            if (d.get(d.size() - 1) == 0) {
	                d.remove(d.size() - 1);
	                continue;
	            }

	            boolean positive = d.get(d.size() - 1) > 0;
	            int amtChange = 1;

	            while (amtChange < d.size()) {
	                if (d.get(d.size() - 1 - amtChange) == 0) break;
	                if ((d.get(d.size() - 1 - amtChange) > 0) != positive) break;
	                amtChange++;
	            }

	            count++;
	            for (int i = 0; i < amtChange; i++) {
	                if (d.get(d.size() - 1 - i) > 0) {
	                    d.set(d.size() - 1 - i, d.get(d.size() - 1 - i) - 1);
	                } else {
	                    d.set(d.size() - 1 - i, d.get(d.size() - 1 - i) + 1);
	                }
	            }
	        }

	        pw.println(count);
	        pw.close();
	    }
}

