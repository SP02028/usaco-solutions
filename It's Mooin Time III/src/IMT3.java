import java.util.*;
import java.io.*;
public class IMT3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =  new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		if(Q==1) {
			//so that performance in THIS tc doesnt impact others
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int lastin =N-1;
			int firstin = 0;
			for(int i=0;i<N;i++) {
				if(str.charAt(i)!=lastin) {
					firstin = i;
					break;
				}
			}
			int maxval = 0;
			for(int j =firstin;j<lastin;j++) {
				if(str.charAt(j)==lastin) {
					maxval = Math.max(maxval, (j-firstin)*(j-lastin));
				}
			}
			pw.println(maxval);
		}
		else {
		for(int q=0;q<Q;q++) {
			 st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int maxval = -1;
			for(int i = l; i <=r;i++) {
				for(int j = l ; j <=r; j++) {
					for(int k = l; k<=r;k++) {
						if(i<j && j<k &&(str.charAt(i-1)!=str.charAt(j-1))&&(str.charAt(j-1)==str.charAt(k-1))) {
							int curr = (j-i)*(k-j);
							maxval = Math.max(maxval, curr);
						}
					}
				}
			}
			pw.println(maxval);
		}
		}
		pw.close();

	}

}
