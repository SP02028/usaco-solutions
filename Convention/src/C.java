import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter("convention.out");
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		//Upperbound = maxval in arr
		int l =0;
		int r = arr[arr.length-1];
		while(l<=r) {
			int mid = (l+r)/2;
			int first = arr[0];
			int used =1;
			int cap = 0;
			for(int i=0;i<N;i++) {
				if(arr[i]-first>mid || cap>=C) {
					used++;
					cap = 0;
					first = arr[i];				
				}
				cap++;
			}
			if(used<=M) {
				r=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		pw.println(l);
		pw.close();
	}

}
