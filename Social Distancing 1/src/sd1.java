import java.util.*;
import java.io.*;

public class sd1 {	
	public static void main(String[] args) throws Exception {
		int n =0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		ArrayList<Integer> str = new ArrayList<Integer>();
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i) == '1') 
				str.add(i);
		int low = 1;
		int high = n-1; //will be changed		
		// Answer could never be higher than the current gap between two cows.
		for (int i=1; i<str.size(); i++) 
			{
			high = Math.min(str.get(i)-str.get(i-1), high);
			}		
		// Now, binary search the result.
		while (low < high) {
			int mid = (low+high+1)/2;
			if (pos(mid,str, n))
				low = mid;
			else
				high = mid-1;
		}
		// Output result.
		pw.println(low);
		pw.close();		
	}
	// Returns true if we can place 2 cows without getting any cows closer than d.
	public static boolean pos(int d, ArrayList<Integer> str, int n) {
		if (str.size() == 0) {
			return d < n;
		}
		// See how many can be placed in beginning and end.
		int placed = str.get(0)/d + (n-1-str.get(str.size()-1))/d;	
		// Try everything in the middle.
		for (int i=0; i<str.size()-1; i++) 
			placed += Math.max(0,((str.get(i+1) - str.get(i))/d - 1));
		return placed >= 2;
	}
}
