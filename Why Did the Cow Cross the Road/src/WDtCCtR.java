import java.util.*;
import java.io.*;
public class WDtCCtR {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new FileReader("crossroad.in"));
		PrintWriter pw =new PrintWriter("crossroad.out");
		int num = Integer.parseInt(br.readLine());
		int[] occ = new int[11];
		int count  =0;
		Arrays.fill(occ, -1);
		for(int i= 0; i <num;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken());
			int pos= Integer.parseInt(st.nextToken());
			if(occ[cow]!=pos && occ[cow]!=-1) {
				count++;
			}
			occ[cow] = pos;
		}
		pw.println(count);
		pw.close();
	}

}
