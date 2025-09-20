import java.io.*;
import java.util.*;

public class MF {
	public static void main(String[] args) throws IOException {
	//	BufferedReader br = new BufferedReader(new FileReader("factory.in"));
	//	PrintWriter pw = new PrintWriter("factory.out");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(System.out);
		int stationNum = Integer.parseInt(br.readLine());
		int[] outgoing = new int[stationNum];
		for (int w = 0; w < stationNum - 1; w++) {
			StringTokenizer walkway = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(walkway.nextToken()) - 1;
			// We only care about the node the edge starts from b/c we're trying to see which nodes don't have any edges 
			//going from it
			outgoing[s1]++;
		}
		// Check all stations and see if they don't have any outgoing walkways
		List<Integer> noOuts = new ArrayList<>();
		for (int s = 0; s < stationNum; s++) {
			if (outgoing[s] == 0) { //we're trying to see if the node is directed anywhere or not --> can be sink
				noOuts.add(s + 1);
			}
		}
		// If there's !=1 stations without any outs, then we can't find a station
		int root = noOuts.size();
				if(root== 1) {
					root = noOuts.get(0);
				}
				else {
					root =-1;
				}
		pw.println(root);
		pw.close();
	}
}


