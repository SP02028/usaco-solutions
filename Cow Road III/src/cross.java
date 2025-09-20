import java.io.*;
import java.util.*;
public class cross {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter("cowqueue.out");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] times = new int[N][2];
		for(int i =0;i<N;i++) {
			StringTokenizer t = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(t.nextToken());
			times[i][1] = Integer.parseInt(t.nextToken());
		}
		Arrays.sort(times, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));
		int time = 0;
		for(int j = 0; j <N; j++) {
			if(times[j][0] < time) {
				time += times[j][1];
			}
			else {
				time = times[j][0] + times[j][1];
			}
		}
		pw.println(time);
		pw.close();
	}

}
