package size100;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class binaryhundred {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long startTime = System.nanoTime();
        try (BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\palsh\\Downloads\\hundred.txt"))) {
            boolean isone = false;
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(r.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }
            

            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == 1) {
                	System.out.println("yes");
                    isone = true;
                    break;
                } else if (arr[mid] < 1) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
           
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}

