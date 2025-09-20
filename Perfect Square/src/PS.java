import java.io.*;
import java.util.*;
public class PS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i < tc;i++) {
			int len = Integer.parseInt(br.readLine());
			int[][] square = new int[len][len];
			for(int j = 0; j < len;j++) {
				String str = br.readLine();
				for(int c = 0; c<len;c++) {
					square[j][c] = str.charAt(c)-'a';
				}
			}
			//converted square to "number of letters off from a"
			int numchange =0;
			for(int pos  = 0; pos<len;pos++) {
				for(int p = 0; p <len;p++) {
					if(square[pos][p] == square[p][len-1-p]) {
						continue;
					}
					else {
						numchange+= Math.max(square[pos][p], square[p][len-1-p]) - Math.min(square[pos][p], square[p][len-1-pos]);
					}
				}
			}
			//determine how many characters off each character is from the corresponding character after the rotation
			pw.println(numchange);
		}
		pw.close();
	}

}
