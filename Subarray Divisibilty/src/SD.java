import java.util.*;
import java.io.*;
public class SD {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		long prefixSum = 0;
		arr[0]=1;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i <N;i++) {
			int a = Integer.parseInt(st.nextToken());
			prefixSum +=a;
			arr[(int)((prefixSum%N)+N)%N]++;
		}
		long ans =0;
		for(long n:arr) {
			ans +=((n-1)*n)/2;
		}
		pw.println(ans);
		pw.close();
	}

}