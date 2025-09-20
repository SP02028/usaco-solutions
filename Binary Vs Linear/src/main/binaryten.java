package main;
import java.util.*;
import java.io.*;
public class binaryten {

	public static void main(String[] args) throws IOException{
		long startTime = System.nanoTime();
		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\palsh\\Downloads\\randomNumbers2.txt"))) {
			boolean isone = true;
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++) {
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