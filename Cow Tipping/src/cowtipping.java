import java.util.*;
import java.io.*;
public class cowtipping {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter("cowtip.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		 for (int i = 0; i < N; i++) {
	            String line = br.readLine();
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = line.charAt(j) - '0'; // Convert character to integer
	            }
	        }
		int topleftx = 0;
		int toplefty = 0;
		int count =0;
		for(int row = N-1; row>=0; row--) {
			for(int column = N-1; column >=0;column--) {
				if(arr[row][column] == 1) {
					arr=flip(arr, row,column);
					count++;
				}
				else {
					continue;
				}
			}
		}
		pw.println(count);
		pw.close();
	}
	public static int[][] flip(int[][] field, int brx, int bry) {
		for(int currx = brx; currx>=0;currx--) {
			for(int curry=bry;curry>=0;curry--) {
				if(field[currx][curry] == 0) {
					field[currx][curry] = 1;
				}
				else {
					field[currx][curry] = 0;
				}
			}
		}
		return field;
	}
}
