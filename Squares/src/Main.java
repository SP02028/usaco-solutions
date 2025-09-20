import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[n];  
        int[] right = new int[n]; 
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
            	stack.pop();
            }
            if (!stack.isEmpty()) {
            	left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) stack.pop();
            if (!stack.isEmpty()) right[i] = stack.peek();
            stack.push(i);
        }
        HashMap<Integer, Integer> maxLength = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            maxLength.put(a[i], Math.max(maxLength.getOrDefault(a[i], 0), len));
        }
        List<Integer>[] arr = new ArrayList[n + 2];
        for (int i = 0; i <= n + 1; i++) arr[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maxLength.entrySet()) {
            int v = entry.getKey();
            int len = entry.getValue();
            if (v <= n) {
            	arr[len].add(v); 
            }
        }
        boolean[] array = new boolean[n + 2];
        int[] f = new int[n + 1];
        int mex = 0;
        for (int k = n; k >= 1; k--) {
            for (int v : arr[k]) {
            	array[v] = true;
            }
            while (array[mex]) {
            	mex++;
            }
            f[k] = mex;
        }
        for (int i = 1; i <= n; i++) {
            out.print(f[i] + " ");
        }
        out.println();
        out.flush();
    }
}
