package daisychains;
import java.util.*;
import java.io.*;
public class DaisyChains {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(read.readLine());
			int[] flowers = new int[n];
			StringTokenizer st = new StringTokenizer(read.readLine());
			for(int i = 0; i < n; i++) {
				flowers[i] = Integer.parseInt(st.nextToken());
			}
			int valid = 0;
			for(int i = 0; i<n; i++) {
				for (int j = i; j <n;j++) {
					double avg =0;
					for(int a = i; a <=j; a++) {
						avg /= j-i+1;
						for(int index = i; index <= j; index++) {
							if(flowers[index] == avg) {
								valid++;
								break;
							}
						}
					}
				}
			}
			System.out.println(valid);
	}

}
