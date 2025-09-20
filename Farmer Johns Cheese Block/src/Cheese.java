import java.util.*;
import java.io.*;
public class Cheese {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw  = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[][] xy = new int[1000][1000];
		int[][] xz = new int[1000][1000];
		int[][] yz = new int[1000][1000];
		int tally = 0;
		for(int i = 0; i <q;i++) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(t.nextToken());
			int y = Integer.parseInt(t.nextToken());
			int z = Integer.parseInt(t.nextToken());
			
			xy[x][y] +=1;
			if(xy[x][y]== n) {
				tally++;
			}
			xz[x][z] +=1;
			if(xz[x][z]== n) {
				tally++;
			}
			yz[y][z] +=1;
			if(yz[y][z]== n) {
				tally++;
			}
			pw.println(tally);
		}
		pw.close();
	}
	
}
