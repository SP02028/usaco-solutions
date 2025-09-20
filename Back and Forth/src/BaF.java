import java.util.*;
import java.io.*;
public class BaF {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		List<Integer> barna = new ArrayList<>();
		List<Integer> barnb = new ArrayList<>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i =0;i<10;i++) {
			barna.add(Integer.parseInt(st.nextToken()));
		}
		 st= new StringTokenizer(br.readLine());
		for(int i =0;i<10;i++) {
			barnb.add(Integer.parseInt(st.nextToken()));
		}
		//call recursive function to figure out every possible 
		Set<Integer> allvals = possiblevals(0, 1000, barna, 1000, barnb);
		pw.println(allvals.size());
		pw.close();
	}
	public static Set<Integer> possiblevals(int day, int aTank, List<Integer> aBuckets, int bTank, List<Integer> bBuckets) {
        // Last day, return a set with the current aTank value.
        if (day == 4) {
            Set<Integer> result = new HashSet<>();
            result.add(aTank);
            return result;
        }

        // Create a set to collect all possible values.
        Set<Integer> possibleValues = new HashSet<>();
        // This transfers every possible bucket from barn x to barn y.
        for (int i = 0; i < aBuckets.size(); i++) {
            // Bucket to transfer.
            int t = aBuckets.get(i);
            // Creates a new copy of available buckets, and transfers the ith one.
            List<Integer> newA = new ArrayList<>(aBuckets);
            newA.remove(i);
            List<Integer> newB = new ArrayList<>(bBuckets);
            newB.add(t);
            // Recursively call the function and collect all results.
            //backtracks to here whenever the basecase is called?
            Set<Integer> ans = possiblevals(day + 1, bTank + t, newB, aTank - t, newA);
            //if we have reached day 4 you add a final count to possible values else you just keep running it until you reach day 4 and dont add anything
            possibleValues.addAll(ans);
        }
        return possibleValues;
    }
}
