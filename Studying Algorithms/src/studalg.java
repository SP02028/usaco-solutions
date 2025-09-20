import java.util.*;
import java.io.*;
public class studalg {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		StringTokenizer t= new StringTokenizer(r.readLine());
		for(int i =0; i<N;i++) {
			arr[i] = Integer.parseInt(t.nextToken());
		}
		Arrays.sort(arr);
		int count =0;
		for(int ele:arr) {
			if(X-ele >=0) {
				X-=ele;
				count++;
			}
			else {
				break;
			}
		}
		pw.println(count);
		pw.close();
	}

}
