import java.io.*;
import java.util.*;
public class CE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		PrintWriter pw = new PrintWriter("evolution.out");
		int n = Integer.parseInt(br.readLine());
		List<Set<String>> cows = new ArrayList<>();
		Set<String> allchars = new HashSet<>();
		for (int c = 0; c < n; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numchars = Integer.parseInt(st.nextToken());
			Set<String> currCow = new HashSet<>();
			for (int i = 0; i < numchars; i++) { 
				currCow.add(st.nextToken()); 
				}
			allchars.addAll(currCow);
			cows.add(currCow);
		}
		List<String> allChars = new ArrayList<>(allchars);
		// Iterate over every pair of characteristics and check if the tree is
		// evolutionarily proper relative to that pair
		for (int a = 0; a < allChars.size(); a++) {
			for (int b = a + 1; b < allChars.size(); b++) {
				boolean both = false, onlyA = false, onlyB = false;
				for (Set<String> c : cows) {
					boolean hasA = c.contains(allChars.get(a));
					boolean hasB = c.contains(allChars.get(b));
					if (hasA && hasB) {
						both = true;
					} else if (hasA && !hasB) {
						onlyA = true;
					} else if (!hasA && hasB) {
						onlyB = true;
					}
				}
				/* If we find a cow which has the characteristic a, another cow which has the characteristic b, and
				 * another cow with both characteristics a and b, then the tree isn't evolutionarily proper. */
				if (onlyA && onlyB && both) {
					pw.println("no");
					pw.close();
				}
			}
		}
		pw.println("yes");
		pw.close();
	}
}