import java.util.*;
import java.io.*;
public class CB {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter("cbarn.out");
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		for(int i = 0; i <len;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//input read
		int min = Integer.MAX_VALUE;
		for(int finalpos = 0; finalpos< len; finalpos++) {
			int[] temp = Arrays.copyOf(arr, len);
			//reverse fill
			//find the energy required to get to the closest nonzero val before
			int count = 0;
			for(int  j = finalpos; j >=0; j--) {
				int[] a = findclosestnonzerobefore(j,temp);
				temp[a[0]]-=1;
				count +=a[1];
			}
			for(int j = len-1; j >finalpos; j--) {
				int[] a = findclosestnonzerobefore(j,temp);
				temp[a[0]]-=1;
				count +=a[1];
			}
			min = Math.min(count, min);
		}
		pw.println(min);
		pw.close();
	}
	public static int[] findclosestnonzerobefore(int pos, int[] arr) {
		int closest= pos;
		int count = 0;
		while(arr[closest]==0) {
			closest--;
			if(closest<0) {
				closest = arr.length-1;
			}
			count++;
		}
		int[] ans = {closest, (int) Math.pow(count, 2)};
		return ans;
	}

}
