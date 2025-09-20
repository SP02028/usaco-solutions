import java.util.*;
import java.io.*;
public class RaS {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] arr = new int[len+1];
		int[] ans = new int[len+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1;i<=K;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[K+1] = len;
		for(int i = 1; i <=K;i++) {
			for(int j = arr[i]; j<arr[i+1]; j++) {
				int curr = j-arr[i];
				int after = curr-T; //move back t 
				int diff = arr[i+1]-arr[i];
				after = (after%diff+diff)%diff; //bunch of mods to get it back in the range of the subarray (0-diff-1) 
				ans[(arr[i]+after+T)%len] = j;//shift view by T
			}
		}
		for(int i =0; i <len; i++) {
			pw.print(ans[i]);
			if(i!=len-1) {
				pw.print(" ");
			}
		}
		pw.close();
	}

}
