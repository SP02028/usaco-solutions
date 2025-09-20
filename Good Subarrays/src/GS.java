import java.util.*;
import java.io.*;
public class GS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		while(t-->0) {
			br.readLine();
			String str = br.readLine();
			int[] arr = new int[str.length()+1];
			for(int i = 0 ;i <str.length();i++) {
				int temp = str.charAt(i)-'0';
				arr[i+1] = temp;
			}
			int[] prefixsums = new int[str.length()+1];
			for(int i =1;i <str.length()+1;i++) {
				prefixsums[i] = prefixsums[i-1]+arr[i] ;
				}
			Map<Long,Long> m = new HashMap<Long, Long>();
			for(int i = 0; i <prefixsums.length;i++) {
				long diff = prefixsums[i]-i;
				if(m.containsKey(diff)) {
					long n = m.get(diff);
					m.replace(diff, n+1);
				}
				else {
					m.put(diff,(long) 1);
				}
			}
			long sum = 0;
			for(Long ele: m.values()) {
				sum += (ele)*(ele-1)/2;
			}
			pw.println(sum);
		}
		pw.close();
	}

}
