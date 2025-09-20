import java.util.*;
import java.io.*;
public class yacp {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0;i <tc;i++) {
			int num = Integer.parseInt(br.readLine());
			 int ans = 1000000000;
			for(int num10 = 0; num10<=2;num10++) {
				for(int num6 = 0; num6 <=4;num6++) {
					for(int num3 = 0; num3<=1;num3++) {
						for(int num1 = 0; num1<=2;num1++) {
							int sum = num10*10 + num6*6 + num3*3+num1*1;
							if((num-sum )%15 ==0 ) {
								int num15s = (num-sum)/15;
								ans = Math.min(ans, num15s+num10+num6+num1+num3);
								
							}
							else {
								continue;
							}
						}
					}
				}
			}
			pw.println(ans);
		}
		pw.close();
	}

}
