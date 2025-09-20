import java.util.*;
import java.io.*;
public class emoc {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw  = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringTokenizer s = new StringTokenizer(br.readLine());
		int odd= 0;
		int even = 0;
		for(int i =0; i <N;i++) {
			int temp = Integer.parseInt(s.nextToken());
			if(temp%2 ==0) {
				even++;
			}
			else {
				odd++;
			}
		}
		while(odd>even) {
			odd = odd-2;
			even++;
		}
		if(even>odd+1) {
			even = odd+1;
		}
		pw.println(odd+even);
		pw.close();
	}

}
