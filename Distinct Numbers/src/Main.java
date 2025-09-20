import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		 BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	     PrintWriter pw = new PrintWriter(System.out);
	     StringTokenizer st = new StringTokenizer(r.readLine());
	     int n = Integer.parseInt(st.nextToken());
	     HashSet<Integer> s = new HashSet<Integer>();
	     StringTokenizer t = new StringTokenizer(r.readLine());
	     for(int i =0;i<n;i++) {
	    	 s.add(Integer.parseInt(t.nextToken()));
	     }
	     pw.println(s.size());
	     pw.close();   
	}

}
