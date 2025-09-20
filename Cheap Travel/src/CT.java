import java.util.*;
import java.io.*;
public class CT {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(a*m < b) {
			pw.println(n*a);
		}
		else {
			pw.println((n/m)*b + Math.min(a*(n%m),b));
		}
		pw.close();
	}

}
