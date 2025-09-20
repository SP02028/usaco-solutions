import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		 BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter pw = new PrintWriter(System.out);
	        StringTokenizer st = new StringTokenizer(r.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int[] distances = new int[n];
	        for(int i = 0; i<n;i++) {
	        	distances[i] = i;
	        }
	        int[] doors = new int[n];
	        for(int j = 0; j<n;j++) {
		    StringTokenizer t = new StringTokenizer(r.readLine());
	        doors[j] = Integer.parseInt(t.nextToken());
	        }
	        int[] total = new int[n];
	        int sum = 0;
	        for(int k = 0; k<n;k++) {
	        	for(int l = 0; l <n;l++) {
	        		sum += (distances[l])*(doors[l]);
	        	}
	        	total[k] = sum;
	        	sum = 0;
	        	doors = ltf(doors);
	        }
	        Arrays.sort(total);
	        pw.println(total[0]);
	        pw.close();
	}
	

	    public static int[] ltf(int[] arr) {
	        int n = arr.length;
	        int[] newArr = new int[n];
	        newArr[0] = arr[n - 1]; 
	        for (int i = 1; i < n; i++) {
	            newArr[i] = arr[i - 1];
	        }
	        return newArr;
	    }
	}


