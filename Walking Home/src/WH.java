import java.util.*;
import java.io.*;
public class WH {

	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw=new PrintWriter(System.out);
	int tc = Integer.parseInt(br.readLine());
	for(int t = 0;t<tc;t++) {
		StringTokenizer st= new StringTokenizer(br.readLine());
		int sidelen = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] grid = new char[sidelen][sidelen];
		for(int i = 0; i <sidelen;i++) {
			String line = br.readLine();
			for(int j = 0;j < sidelen;j++) {
				grid[i][j]  = line.charAt(j);
			}
		}
		int paths = 0;
		if(K>=1) {
			boolean urcorner = true;
			boolean dlcorner = true;
			for(int i =0;i<sidelen;i++) {
				if(grid[0][i] == 'H' || grid[i][sidelen-1] == 'H') {
					urcorner = false;
				}
				if(grid[i][0] == 'H' || grid[sidelen-1][i] == 'H') {
					dlcorner = false;
				}
			}
			if(urcorner) {
				paths++;
			}
			if(dlcorner) {
				paths++;
			}
		} 
		if(K>=2) {
			// Column
			for(int j = 1; j < sidelen-1; j++) {
				boolean valid = true;
				for(int i = 0; i < sidelen; i++) {
					if(grid[i][j] == 'H') {
						valid = false;
					}
					if(i < j && grid[0][i] == 'H') {
						valid = false;
					}
					if(i > j && grid[sidelen-1][i] == 'H') {
						valid = false;
					}
				}
				if(valid) {
					paths++;
				}
			}
			// Row
			for(int i = 1; i < sidelen-1; i++) {
				boolean valid = true;
				for(int j = 0; j < sidelen; j++) {
					if(grid[i][j] == 'H') {
						valid = false;
					}
					if(j < i && grid[j][0] == 'H') {
						valid = false;
					}
					if(j > i && grid[j][sidelen-1] == 'H') {
						valid = false;
					}
				}
				if(valid) {
					paths++;
				}
			}
		}
		if(K>=3) {
			for(int i = 1; i < sidelen-1; i++) {
				for(int j = 1; j < sidelen-1; j++) {
					if(grid[i][j] != '.') {
						continue;
					}
					boolean valid = true;
					for(int a = 0; a < sidelen; a++) {
						if(a <= i && grid[a][j] == 'H') {
							valid = false;
						}
						if(a >= i && grid[a][sidelen-1] == 'H') {
							valid = false;
						}
						if(a <= j && grid[0][a] == 'H') {
							valid = false;
						}
						if(a >= j && grid[i][a] == 'H') {
							valid = false;
						}
					}
					if(valid) {
						paths++;
					}
					valid = true;
					for(int a = 0; a < sidelen; a++) {
						if(a <= i && grid[a][0] == 'H') {
							valid = false;
						}
						if(a >= i && grid[a][j] == 'H') {
							valid = false;
						}
						if(a <= j && grid[i][a] == 'H') {
							valid = false;
						}
						if(a >= j && grid[sidelen-1][a] == 'H') {
							valid = false;
						}
					}
					if(valid) {
						paths++;
					}
				}
			}
		}
		pw.println(paths);
	}
	pw.close();
	}
}

