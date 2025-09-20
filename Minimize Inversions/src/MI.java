import java.util.*;
import java.io.*;
public class MI {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0; i <tc;i++) {
			//how to do this w/o using a map?
			StringTokenizer st= new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			StringTokenizer t= new StringTokenizer(br.readLine());
			int[][] arr = new int[len][2];
			for(int j = 0; j <len;j++) {
				arr[j][0] = Integer.parseInt(t.nextToken());
			}
			StringTokenizer s= new StringTokenizer(br.readLine());
			for(int k = 0; k <len;k++) {
				arr[k][1] = Integer.parseInt(s.nextToken());
			}
			Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
			pw.println();
			for(int j = 0; j < len;j++) {
				pw.print(arr[j][0] + " ");
			}
			pw.println();
			for(int k = 0; k<len;k++) {
				pw.print(arr[k][1] + " ");
			}
		}
		pw.close();
	}

}
