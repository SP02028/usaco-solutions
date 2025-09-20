import java.util.*;
import java.io.*;
public class CD {

	static int[] depth;
	static int[] inTime;
	static int[] outTime;
	static ArrayList<Integer>[] depthNodes;
	static ArrayList<Integer>[] tree;
	static int N;
	static int timer;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		int[] P = new int[N+1];
		StringTokenizer st= new StringTokenizer(br.readLine());
		P[1] = 1; // root has no parent
		for(int i = 2; i <= N; i++) {
		    P[i] = Integer.parseInt(st.nextToken());
		    tree[P[i]].add(i);
		}
		depth = new int[N + 1];
		inTime = new int[N + 1];
		outTime = new int[N + 1];
		depthNodes = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {depthNodes[i] = new ArrayList<>();}
		 timer = 0;
		dfs(1, 0);
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0 ;i  <Q;i++) {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		pw.println(countNodes(a,b));
		}
		pw.close();
	}
	static void dfs(int u, int d) {
	    depth[u] = d;
	    timer++;
	    inTime[u] = timer;
	    depthNodes[d].add(timer);
	    for (int v : tree[u]) {
	        dfs(v, d + 1);
	    }
	    outTime[u] = timer;
	}
	static int countNodes(int U, int D) {
	    if (depth[U] > D) return 0;
	    int l = inTime[U];
	    int r = outTime[U];
	    ArrayList<Integer> times = depthNodes[D]; 
	    int left = lowerBound(times, l);
	    int right = upperBound(times, r);
	    return right - left;
	}
	static int lowerBound(ArrayList<Integer> list, int value) {
	    int low = 0, high = list.size();
	    while (low < high) {
	        int mid = (low + high) / 2;
	        if (list.get(mid) < value) low = mid + 1;
	        else high = mid;
	    }
	    return low;
	}
	static int upperBound(ArrayList<Integer> list, int value) {
	    int low = 0, high = list.size();
	    while (low < high) {
	        int mid = (low + high) / 2;
	        if (list.get(mid) <= value) low = mid + 1;
	        else high = mid;
	    }
	    return low;
	}

}
