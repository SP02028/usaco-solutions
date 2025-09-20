import java.io.*;
import java.util.*;

public class StuckInARut2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(r.readLine());
		List<int[]> nCows = new ArrayList<>();
		List<int[]> eCows = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer cow = new StringTokenizer(r.readLine());
			String dir = cow.nextToken();
			int x = Integer.parseInt(cow.nextToken());
			int y = Integer.parseInt(cow.nextToken());
			if (dir.equals("N")) {
				nCows.add(new int[] {x, y, i});
			} else if (dir.equals("E")) {
				eCows.add(new int[] {x, y, i});
			}
		}

		// Sort north cows by x coordinates.
		nCows.sort(Comparator.comparingInt(o -> o[0]));
		// Sort east cows by y coordinates.
		eCows.sort(Comparator.comparingInt(o -> o[1]));

		/*
		 * Stores the position at which cows stop.
		 * (x-coordinate for east cows, y-coordinate for north cows)
		 */
		int[] stopPos = new int[n];
		Arrays.fill(stopPos, -1);
		// check every combination of cows
		for (int[] ncow : nCows) {
			for (int[] ecow : eCows) {
				// Check that the two cows will intersect.
				if (ncow[0] > ecow[0] && ncow[1] < ecow[1]) {
					// Distance they travel before reaching the other cow's
					// line.
					int nTrav = ecow[1] - ncow[1];
					int eTrav = ncow[0] - ecow[0];

					// Check if the north cow blocks the east cow.
					if (nTrav < eTrav && stopPos[ecow[2]] == -1) {
						// # Save the x-coordinate at which the east cow stops
						stopPos[ecow[2]] = ncow[0];
					}

					// Check if the east cow blocks the north cow.
					if (nTrav > eTrav && stopPos[ecow[2]] == -1) {
						// Save the y-coordinate at which the north cow stops
						stopPos[ncow[2]] = ecow[1];
						// At this point we can move on- this cow won't move
						// anymore.
						break;
					}
				}
			}
		}

		// Tracks distance traveled.
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		for (int[] nc : nCows) {
			// A cow eats a finite amount of grass if & only if this value isn't
			// -1.
			if (stopPos[nc[2]] != -1) {
				// Eaten is (stopped position - original position)
				dist[nc[2]] = stopPos[nc[2]] - nc[1];
			}
		}

		for (int[] ec : eCows) {
			if (stopPos[ec[2]] != -1) { dist[ec[2]] = stopPos[ec[2]] - ec[0]; }
		}

		for (int d : dist) { System.out.println(d == -1 ? "Infinity" : d); }
	}
}