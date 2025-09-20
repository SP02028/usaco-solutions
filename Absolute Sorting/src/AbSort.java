import java.util.*;
import java.io.*;
public class AbSort {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int i=0;i<tc;i++) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(t.nextToken());
			int[] arr = new int[N];
			StringTokenizer s = new StringTokenizer(br.readLine());
			for(int j =0; j<N;j++) {				
				arr[j]=Integer.parseInt(s.nextToken());
			}
			//keep track of what case the array is by iterating through it
			if(arr.length>3) {
			boolean[] keep = new boolean[N-1];
			int truecount =0;
			int falsecount = 0;
			for(int e = 1; e<N-1;e++) {
				if(arr[e]>arr[e-1]||arr[e]>=arr[e-1]) {
					keep[e-1] = true; //it is already ascending
					truecount++;
				}
				else {
					keep[e-1] = false; // not ascending
					falsecount++;
				}
			}
			//pw.println(truecount);
			//pw.println(falsecount);
			if(truecount==N-2) {
				pw.println(0);
				continue;
			}
			else if(falsecount == N-2) {
				pw.println(arr[0]);
			}
			else if(arr[0]==arr[N-1]) {
				int equalcount = 0;
				int val = arr[1];
				for(int n = 2; n <N-1;n++) {
					if(arr[n]==val) {
						equalcount++;
					}
				}
				if(equalcount ==N-3) {
					if((arr[0]+arr[1])%2==0) {
						pw.println((arr[0]+arr[1])/2);
					}
					else {
						pw.println(-1);
						continue;
					}
				}
				else {
					pw.println(-1);
				}
			}
			else if(itd(keep)) {
				pw.println(arr[0]);
				}
			else {
				pw.println(-1);
			}
			}
			else if(arr.length==2) {
				if(arr[1]>=arr[0]) {
					pw.println(0);
				}
				else {
					pw.println(arr[0]);
				}
			}
			else if(arr.length==3) {
				if(arr[2]>=arr[1]&&arr[1]>=arr[0]) {
					pw.println(0);
					}
				else if(arr[2]<arr[1]&&arr[1]<arr[0]) {
					pw.println(arr[0]);
				}
				else if(arr[0]==arr[2]&&(arr[0]+arr[2])%2==0&&arr[1]<arr[0]) {
					pw.println((arr[0]+arr[2])/2);
				}
				else if(arr[1]>=arr[0]&&arr[2]<arr[1]) {
					pw.println(arr[0]);
				}
				else {
					pw.println(-1);
				}
			}
			else if(arr.length==1) {
				pw.println(0);
			}
		}
		pw.close();
	}
	public static boolean itd (boolean[] increase) {
		for(int index = 0; index<increase.length;index++) {
			if(increase[index] ==true) {
				boolean allaftertrue = true;
				for(int m = index+1;m<increase.length;m++) {
					if(increase[m]!=true) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
