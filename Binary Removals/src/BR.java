import java.io.*;
import java.util.*;
public class BR {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0;i<tc;i++) {
			String str = br.readLine();
			int first11 = -1;
			int first00 = -1;
			for(int c = 0; c< str.length()-1;c++) {
				if(str.charAt(c)=='1'&&str.charAt(c+1)=='1') {
					if(first11!=-1) {
					first11= Math.min(first11, c);
					}
					else {
						first11=c;
					}
				}
				if(str.charAt(c)=='0'&&str.charAt(c+1)=='0') {
					if(first00!=-1) {
						first00= Math.min(first00, c);
						}
						else {
							first00=c;
						}
				}
			}

			if(first11 < first00 && first11 !=-1 && first00 !=-1 ) {
				pw.println("NO");
			}else {
				pw.println("YES");
			}
		}
		pw.close();
	}
}
