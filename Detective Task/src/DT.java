import java.util.*;
import java.io.*;
public class DT {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			String str = br.readLine();
			int pos0 = str.length()-1;
			int pos1 = 0;
			for(int i =0; i<str.length();i++) {
				if(str.charAt(i)=='0') {
					pos0 = Math.min(pos0, i);
				//	pw.println("Right0" +  pos0);
				}else if(str.charAt(i)=='1') {
					pos1 = Math.max(pos1, i);
					//pw.println("Left1" + pos1);
				}
			}
			pw.println(pos0-pos1+1);
		}
		pw.close();
	}

}
