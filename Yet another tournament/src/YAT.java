import java.util.*;
import java.io.*;
public class YAT {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc=  Integer.parseInt(br.readLine());
		for(int t = 0; t<tc;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] times = new int[n];
			 st= new StringTokenizer(br.readLine());
			for(int i =0; i <n;i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			int[] times2 = times.clone();
			int numbeat = 0;
			Arrays.sort(times2);
			for(int i = 0; i <n;i++) {
				if(times2[i] <=m) {
					m-=times2[i];
					numbeat++;
				}
				else {
					break;
				}
			}
			if((numbeat!=0) && (numbeat!=n) && (m+times2[numbeat-1])>=times[numbeat] ) {
				numbeat++;
			}
			pw.println(n+1-numbeat);
		}
		pw.close();
	}

}
