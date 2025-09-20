import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	     PrintWriter pw = new PrintWriter(System.out);
	     StringTokenizer st = new StringTokenizer(r.readLine());
	     int ib = Integer.parseInt(st.nextToken());
	     int cb = Integer.parseInt(st.nextToken());
	     StringTokenizer t = new StringTokenizer(r.readLine());
	     int isilv = Integer.parseInt(t.nextToken());
	     int csilv = Integer.parseInt(t.nextToken());
	     StringTokenizer s = new StringTokenizer(r.readLine());
	     int igold = Integer.parseInt(s.nextToken());
	     int cgold = Integer.parseInt(s.nextToken());
	     StringTokenizer str = new StringTokenizer(r.readLine());
	     int iplat = Integer.parseInt(str.nextToken());
	     int cplat = Integer.parseInt(str.nextToken());
	     int pplat = cplat - iplat;
	     int pgold = cplat+cgold-igold-iplat;
	     int psilv = csilv + cgold+ cplat-igold-isilv-iplat;
	     pw.println(psilv);
	     pw.println(pgold);
	     pw.println(pplat);
	     pw.close();
	}

}
