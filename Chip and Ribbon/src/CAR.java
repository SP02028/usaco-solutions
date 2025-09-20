import java.util.*;
import java.io.*;
public class CAR {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t =0 ;t<tc;t++) {
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr=new int[len];
			for(int i = 0 ; i <len; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int numchips = arr[0]-1;
			for(int j = 1; j < len;j++) {
				int create = Math.max(0, arr[j]-arr[j-1]);
				numchips+=create;
			}
			pw.println(numchips);
		}
		pw.close();
	}

}
