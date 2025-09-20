import java.util.*;
import java.io.*;
public class LL {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int minmoves = a+b;
			for(int i = 1;i <=100000;i++ ) {
				int temp = Math.ceilDiv(a, i) + Math.ceilDiv(b,i) + i-1;
				minmoves = Math.min(temp, minmoves);
			}
			pw.println(minmoves);
		}
		pw.close();

	}

}
