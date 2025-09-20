import java.util.*;
import java.io.*;
public class MNR {

	public static void main(String[] args) {
		int n = 8;
		int[][] roads = {{0,1},{5,6},{1,2},{5,7},{2,3},{2,4}};
		System.out.println(maximalNetworkRank(n,roads));
	}
	
	    public static int maximalNetworkRank(int n, int[][] roads) {
	        int max =0;
	        int maxi= -1;
	        int max2 =0;
	        int max2i=-1;
	        int[] freq = new int[n];
	        for(int[] r:roads) {
	        	freq[r[0]]++;
	        	freq[r[1]]++;
	        }
	        int maxsum =0;
	        for (int i = 0; i < n; i++) {
	          for(int j =0;j<n;j++) {
	        	  if(i!=j) {
	        	  int sum =freq[i]+freq[j];
	  //  System.out.println("max: " + max);
	    // System.out.println("maxi " + maxi);
	      // System.out.println("max2: " + max2);
	      // System.out.println("max2i: " + max2i);
	       for(int[] r:roads) {//isnt being checked?
	        	if(r[0]==i &&r[1] == j || r[1] ==i &&r[0]==j) {
	        		sum= sum-1;
	        		System.out.println("Yes with" + i + " and " + j);
	        	}
	        }
	       maxsum = Math.max(maxsum, sum);
	        	  }
	          }
	      }
	    	return maxsum;
	    }
	
}
