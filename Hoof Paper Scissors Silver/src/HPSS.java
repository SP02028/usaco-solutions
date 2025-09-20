import java.util.*;
import java.io.*;
public class HPSS {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		int[] Ps = new int[N+1];
		int[] Hs = new int[N+1];
		int[] Ss = new int[N+1];
		for(int i = 1; i <N+1;i++) {
			int n = br.readLine().charAt(0);
			if(n=='P') {
				Ps[i] = 1;
				Hs[i] = 0;
				Ss[i] = 0;
			}
			else if(n=='H') {
				Ps[i] = 0;
				Hs[i] = 1;
				Ss[i] = 0;
			}else {
				Ps[i] = 0;
				Hs[i] = 0;
				Ss[i] = 1;
			}
		}
		int[] Psums = new int[N+1];
		int[] Hsums = new int[N+1];
		int[] Ssums = new int[N+1];
		for(int i =1;i <N+1;i++) {
			Psums[i] = Psums[i-1]+Ps[i] ;
			Hsums[i] =  Hsums[i-1]+Hs[i];
			Ssums[i] = Ssums[i-1]+Ss[i];
		}
		int maxcnt = -1;
		for(int i = 1;i <=N;i++) {
			int maxpref = Math.max(Psums[i], Math.max(Hsums[i], Ssums[i]));
			int maxsuf = Math.max(Psums[N]-Psums[i], Math.max(Hsums[N]-Hsums[i], Ssums[N]-Ssums[i]));
			maxcnt = Math.max(maxpref+maxsuf, maxcnt);
		}
		pw.println(maxcnt);
		pw.close();
	}

}
