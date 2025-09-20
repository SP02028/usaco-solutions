import java.io.*;
import java.util.*;
public class MO {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] hierarchy = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			hierarchy[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		int[] order = new int[n];
		Arrays.fill(order, -1);
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken()) - 1;
			int pos = Integer.parseInt(st.nextToken()) - 1;
			order[pos] = cow;
			// already fixed
			if (cow == 0) {
				pw.println(pos + 1);
				pw.close();
			}
		}
		for (int i = 0; i < n; i++) {
			if (order[i] == -1) {
				// try placing cow 1 at pos i
				order[i] = 0;
				if (check(order, hierarchy)) {
					pw.println(i + 1);
					break;
				}
				order[i] = -1;
			}
		}
		pw.close();
	}
	//check if possible to fill remaining pos w/ hiearchy
	public static boolean check(int[] order, int[] hierarchy) {
		order = order.clone();
		int[] cowpos = new int[order.length];
		Arrays.fill(cowpos, -1);
		for (int i = 0; i < order.length; i++) {
			if (order[i] != -1) {
				cowpos[order[i]] = i; 
				}
		}
		int index = 0;
		for (int i = 0; i < order.length && index < hierarchy.length; i++) {
			if (cowpos[hierarchy[index]] != -1) {
				// we know the next cow has to be in front of it
				if (i > cowpos[hierarchy[index]]) {
					return false; 
					}
				i = cowpos[hierarchy[index]];
				index++;
			}
			else {
				while (i < order.length && order[i] != -1) {
					i++; 
					}
				// run out of places
				if (i == order.length) { 
					return false; 
					}
				order[i] = hierarchy[index];
				cowpos[hierarchy[index]] = i;
				index++;
			}
		}
		return true;
	}
}