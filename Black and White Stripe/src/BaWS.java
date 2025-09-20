import java.util.*;
import java.io.*;
public class BaWS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			int[] arr = new int[n+1];
			for(int i = 1; i <=n;i++) {
				if(str.charAt(i-1)=='W') {
					arr[i] = arr[i-1]+1;
				}
				else {
					arr[i] = arr[i-1];
				}
					
			}
			int ans = Integer.MAX_VALUE;
			for(int i = k;i<=n;i++) {
				ans = Math.min(ans, arr[i]-arr[i-k]);
			}
			pw.println(ans);
			}
		pw.close();
	}

}
