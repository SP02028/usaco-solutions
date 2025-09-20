import java.util.*;
import java.io.*;
public class PtC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int numwrongtries = Integer.parseInt(st.nextToken());
			 st = new StringTokenizer(br.readLine());
			char[] line = st.nextToken().toCharArray();
			 st = new StringTokenizer(br.readLine());
			 int[] wrongtries = new int[numwrongtries];
			for(int i = 0; i <numwrongtries; i++) {
				wrongtries[i] = Integer.parseInt(st.nextToken()) - 1;
			}
			//for each element in the array, check how many tries it is included in.
			Arrays.sort(wrongtries);
			//have a counter going as you iterate through wrong tries, and check if each element is greater than the current position or not.
			int[] alphabet = new int[26];
			int posles = 0;
			for(int i =0; i < len;i++) {
				int count = 1;
				
				while(posles<numwrongtries && i>wrongtries[posles]) {
					posles++;				
				}
				count += numwrongtries - posles;
				int charpos = line[i] - 'a';
				alphabet[charpos] += count;
			}
			for(int a: alphabet) {
				pw.print(a + " ");
			}
			pw.println();
		}
		pw.close();
	}

}
