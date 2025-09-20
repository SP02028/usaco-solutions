import java.util.*;
import java.io.*;
public class MLCM {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t =0;t<tc;t++) {
			int n = Integer.parseInt(br.readLine());
			int a = 1;
			for (int i = 2; Math.pow(i, 2) <= n;i++) {
			      if (n % i == 0) {
			        a = n / i;
			        break;
			      }
			    }
			pw.print(a + " ");
			pw.print(n-a);
			pw.println();
		}
		pw.close();
	}

}
