import java.util.*;
import java.io.*;
public class CR {
	private static char[][] grid;
	private static boolean[][] visited;
	private static int rowNum;
	private static int colNum;
	//Always maintain these static variables when doing floodfill
	//type problems
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		grid = new char[rowNum][colNum];
		for(int i=0;i<rowNum;i++) {
			String row = br.readLine();
			for(int j =0; j <colNum;j++) {
				grid[i][j] = row.charAt(j);
			}
		}
		visited = new boolean[rowNum][colNum];
		int count = 0;
		for(int i = 0; i < rowNum;i++) {
			for(int j = 0; j < colNum;j++) {
				if(grid[i][j] == '.' && visited[i][j] == false) {
					floodfill(i,j);
					count++;
				}
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(count);
		pw.close();
	}
	public static void floodfill( int r, int c) {
		if(r<0||r>=rowNum || c<0 || c>= colNum) {//out of bounds
			return;
		}
		if(grid[r][c]=='#' || visited[r][c]) { //alr visited
			return;
		}
		visited[r][c] = true;//current square visited
		// recursively call flood fill for neighboring squares
		floodfill(r+1, c);
		floodfill(r-1, c);
		floodfill(r, c+1);
		floodfill(r, c-1);

	}
}


