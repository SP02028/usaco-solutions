import java.util.*;
import java.io.*;

public class stuckinarut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        List<int[]> northcows = new ArrayList<>();
        List<int[]> eastcows = new ArrayList<>();    
        for (int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            String dir = t.nextToken();
            int xval = Integer.parseInt(t.nextToken());
            int yval = Integer.parseInt(t.nextToken());
            if (dir.equals("N")) {
                northcows.add(new int[] {xval, yval, i});
            } else {
                eastcows.add(new int[] {xval, yval, i});
            }
        }
        // Sort northcows by x-coordinate, eastcows by y-coordinate
        // FIX: In the original code, cows were sorted lexicographically by x and y, 
        // which was not optimal for this problem. Sorting northcows by x and eastcows 
        // by y ensures efficient pairwise comparisons for intersections.
        northcows.sort(Comparator.comparingInt(cow -> cow[0]));
        eastcows.sort(Comparator.comparingInt(cow -> cow[1]));
        // Track the stopping positions (-1 means "Infinity")
        int[] stopPos = new int[N];
        Arrays.fill(stopPos, -1);
        // Check all northcows and eastcows for intersections
        for (int[] ncow : northcows) {
            for (int[] ecow : eastcows) {
                if (ncow[0] > ecow[0] && ncow[1] < ecow[1]) { 
                    // FIX: Improved intersection logic. Previously, intersection checks were scattered 
                    // and overly complex. Now, it’s clearer: only compare north and east cows when they 
                    // intersect based on their relative positions.
                    int nTrav = ecow[1] - ncow[1];
                    int eTrav = ncow[0] - ecow[0];
                    // FIX: The stopping condition logic was reorganized.
                    // ORIGINAL: Logic for deciding which cow stops was less structured and involved 
                    // repeated calculations. The new logic is streamlined for clarity.
                    if (nTrav < eTrav && stopPos[ecow[2]] == -1) {
                        stopPos[ecow[2]] = ncow[0]; // East cow stops
                    } else if (nTrav > eTrav && stopPos[ecow[2]] == -1) {
                        stopPos[ncow[2]] = ecow[1]; // North cow stops
                        break; // North cow won't move anymore
                    }
                }
            }
        }
        // Calculate distances traveled by each cow
        int[] distances = new int[N];
        Arrays.fill(distances, -1);
        // FIX: Introduced a separate array (distances) to calculate how far each cow travels.
        // ORIGINAL: This was previously done through a mix of conditions and map updates, which
        // complicated tracking of distances and correctness.
        for (int[] nc : northcows) {
            if (stopPos[nc[2]] != -1) {
                distances[nc[2]] = stopPos[nc[2]] - nc[1];
            }
        }
        for (int[] ec : eastcows) {
            if (stopPos[ec[2]] != -1) {
                distances[ec[2]] = stopPos[ec[2]] - ec[0];
            }
        }
        for (int d : distances) {
            // FIX: Simplified output handling. 
            // ORIGINAL: Used a HashMap to track results like "Infinity" or distances. 
            // The updated approach directly uses an array for clarity.
           if(d==-1) {
        	   pw.println("Infinity");
           }
           else {
        	   pw.println(d);
           }
        }

        pw.close();
    }
}



