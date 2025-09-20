import java.util.*;
import java.io.*;
public class GZ {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[len];
		for(int i = 0;i<len;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int ele: arr) {
			int count = Integer.MAX_VALUE;
			for(int i = 0; i<=15;i++) {
				for(int j = 0; j <15;j++) {
					long newele = (long) ((ele + i) * Math.pow(2, j));
				if((newele)%32768 == 0) {
					int total = i+j;
					count = Math.min(count, total);
				}
				}
			}
			pw.print(count + " ");
		}
		pw.close();
	}

}
