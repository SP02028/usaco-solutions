import java.util.*;
import java.io.*;
public class TLS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int numstrs = Integer.parseInt(br.readLine());
			int[][] count = new int[12][12];
			long ans = 0;
			for(int i=0;i<numstrs;i++) {
				char[] str = br.readLine().toCharArray();
				for(int j =0;j<2;j++) {
					for(char c = 'a';c<='k';c++) { //new technique i learned by looking at implementation
						if(c == str[j]) {
							continue;
						}
						char[] temp = Arrays.copyOf(str, str.length);
						temp[j] = c;
						ans += count[temp[0]-'a'][temp[1]-'a'];
					}
				}
				count[str[0]-'a'][str[1]-'a']++;
			}
			pw.println(ans);
		}
		pw.close();
	}

}
