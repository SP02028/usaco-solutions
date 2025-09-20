import java.util.*;
import java.io.*;
public class HC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numdeliveries = Integer.parseInt(st.nextToken());
		int numdays = Integer.parseInt(st.nextToken());
		int[][] deliver=new int[numdeliveries+1][2];
		for(int i = 0;i<numdeliveries;i++) {
			st = new StringTokenizer(br.readLine());
			deliver[i][0] = Integer.parseInt(st.nextToken());
			deliver[i][1] = Integer.parseInt(st.nextToken());
		}
		deliver[numdeliveries][0] = numdays+1;
		deliver[numdeliveries][1] = 0;
		int lastdelivery = 0;
		int rem = 0;
		int total = 0;
		for(int[]d:deliver) {
			total +=d[1];
			rem -= d[0]-lastdelivery;
			lastdelivery = d[0];
			rem = Math.max(0, rem) + d[1];
		}
		pw.println(total-rem);
		pw.close();
	}
	

}
