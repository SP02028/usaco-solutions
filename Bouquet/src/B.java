import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numflowers=Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[numflowers];
			for(int i =0 ; i <numflowers;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			//do the array traversal
			int maxpetals = Integer.MIN_VALUE; //declare variable for maxpetals
			int currentSum = 0;
            int left = 0;
            int right = 0;
            //instead of using casework like you og planned, use two pointers
            //if the sum is less, move left to the right else move the right one left
            while (right < numflowers) {
                currentSum += arr[right];
                while (currentSum > sum && left <= right) {
                    currentSum -= arr[left];
                    left++;
                    
                }
                maxpetals = Math.max(maxpetals, currentSum);
                right++;
			}
			pw.println(maxpetals);
		}
		pw.close();
	}

}
