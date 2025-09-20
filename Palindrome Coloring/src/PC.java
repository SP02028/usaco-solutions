import java.util.*;
import java.io.*;
public class PC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw  = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int i= 0; i <tc;i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			/*
			 * 8 2
			bxyaxzay
			 */
			int len = Integer.parseInt(s.nextToken());
			int colors = Integer.parseInt(s.nextToken());
			Map<Character,Integer> pairs = new HashMap<>();
			StringTokenizer t = new StringTokenizer(br.readLine());
			char[] line = t.nextToken().toCharArray();
			for(char c:line) {
				if(pairs.containsKey(c)) {
					int prevval = pairs.get(c);
					pairs.put(c, prevval+1);
				}
				else {
					pairs.put(c, 1);
				}
			}
			//input done
			//take floor of all values divided by 2
		Collection<Integer> num = pairs.values();
		int remainder = 0;
		int total = 0;
		for(int n:num) {
			remainder += n%2;
			n = n/2;
			total+=n;
		}
		int distribute = 2*(total/colors);
		int remtotals = total%colors;
		if(remtotals*2+remainder >= colors) {
			distribute++;
		}
		pw.println(distribute);
		}
		pw.close();

	}

}
