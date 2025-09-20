import java.util.*;
import java.io.*;
public class FT {
    static int N = 0;
    static ArrayList<ArrayList<Integer>> gr = new ArrayList<>(); // changed from static ArrayList<Integer>[] gr;
    static int[] dep;
    static int[] Par;
    static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String cowa = st.nextToken();
		String cowb = st.nextToken();
		HashSet<String> cows = new HashSet<String>();
		HashSet<String> children = new HashSet<String>();
	    Map<String, Integer> nameToId = new HashMap<String, Integer>();
	    Map<Integer, String> idToName = new HashMap<Integer, String>();
		int count = 0;
		for(int i = 0; i <N;i++) {
		 st = new StringTokenizer(br.readLine());
		String cow1 = st.nextToken();
		String cow2 = st.nextToken();
		if (!nameToId.containsKey(cow1)) {
		    nameToId.put(cow1, count);
		    idToName.put(count, cow1);
		    gr.add(new ArrayList<>()); // added
		    count++;
		}
		if (!nameToId.containsKey(cow2)) {
		    nameToId.put(cow2, count);
		    idToName.put(count, cow2);
		    gr.add(new ArrayList<>()); // added
		    count++;
		}
		int mid = nameToId.get(cow1);
		int cid = nameToId.get(cow2);
		cows.add(cow2);
		cows.add(cow1);
		children.add(cow2);
		gr.get(mid).add(cid); // changed from gr[mid].add(cid);
	}
		dep = new int[count]; // moved and sized after count is known
		Par = new int[count];
		Arrays.fill(Par, -1);		
		visited = new boolean[count];
		String root = "";
		for(String c: cows) {
			if(!children.contains(c)) {
				root= c;
			}
		}
		int rootid = nameToId.get(root);
		int cowaid = nameToId.get(cowa);
		int cowbid = nameToId.get(cowb);
		for (int i = 0; i < count; i++) {
		    if (!visited[i]) {
		        dfs(i, i);
		    }
		}		
		int ancestor = LCA(cowaid,cowbid);
		int dist1=dep[cowaid]-dep[rootid];
		int dist2=dep[cowbid]-dep[rootid];
		if (!visited[cowaid] || !visited[cowbid]) {
		    pw.println("NOT RELATED");
		}
		else if(Par[cowaid]==Par[cowbid]) {
			pw.println("SIBLINGS");
		}
		else if(ancestor == cowaid) {
			//mother/grandmother of b is a
			int distatob = dep[cowbid] - dep[cowaid];
			if(distatob == 1) {
				pw.println(cowa + " is the mother of " + cowb);
			}
			else if(distatob == 2) {
				pw.println(cowa + " is the grand-mother of " + cowb);
			}
			else {
				pw.print(cowa + " is the ");
				for(int i =0; i < distatob-2;i++) {
					pw.print("great-");
				}
				pw.println("grandmother of " + cowb);
			}
		}
		else if(ancestor ==cowbid) {
			//mother/grandmother of a is b
			int distbtoa = dep[cowaid] - dep[cowbid];
			if(distbtoa == 1) {
				pw.println(cowb + " is the mother of " + cowa);
			}
			else if(distbtoa == 2) {
				pw.println(cowb + " is the grand-mother of " + cowa);
			}
			else {
				pw.print(cowb + " is the ");
				for(int i =0; i < distbtoa-2;i++) {
					pw.print("great-");
				}
				pw.println("grandmother of " + cowa);
			}
		}
		else if(Par[cowbid] == ancestor) {
			//great aunt of a is b
			pw.print(cowb + " is the ");
			for(int i =0; i < dist1-2;i++) {
				pw.print("great-");
			}
			pw.println("aunt of " + cowa);
		}
		else if(Par[cowaid] == ancestor) {
			//great aunt of b is a
			pw.print(cowa + " is the ");
			for(int i =0; i < dist2-2;i++) {
				pw.print("great-");
			}
			pw.println("aunt of " + cowb);
		}
		else {
			pw.println("COUSINS");
		}
		pw.close();
	}
	  static void dfs(int cur, int par) {
		  visited[cur] = true;
	        Par[cur] = par;
	        dep[cur] = dep[par] + 1;
	        for (int x : gr.get(cur)) { // changed from gr[cur]
	            if (x != par) {
	                dfs(x, cur);
	            }
	        }
	    }
	    static int LCA(int u, int v) {
	        if (u == v) return u;
	        if (dep[u] < dep[v]){
	            int temp = u;
	            u = v;
	            v = temp;
	        }
	        // depth of u is more than depth of v
	        int diff = dep[u] - dep[v];
	        // depth of both nodes same
	        while (diff-- != 0) {
	            u = Par[u];
	        }
	        // until they are equal nodes keep climbing
	        while (u != v) {
	            u = Par[u];
	            v = Par[v];
	        }
	        return u;
	    }
}
