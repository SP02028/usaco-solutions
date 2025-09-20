import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i =1;i<n+1;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long ans = Long.MIN_VALUE;
			 int l = Math.max(1, n - 2 * k);
			    for (int i = l; i <= n; i++) {
			      for (int j = i + 1; j <= n; j++) {
			        ans = Math.max(ans, (long) i * j - (long) k * (arr[i] | arr[j]));
			      }
			    }
			    pw.println(ans);
		}
		pw.close();
	}
}
