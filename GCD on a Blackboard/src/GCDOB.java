import java.util.*;
import java.io.*;
public class GCDOB {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr=new int[len];
		for(int i = 0; i <len;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] gcdbefore = new int[len];
		int[] gcdafter = new int[len];
		gcdbefore[0] = arr[0];
		gcdafter[len - 1] = arr[len - 1]; // reverse compute the gcds
		for(int i =1 ; i <len;i++) {
			gcdbefore[i] = gcd(gcdbefore[i-1], arr[i]); //already computed values before so we use them
		}
		for(int i =len-2 ; i >=0;i--) {
			gcdafter[i] = gcd(gcdafter[i+1], arr[i]); //already computed values after, so we use them
		}
		int ans = -1;
		for(int i =0; i <len;i++) {
			if(i==0) {
				 ans = Math.max(ans, gcdafter[1]);
			}
			else	if(i==len-1) {
				ans = Math.max(ans, gcdbefore[len - 2]);
			}
			else {
			ans = Math.max(gcd(gcdbefore[i-1], gcdafter[i+1]), ans);
			}
		}
		pw.println(ans);
		pw.close();
	}
	static int gcd(int a, int b) { 
		return b == 0 ? a : gcd(b, a % b); 
		}
}
