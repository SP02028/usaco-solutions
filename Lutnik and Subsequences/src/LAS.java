import java.util.*;
import java.io.*;
public class LAS {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int len=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			long[] arr=new long[len];
			long count0=0;
			long count1=0;
			for(int i=0;i<len;i++) {
				arr[i]=Long.parseLong(st.nextToken());
				if(arr[i]==0) {
					count0++;
				}
				if(arr[i]==1) {
					count1++;
				}
			}
			System.out.println((long)Math.pow(2, count0)*count1);
		}

	}

}
