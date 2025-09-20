import java.util.*;
import java.io.*;
public class SaC {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter (System.out);
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int num = Integer.parseInt(br.readLine());
			HashSet<Integer> h = new HashSet<Integer>();
			for(int i=1;i*i<=num;i++) {
				h.add(i*i);
			}
			for(int i = 1;i * i*i <=num;i++) {
				h.add(i*i*i);
			}
			pw.println(h.size());
		}
		pw.close();
	}
}
