import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int[] counts=new int[N+1];
		for(int i=1;i<N+1;i++) {
			counts[i] = Integer.parseInt(st.nextToken());
		}
		int K= Integer.parseInt(br.readLine());
	    int[][] recipes = new int[N+1][];
		for(int i =1; i<=K;i++) {
			st= new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			int[] arr=new int[len];
			for(int j =0;j<len;j++) {
				arr[j] =Integer.parseInt(st.nextToken());
			}
			recipes[index] = arr;
		}
		//input has been read
		//iterate backwards, translate wanted elements into needed 
		//elements until you can construct all needed elements
		int count=0;
		while (true) {
			int[] need = new int[N+1];
			need[N]++;
			boolean possible = true;
			for(int i = N; i >0;i--) {
				if(need[i]<=counts[i]) {
					counts[i]-=need[i];
					continue;
				}
				if(recipes[i] ==null) {
					possible = false;
					break;
				}
				need[i]-=Math.min(need[i], counts[i]);
				counts[i]-=Math.min(need[i], counts[i]);
				for(int r:recipes[i]) {
					need[r] +=need[i];
				}
			}
			if(possible) {
				count++;
			}
			else {
				break;
			}
		}
		pw.println(count);
		pw.close();
	}

}
