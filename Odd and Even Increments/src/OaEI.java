import java.util.*;
import java.io.*;
public class OaEI {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc=  Integer.parseInt(br.readLine());
		while(tc-->0) {
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			int[] arr= new int[len];
			for(int i =0;i<len;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(len==1) {
				pw.println("YES");
				continue;
			}
			boolean oddpar = arr[1]%2 ==0; 
			boolean evenpar = arr[0]%2 ==0; //true even false odd
			boolean valid = true;
			for(int i=0;i<len;i++) {
				if(i%2==0) {
					if((arr[i]%2==0) != evenpar) {
						pw.println("NO");
						valid = false;
						break;
					}
				}else {
					if((arr[i]%2==0) != oddpar) {
						pw.println("NO");
						valid = false;
						break;
					}
				}
			}
			if(valid) {
			pw.println("YES");
			}
		}
		pw.close();
	}

}
