import java.util.*;
import java.io.*;
public class SP {

	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(System.out);
	int tc = Integer.parseInt(br.readLine());
	for(int t=0;t<tc;t++) {
		int num = Integer.parseInt(br.readLine());
		if(num%2==1&& num>1) {
			pw.println(-1);
			continue;
		}
		else {
			int[] temp = new int[num];
			for(int i = 0; i <num;i++) {
				if(i%2==0) {
					temp[i] = num-i;
				}
				else {
					temp[i]=i;
				}
			}
			for(int e:temp) {
				pw.print(e + " ");
			}
			 pw.println();

		}
	}
	pw.close();
	}

}
