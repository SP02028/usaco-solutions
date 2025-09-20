import java.util.*;
import java.io.*;
public class CC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			int len = Integer.parseInt(br.readLine());
			int[] heights = new int[len];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < len; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(heights);
			if(len==2) {
				pw.println(heights[0] + " " + heights[1]);
				continue;
			}
			int pos = -1;
			int minnum = Integer.MAX_VALUE;
			for(int i = 1; i <len;i++) {
				if(minnum > Math.abs(heights[i] - heights[i-1] )) {
					pos=i;
					minnum = Math.abs(heights[i] - heights[i-1]);
				}
			}
			for(int i = pos; i <len;i++) {
				pw.print(heights[i] + " ");
			}
			for(int i = 0; i <pos;i++) {
				pw.print(heights[i] + " ");
			}
			pw.println();
		}
		pw.close();
	}

}
