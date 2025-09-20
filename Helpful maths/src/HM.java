import java.util.*;
import java.io.*;
public class HM {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		char[] line = br.readLine().toCharArray();
		int[] newline = new int[line.length/2+1];
		int i = 0;
		for(char c:line) {
			int val = c-48;
			if(val == 3 || val == 1||val==2) {
				newline[i] = val;
				i++;
			}
		}
		Arrays.sort(newline);
		for(int j = 0; j<newline.length;j++) {
			if(j>0) {
				pw.print("+");
			}
			pw.print(newline[j]);
		}
		pw.close();
	}

}
