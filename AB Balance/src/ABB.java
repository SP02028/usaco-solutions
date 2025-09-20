import java.util.*;
import java.io.*;
public class ABB {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++){
		String str = br.readLine();
		String newstr="";
		if(str.charAt(0)!=str.charAt(str.length()-1)) {
			newstr +=str.charAt(str.length()-1);
			for(int i = 1; i <str.length();i++) {
				newstr+=str.charAt(i);
			}
		}
		else {
			pw.println(str);
			continue;
		}
		pw.println(newstr);
		}
		pw.close();
	}

}
