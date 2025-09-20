import java.util.*;
import java.io.*;
public class MCP {

	public static void main(String[] args) throws IOException{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw =new PrintWriter(System.out);
	int tc= Integer.parseInt(br.readLine());
	for(int t=0;t<tc;t++) {
		int numcows = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr =  new int[numcows];
		int maxcow = 0;
		for(int i =0;i<numcows;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxcow=Math.max(maxcow, arr[i]);
		}
		int[] freq = new int[maxcow+1];
		for(int i =0;i<numcows;i++) {
			freq[arr[i]]++;
		}
		int count=1;
		for(int i =1; i <maxcow;i++) {
			if(freq[i]>=2) {
				count+=2;
			}
		}
		pw.println(count);
	}
	pw.close();
	}

}
