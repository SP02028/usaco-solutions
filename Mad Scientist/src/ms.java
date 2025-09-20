import java.util.*;
import java.io.*;
public class ms {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileInputReader(breedflip.in));
		PrintWriter pw = new PrintWriter(System.out);
		//PrintWriter pw = new PrintWriter(breedflip.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][2];
		StringTokenizer s= new StringTokenizer(br.readLine());
		char[] str1 = (s.nextToken()).toCharArray();
		StringTokenizer t= new StringTokenizer(br.readLine());
		char[] str2 = (t.nextToken()).toCharArray();
		
		ArrayList<Integer> subs = new ArrayList<Integer>();
		int count =0;
		for(int j=0;j<N;j++) {
			if(str1[j] != str2[j]) {
				count++;
			}
			else {
				if(count!=0) {
					subs.add(count);
					count = 0;
				}
			}
		}
		System.out.println(subs);
		pw.println(subs.size());
		pw.close();
	}
}


