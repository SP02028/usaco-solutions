import java.util.*;
import java.io.*;
public class WDTCCTRII {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		Arrays.fill(arr, 1);
		for(int i=0;i<B;i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a] = 0;
		}
		int[] prefixsum = new int[N+1];
		for(int i =1;i <N+1;i++) {
			prefixsum[i] = prefixsum[i-1]+arr[i] ;
		}
		int max = -1;
		for(int i = 1; i<=(N-K+1);i++) {
			int temp=prefixsum[i+K-1] - prefixsum[i-1];
		//	pw.println(max);
			max = Math.max(temp, max);
			//pw.println();
		}
		int a = K-max;
		pw.println(a);
		pw.close();
	}

}
