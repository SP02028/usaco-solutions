import java.util.*;
import java.io.*;
public class IA {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String str = br.readLine();
		int[][] freq = new int[26][str.length()];
		for(int i = 0; i < str.length();i++) {
			if(i==0) {
				freq[str.charAt(i)-'a'][0] = 1;
			}
			else {
			freq[str.charAt(i)-'a'][i] = freq[str.charAt(i)-'a'][i-1] + 1; 
			for(int j = 0 ; j < 26;j++) {
				if(j!=(str.charAt(i)-'a')) {
					freq[j][i] = freq[j][i-1];
				}
			}
			}
		}
		int Q = Integer.parseInt(br.readLine());
		while(Q-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int charcount = 0;
			for(int i =0; i <26;i++) {
				int count = 0;
				if (l == 1) {
				    count = freq[i][r - 1];
				} else {
				    count = freq[i][r - 1] - freq[i][l - 2];
				}
				if(count>0) {
					charcount++;
				}
			}
			if(r-l+1 == 1) {
				pw.println("YES");
			}
			else if(str.charAt(l-1) != str.charAt(r-1)) {
				pw.println("YES");
			}
			else if(charcount >=3) {
				pw.println("YES");
			}
			else {
				pw.println("NO");
			}
		}
		pw.close();
	}

}
