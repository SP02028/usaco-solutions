import java.util.*;
import java.io.*;

public class FJFP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] nhojperm = new int[num - 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num - 1; i++) {
                nhojperm[i] = Integer.parseInt(st.nextToken());
            }
            if (nhojperm.length == 1) {
                if (nhojperm[0] == num - 1) {
                    for (int i = 1; i <= num; i++) {
                        if(i!=1) {
                    	pw.print(" " + i);
                        }
                        else{
                        	pw.print(i);
                        }
                    }
                    pw.println();
                    continue;
                } else {
                    pw.println(-1);
                    continue;
                }
            }
            int[] fjperm = new int[num];
            List<List<Integer>> permutations = generatePermutations(num);
            boolean found = false;

            for (List<Integer> perm : permutations) {
                int[] temp = new int[num - 1];
                List<Integer> tempPerm = new ArrayList<>(perm);
                for (int i = 0; i < num - 1; i++) {
                    if (tempPerm.get(0) > tempPerm.get(tempPerm.size() - 1)) {
                        temp[i] = tempPerm.get(1);
                        tempPerm.remove(0); 
                    } else {
                        temp[i] = tempPerm.get(tempPerm.size() - 2);
                        tempPerm.remove(tempPerm.size() - 1);
                    }
                }
                if (Arrays.equals(temp, nhojperm)) {
                    fjperm = perm.stream().mapToInt(Integer::intValue).toArray();
                    found = true;
                    break;
                }
            }
            if (!found) {
                pw.println(-1);
            } else {
            	int x = 0;
                for (int f : fjperm) {
                    if(x!=0) {
                    	pw.print(" " + f );
                    }
                    else {
                    	pw.print(f);
                    }
                    x++;
                }
                pw.println();
            }
        }
        pw.close();
    }
    public static List<List<Integer>> generatePermutations(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        permute(nums, 0, result);
        return result;
    }
    private static void permute(List<Integer> nums, int l, List<List<Integer>> result) {
        if (l == nums.size() - 1) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = l; i < nums.size(); i++) {
                swap(nums, l, i);
                permute(nums, l + 1, result);
                swap(nums, l, i);
            }
        }
    }
    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
