import java.io.*;
import java.util.*;
public class MTF {
    public static void main(String[] args) throws IOException {
     //   BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
      //  PrintWriter pw = new PrintWriter("mowing.out");
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        char[] directions = new char[n];
        int[] steps = new int[n];
        for (int s = 0; s < n; s++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directions[s] = st.nextToken().charAt(0);
            steps[s] = Integer.parseInt(st.nextToken());
        }
        int currX = 0 ;
        int currY = 0;
        // Use a HashMap to track visits and the time
        Map<String, Integer> visits = new HashMap<>();
        visits.put(currX + "," + currY, 0); // Mark starting position
        int time = 0;
        int max = Integer.MAX_VALUE;
        for (int s = 0; s < n; s++) {
            char dir = directions[s];
            int numSteps = steps[s];
            for (int i = 0; i < numSteps; i++) {
                // Update current position based on direction
                switch (dir) {
                    case 'N': currY++; break;
                    case 'S': currY--; break;
                    case 'E': currX++; break;
                    case 'W': currX--; break;
                }
                time++;
                String position = currX + "," + currY;
                // Check if FJ has been to this patch of grass before
                if (visits.containsKey(position)) {
                    max = Math.min(max, time - visits.get(position));
                }
                // Update the time FJ visited this patch of grass
                visits.put(position, time);
            }
        }
        // Output -1 if FJ has never gone back to the same patch of grass
        if(max ==Integer.MAX_VALUE) {
        	pw.println(-1);
        }
        else {
        	pw.println(max);
        }
        pw.close();
    }
}
