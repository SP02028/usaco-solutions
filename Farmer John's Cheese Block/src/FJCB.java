import java.util.*;
import java.io.*;
public class FJCB {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int numentries = Integer.parseInt(st.nextToken());
		int[][] xy = new int[N][N];
		int[][] yz = new int[N][N];
		int[][] xz = new int[N][N];
		int count =0;
		for(int i =0; i <numentries;i++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			xy[x][y]+=1;
			xz[x][z]+=1;
			yz[y][z] +=1;
			if(xy[x][y]==N) {
				count++;
			}
			if(xz[x][z]==N) {
				count++;
			}
			if(yz[y][z]==N) {
				count++;
			}
			pw.println(count);
		}
		pw.close();
	}

}
