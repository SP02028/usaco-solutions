package size1000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class linearthous {
	public static void main(String[] args) throws IOException{
		long startTime = System.nanoTime();
		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\palsh\\Downloads\\1000.txt"))) {
			boolean isone = true;
			for(int i = 0; i < 1000; i++) {
				StringTokenizer st = new StringTokenizer(r.readLine());
				if(Integer.parseInt(st.nextToken())==1) {
					isone = true;
				}
				if(isone == true) {
					System.out.println("yes");
					break;
				}
				else {
					continue;
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
