import java.util.*;
import java.io.*;
public class MM2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] freqarr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			freqarr[arr[i]]++;
		}
		int missinglessthanmex = 0;
		for(int i=0; i <=N;i++) {
			pw.println(Math.max(freqarr[i], missinglessthanmex));
			if(freqarr[i]==0) {
				missinglessthanmex++;
			}
		}
		pw.close();
	}

}
