import java.util.*;
import java.io.*;
public class PA {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int len = Integer.parseInt(br.readLine());
			long[] arr = new long[len];
			long prevmax = Long.MIN_VALUE;
			int maxpow2 = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0;i<len;i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			if(len==1) {
				pw.println(0);
				continue;
			}
			boolean issorted = true;
			long diff = 0;
			for(int i =0 ; i <len;i++) {	
				prevmax = Math.max(prevmax, arr[i]);
				if(i>0) {
					if(arr[i]<arr[i-1]) {
						issorted = false;
						 diff =Math.max(diff, Math.abs( prevmax-arr[i]));						
					
				}
				}
			}
			//find min power 2 greater than or equal to diff
			int pow = 0;
			int currval =0 ;
			if(issorted) {
				pw.println(0);
				continue;
			}
			while(currval<diff) {
				currval += Math.pow(2, pow);
				pow++;
			}
						
			
				pw.println(pow);
			
		}
		pw.close();
	}

}
