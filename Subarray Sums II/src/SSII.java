import java.util.*;
import java.io.*;
public class SSII {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i <N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long prefixSum = 0;
		long answer = 0;
		Map<Long, Integer> sums = new HashMap<>();
		sums.put((long)0, 1);
		for (int a : arr) {
			prefixSum += a; //we're just incrementing a variable to keep the sum till that point
			if (sums.containsKey(prefixSum - x)) {  // check if a subarray exists with prefix sum of prefixSum-x
				answer += sums.get(prefixSum - x);  //add the number of those subarrays to our answer
			}
			// Increment the amount of prefix sums with a sum of prefix_sum
			if (!sums.containsKey(prefixSum)) {  // not yet in map, so add it
				sums.put(prefixSum, 1);
			} else {  // already in map, add one to it
				sums.put(prefixSum, sums.get(prefixSum) + 1);
			}
		}
		pw.println(answer);
		pw.close();
	}

}
