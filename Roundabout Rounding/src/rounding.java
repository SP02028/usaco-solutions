import java.util.*;
import java.io.*;
public class rounding {

	public static void main(String[] args) throws IOException{
		  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	      PrintWriter pw = new PrintWriter(System.out);
	      StringTokenizer st = new StringTokenizer(r.readLine());
	      int T = Integer.parseInt(st.nextToken());
	      int[] arr = new int[T];
	      for(int i = 0; i<T; i++) {
		     StringTokenizer t = new StringTokenizer(r.readLine());
		     int n = Integer.parseInt(t.nextToken());
		     int[] besmeth = new int[n];
		     for(int k = 0; k <n;k++) {
		    	 besmeth[k] = bessie(k);
		     }
		     int[] chainmeth = new int[n];
		     for(int l = 0; l<n; l++) {
		    	 chainmeth[l] = chain(l);
		     }
		     int count = 0;
		     for(int m = 1; m <n; m++) {
		    	 if(chainmeth[m] != besmeth[m]) {
		    	 System.out.println(chainmeth[m]);
		    	 System.out.println(besmeth[m]);
		    	 }
		     }
		     arr[i] = count;
	      }
	      for(int ele:arr) {
	    	  System.out.println(ele);
	      }
	  
	}
	public static int chain (int b) {
		char[] chararr = String.valueOf(b).toCharArray();
		int[] intarr = new int[chararr.length];
		if(b<2 || chararr.length<=1) {
			return 0;
		}
		else {
			for(char c: chararr) {
				int d = 0;
				intarr[d] = Integer.valueOf(c);
				d++;
			}
			for(int index = intarr.length-1;index>0;index--) {
				if(intarr[index]>5) {
					intarr[index-1] +=1;
				}
				intarr[index] = 0;
			}
			String complete = "";
			for(int r:intarr) {
				complete+=String.valueOf(r);
			}
		return Integer.parseInt(complete);
		}
		
		
		}		
	public static int bessie (int a) {
		char[] chararr = String.valueOf(a).toCharArray();
		if(chararr[0] < 5) {
			chararr[0] = '0';
		}
		else {
			chararr[0] = '1';
		}
		String rounded = String.valueOf(chararr[0]);
		for(int j =0;j<chararr.length+1;j++) {
			rounded += "0";
		}
		return Integer.valueOf(rounded);
		
	}
}
