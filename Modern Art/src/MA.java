import java.util.*;
import java.io.*;
public class MA {

	public static void main(String[] args) throws IOException{
		//read input
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];
		boolean[] beenadded = new boolean[10];
		ArrayList<Integer> colors = new ArrayList<>();
		for(int i =0; i <N;i++) {
			String str = br.readLine();
			for(int j =0; j <N;j++) {
				grid[i][j] = str.charAt(j)-'0';
				if(beenadded[grid[i][j]] == false && grid[i][j]!=0) {
					colors.add(grid[i][j]);
					beenadded[grid[i][j]] =true;
				}
			}
		}
		//find and store boundary values
		int[][] boundaries = new int[10][4];
		//0 --> left
		//1 --> right
		//2 --> up
		//3 --> bottom
		int numcolors=0;
		for(int c:colors) {
			numcolors++;
			int minvalidj =Integer.MAX_VALUE;
			int maxvalidj = 0;
			int minvalidi = Integer.MAX_VALUE;
			int maxvalidi = 0;
			for(int i =0;i<N;i++) {
				for(int j =0; j<N;j++) {
					if(grid[i][j]==c) {
						minvalidj = Math.min(j, minvalidj);
						minvalidi = Math.min(i, minvalidi);
						maxvalidj = Math.max(j, maxvalidj);
						maxvalidi = Math.max(i, maxvalidi);
					}
				}
			}
			boundaries[c][0] = minvalidj;
			boundaries[c][1] = maxvalidj;
			boundaries[c][2] = minvalidi;
			boundaries[c][3] = maxvalidi;
		}
		//for each pair of colors, determine if any color isn't possible b/c it takes up space in anothers boundary
		boolean[] startpos = Arrays.copyOf(beenadded, 10);
		//false if not even in grid to begin
		//others start as true but we'll iterate over these true values and make them false if need be
		for(int a =0; a<numcolors;a++) {
			for(int b = 0;b<numcolors;b++) {
				int colora = colors.get(a);
				int colorb = colors.get(b);
				//we're checking if b intrudes on a's boundaries
				if(b!=a&& startpos[colorb]!=false) {
					int left = boundaries[colora][0];
					int right = boundaries[colora][1];
					int up = boundaries[colora][2];
					int down = boundaries[colora][3];
					for(int i = up;i <=down;i++) {
						for(int j = left; j <=right;j++) {
							if(grid[i][j]==colorb) {
								startpos[colorb] = false;
								break;
							}
						}
					}
				}
				if(!startpos[colorb]) {
					continue;
				}			
			}
		}
		int count=0;
		for(boolean b:startpos) {
			if(b) {
				count++;
			}
		}
		pw.println(count);
		pw.close();
	}

}
