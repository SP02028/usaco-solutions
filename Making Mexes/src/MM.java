import java.util.*;
import java.io.*;
public class MM {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer,Integer> freq =  new HashMap<Integer,Integer>();
		for(int num:arr) {
			freq.put(num, freq.getOrDefault(num,0)+1);
		}
		for(int i =0 ; i <len;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int num = 0; num <=len;num++) {
			int numadd = 0;
			int numrem = 0;
			for(int i = 0; i <num;i++) {
				if(freq.containsKey(i)) {
					continue;
				}
			}
		for(int i = 0; i <num;i++) {
			if(!freq.containsKey(i)) {
				numadd++;
			}
		}
			for(int key : freq.keySet()) {
				if(key>=num) {
					numrem +=freq.get(key);
				}
			}
			pw.println(numadd+numrem);
		/*	
		 * approach passed one tc.. the sample
		 * Arrays.sort(arr);
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int n:arr) {
			if(n>=0 && n <num) {
				hs.add(n);
			}
		}
		int mod = 0;
		for(int i = 0; i <num;i++) {
			if(!hs.contains(i)) {
				mod++;
			}
		}
		boolean pres = false;
		for(int n:arr) {
			if(n==num) {
				pres = true;
				break;
			}
		}
		if(pres==true) {
			int count= 0;
			for(int a:arr) {
				if(a==num) {
					count++;
				}
			}
			pw.println(count);
		}
		else {
			pw.println(mod);
		}
		*/
		/*	int minmod= 0;
			int currsum = 0;
			int j = 0;
			for(int i =1; i <num;i++) {
				while(j<num && arr[j]<i) {
					currsum +=j;
					j++;
				}
				if(currsum<i) {
					minmod++;
					currsum+=num;
				}
			}
			pw.println(minmod);
			*/
		}
		pw.close();
	}
	
}
