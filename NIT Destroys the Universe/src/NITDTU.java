import java.util.*;
import java.io.*;
public class NITDTU {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr =new int[len+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean allzero = true;
			int firstnon0 = -1;
			int secondnon0 = -1;
			int numseq = 0;
			for(int i =1; i <len+1;i++) {
				int curr = Integer.parseInt(st.nextToken());
				if(curr!=0) {
					allzero = false;
				}
				if(curr!=0) {
					if(firstnon0==-1) {
						firstnon0 = i;
					}
				}
				arr[i] = curr;
			}
			for(int i  = len; i >0;i--) {
				if(arr[i] != 0) {
					secondnon0 = i;
					break;
				}
			}
			if(allzero) {
				pw.println(0);
				continue;
			}
			else {
				boolean middle0 = true;
				for(int i = firstnon0+1; i <secondnon0;i++) {
					if(arr[i]==0) {
						middle0 = false;
						break;
					}
				}
				if(middle0) {
					pw.println(1);
					continue;
				}
			}
			pw.println(2);
		}
		pw.close();
	}

}
