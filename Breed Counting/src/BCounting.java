import java.util.*;
import java.io.*;
public class BCounting {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw= new PrintWriter("bcount.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		//keep the prefix sum for each cow in a seperate array
				int[] Hps = new int[N+1];
				int[] Gps = new int[N+1];
				int[] Jps = new int[N+1];
				//make all one indexed
		for(int i = 1; i <N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==1) {
				Hps[i] = 1;
				Gps[i] = 0;
				Jps[i] = 0;
			}
			else if(n==2) {
				Hps[i] = 0;
				Gps[i] = 1;
				Jps[i] = 0;
			}else {
				Hps[i] = 0;
				Gps[i] = 0;
				Jps[i] = 1;
			}
		}
		int[] hsums = new int[N+1];
		int[] gsums = new int[N+1];
		int[] jsums = new int[N+1];
		for(int i =1;i <N+1;i++) {
			hsums[i] = hsums[i-1]+Hps[i] ;
			gsums[i] =  gsums[i-1]+Gps[i];
			jsums[i] = jsums[i-1]+Jps[i];
		}
		for(int q = 0; q<Q;q++) {
			//calculate each query
			st = new StringTokenizer(br.readLine());
			int beg = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pw.println((hsums[end]-hsums[beg-1]) + " " + (gsums[end]-gsums[beg-1]) + " " + (jsums[end]-jsums[beg-1]));
		}
		pw.close();
	}
	public static int prefixsum (int[] arr, int target) {
		int[] prefix = new int[target+1];
		for(int i =1;i<=target;i++) {
			prefix[i] = arr[i] + prefix[i-1];
		}
		return prefix[target];
	}
}
