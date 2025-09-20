package tenthous;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarytenk {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		long startTime = System.nanoTime();
		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\palsh\\Downloads\\10000.txt"))) {
			boolean isone = true;
			int[] arr = new int[10000];
			for(int i = 0; i < 10000; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			}
			int low = 1;
			int high = arr.length;
			while(low<=high) {
				int mid = low+(high-low)/2;
				if(arr[mid] ==1) {
					isone = true;
				}
				else if (arr[mid] < 1) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
				if(isone==true) {
					System.out.println("yes");
					break;
				}
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);

	}

}
