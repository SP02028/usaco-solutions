import java.util.*;
import java.io.*;
public class ad {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringTokenizer s = new StringTokenizer(br.readLine());
		int[] arr= new int[N];
		int sum  =0;
		for(int i =0; i<N;i++) {
			arr[i]=Integer.parseInt(s.nextToken());
			sum += arr[i];
		}
        List<List<Integer>> subsets = getSubsets(arr);
        ArrayList<Integer> differences = new ArrayList<>();
        for(List<Integer> sub: subsets) {
        	int currsum =0;
        	int othersum = 0;
        	for(int u:sub) {
        		currsum+=u;
        	}
        	othersum = sum-currsum;
        	differences.add(Math.abs(currsum-othersum));
        }
        Collections.sort(differences);
        pw.println(differences.get(0));
        pw.close();
	}

	public static List<List<Integer>> getSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    generateSubsets(0, nums, new ArrayList<>(), subsets);
	    return subsets;
	}

	private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
	    if (index == nums.length) {
	        subsets.add(new ArrayList<>(current));
	        return;
	    }
	    // Include the current element
	    current.add(nums[index]);
	    generateSubsets(index + 1, nums, current, subsets);
	    // Exclude the current element
	    current.remove(current.size() - 1);
	    generateSubsets(index + 1, nums, current, subsets);
	}

}
