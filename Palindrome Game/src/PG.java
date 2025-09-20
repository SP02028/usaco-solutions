import java.io.*;
import java.util.*;
public class PG {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t<tc;t++) {
			char[] line = br.readLine().toCharArray();
			if(line[line.length-1]=='0') {
				pw.println("E");
			}
			else {
				pw.println("B");
			}
		}
		pw.close();
	}

}
