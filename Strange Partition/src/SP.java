import java.util.*;
import java.io.*;
public class SP {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		for(int t =0;t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long len = Long.parseLong(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			long min = 0;
			long max = 0;
			long[] arr = new long[(int) len];
			for(int i = 0; i<len;i++) {
				arr[i] = Long.parseLong(st.nextToken());
				sum +=arr[i];
				max += arr[i]/x;
				if (arr[i] % x != 0) {
					max++;
				}
			}
			 min = (sum / x);
	            if (sum % x != 0) {
	            	min++;
	            }
	          pw.print(min + " ");
	          pw.print(max);
	          pw.println();
		}
		pw.close();
	}

}
