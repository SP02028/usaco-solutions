import java.util.*;
import java.io.*;
public class outofplace {

	public static void main(String[] args) throws IOException{
		//you overthought this one, the correct is simply just figure out how many cows are out of place
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(System.out);
	  //BufferedReader r = new BufferedReader(new FileReader("outofplace.in"));
     //   PrintWriter pw = new PrintWriter("outofplace.out");  
      StringTokenizer st = new StringTokenizer(r.readLine());	
	    int N = Integer.parseInt(st.nextToken());
	    int[] arr = new int[N];
	    HashSet<Integer> s = new HashSet<Integer>();
	    for(int i = 0;i<N;i++) {
	    	StringTokenizer t = new StringTokenizer(r.readLine());
	    	arr[i] = Integer.parseInt(t.nextToken());
	    }
	    int mis = 0;
	    for(int j = 1; j < N-1; j++) {
	    	if(arr[j-1]<= arr[j] && arr[j] <= arr[j+1]) {
	    		continue;
	    	}
	    	else if(arr[j+1]<arr[j-1]) {
	    	//i.e 7 9 3 where 9 is arr[j] and 3 is arr[j+1]
	    		mis  = arr[j+1];
	    		pw.println(mis);
	    		for(int k = 0; k < j+1; k++) {
	    			if(arr[k]>arr[j+1]) {
	    				s.add(arr[k]);
	    		}
	    		}
	    	}
          //1 2 3 4 9 5 6 7
          //  arr[j] = 9
          //1 2 3 5 4 6 7 8 9 
          // arr[j] = 5
          //1 2 3 7 4 7 7 8 9
	    	else if(arr[j-1] < arr[j] && arr[j] > arr[j+1]) {
	    		pw.println("here");
	    		mis = arr[j];
	    		for(int k = j+1; k <N-1;k++) {
	    			if(arr[k]>=arr[j]){
	                      break;
		    		}
	    			if(arr[k]>arr[j-1]) {
	    				s.add(arr[k]);
	    			}
                  	
	    	}
	    }
	    pw.println(s.size());
	    pw.close();
	}
    }
}
