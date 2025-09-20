import java.util.*;
import java.io.*;
public class gcdlen {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		 String x = "1";
		 for(int i = 0; i <a-1;i++) {
			 x+="0";
		 }
		 String y = "";
		 for(int i =0;i<b-c+1;i++) {
			 y+="1";
		 }
		 for(int i = 0; i <c-1;i++) {
			 y+="0";
		 }
		 pw.print(x +" " + y);
		 pw.println();
		}
		pw.close();
	}

}
