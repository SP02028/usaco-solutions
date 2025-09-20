import java.io.*;
import java.util.*;
public class RQ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t <tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startnum = Integer.parseInt(st.nextToken());
			int endnum = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] pos = new int[10][endnum+1];
			for(int i =1;i<endnum+1;i++) {
				int index = finddigitproduct(i);
				pos[index][i] = 1;
			}
			int[][] sums = new int[10][endnum+1];
			for(int i =1; i <endnum+1;i++) {
				sums[1][i] = sums[1][i-1] + pos[1][i];
				sums[2][i] = sums[2][i-1] + pos[2][i];
				sums[3][i] = sums[3][i-1] + pos[3][i];
				sums[4][i] = sums[4][i-1] + pos[4][i];
				sums[5][i] = sums[5][i-1] + pos[5][i];
				sums[6][i] = sums[6][i-1] + pos[6][i];
				sums[7][i] = sums[7][i-1] + pos[7][i];
				sums[8][i] = sums[8][i-1] + pos[8][i];
				sums[9][i] = sums[9][i-1] + pos[9][i];
			}
			pw.println(sums[k][endnum]-sums[k][startnum-1]);
		}
		pw.close();
	}
	public static int finddigitproduct(int n) {
	    if (n <10) { 
	        return n;
	    }
	    int product = 1;
	    String str = Integer.toString(n);
	    for (int i = 0; i < str.length(); i++) {
	        if (str.charAt(i) != '0') { 
	            product *= str.charAt(i) - '0';
	        }
	    }   
	  return finddigitproduct(product);
	}	
}
