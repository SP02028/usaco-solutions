import java.util.*;
import java.io.*;
public class MS {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		long len = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[(int)len];
		for(int i = 0; i < len;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long currSum =0;
		long maxsum = arr[0];
		for(long a:arr) {
			currSum=Math.max(a, currSum+a);
			maxsum = Math.max(currSum, maxsum);
		}
		pw.println(maxsum);
		pw.close();
	}

}
