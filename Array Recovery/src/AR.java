import java.util.*;
import java.io.*;
public class AR {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			int[] d =new int[len];
			boolean multiple = false;
			for(int i =0; i <len;i++) {
				d[i] = Integer.parseInt(st.nextToken());
				if(i>0) {
					pw.println("Elements");
					pw.println(d[i-1]);
					pw.println(d[i]);
					if(d[i]<d[i-1] && d[i]!=0) {
						pw.println("Curr ele less than prev");
						multiple=true;
					}
				}
			}
			if(multiple) {
				pw.println(-1);
				continue;
			}
			int[] a = new int[len];
			a[0]=d[0];
			for(int i = 1; i<len;i++) {
				a[i] = a[i-1] + d[i];
			}
			for(int ele:a) {
				pw.print(ele+" ");
			}
			pw.println();
		}
		pw.close();
	}
}
