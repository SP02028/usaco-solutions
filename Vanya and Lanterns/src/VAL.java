import java.util.*;
import java.io.*;
public class VAL {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		ArrayList<Integer> lanterns = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			lanterns.add(a);
		}
		Collections.sort(lanterns);
		int diste1 = lanterns.get(0)-0;
		int diste2 = len-lanterns.get((int) N-1);
		double realdist = -1;
		for(int i = 0; i <N-1;i++) {
			double currdist= lanterns.get(i+1)-lanterns.get(i);
			realdist = Math.max(currdist/2, realdist);
		}

		pw.println(Math.max(realdist, Math.max(diste1, diste2)));
		pw.close();
	}

}
