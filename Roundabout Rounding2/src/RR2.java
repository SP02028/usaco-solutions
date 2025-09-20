import java.util.*;
import java.io.*;
public class RR2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int num = Integer.parseInt(br.readLine());
			if(num==1)
			{
				pw.println(0);
				continue;
			}
			  int digits = 0;
		        while (Math.pow(10, digits) < num) {
		            digits++;
		        }	        
		        int count = 0;
		        for (int curdigits = 1; curdigits <= digits; curdigits++) {
		            int upper = (int) Math.min(num, Integer.parseInt("5" + "0".repeat(curdigits - 1)) - 1);
		            int lower = Integer.parseInt("4".repeat(curdigits));
		            count += Math.max(0, upper - lower);
		        }
	            pw.println(count);

		}
		pw.close();
	}

}
