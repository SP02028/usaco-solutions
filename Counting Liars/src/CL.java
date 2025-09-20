import java.util.*;
import java.io.*;
public class CL {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int len = Integer.parseInt(br.readLine());
		int[] cows= new int[len];
		boolean[] greaterorless = new boolean[len]; //false is less true greater
		for(int i = 0; i <len; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(st.nextToken().equals("G")) {
			greaterorless[i] = true;
			cows[i] = Integer.parseInt(st.nextToken());
		}
		else {
			greaterorless[i] = false;
			cows[i] = Integer.parseInt(st.nextToken());
		}
		}
		//Arrays.sort(cows);
		int minliars = Integer.MAX_VALUE;
		for(int i = 0;i<len;i++) {
			int liarless = 0;
			int liargreater = 0;
			for(int j = 0; j<len;j++) {
				if(cows[j]<cows[i] && greaterorless[j]==false) {
					liarless++;
				}
				else if(cows[j]>cows[i] && greaterorless[j] ==true) {
					liargreater++;
				}
			}
			minliars=Math.min(liarless+liargreater, minliars);
		}
		pw.println(minliars);
		pw.close();
	}

}
