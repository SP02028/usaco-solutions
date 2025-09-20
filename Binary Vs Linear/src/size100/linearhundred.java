package size100;
import java.util.*;
import java.io.*;
public class linearhundred {

	public static void main(String[] args) throws IOException{
		long startTime = System.nanoTime();
		try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\palsh\\Downloads\\hundred.txt"))) {
			boolean isone = true;
			for(int i = 0; i < 100; i++) {
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