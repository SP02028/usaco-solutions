import java.util.*;
import java.io.*;
public class GoR {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int numranges=Integer.parseInt(br.readLine());
			HashMap<int[], Integer> rangeval = new HashMap<int[], Integer>();
			for(int i=0;i<numranges;i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				int[] temp = new int[2];
				temp[0] = Integer.parseInt(st.nextToken());
				temp[1] = Integer.parseInt(st.nextToken());
				rangeval.put(temp, 0);
			}
			Set<int[]> ranges = rangeval.keySet();
			for(int[] r:ranges) {
				pw.print(r[0]+" " + r[1] + " " + check(ranges,r));
				pw.println();
			}
			pw.println();
		}
		pw.close();
	}
	//method to find d that results in ranges that are in the set
	public static int check(Set<int[]> ranges, int[] range) {
		int l = range[0];
		int r = range[1];
		if(range[0]==range[1]) {
			return range[0];
		}
		boolean lexists = true;
		boolean rexists = true;
		for(int i = l; i <r;i++) {
			if(l<=i-1) {
				int[] temp = {i-1,l};				
				boolean broken = false;
				for(int[] arr:ranges) {
					for(int a:arr) {
					//	System.out.print(a +" ");
					}
				//	System.out.println("array being compared to:");
				//	System.out.println(temp[0]+ " " + temp[1]);
					if(arr.equals(temp)) {
						broken=true;
						break;
					}
				}
				if(!broken) {
					lexists = false;
				}
			}
			if(r>=i+1) {
				int[] temp = {i+1,r};				
				boolean broken = false;
				for(int[] arr:ranges) {
					if(arr.equals(temp)) {
						broken=true;
						break;
					}
				}
				if(!broken) {
					rexists = false;
				}
			}
			if(lexists||rexists) {
				return i;
			}
		}
		return 0;
	}
	//method to return ranges for given d and initial range
}
