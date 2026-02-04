import java.util.*;
import java.io.*;
public class FaR {
	//I'm going to use  integer for convinience and also so that it's further distinguishing upper/lowercase by using ascii values of letters
	public static void main(String[] args) {
		Kattio io =new Kattio();
		int T =io.nextInt();
	while(T-->0) {
		String str = io.next();
		String str2 = io.next();
		
		if (str.equals(str2)) {
			io.println(0);
			continue;
		}
		
		List<Integer>[] adj = new ArrayList[60]; //its probably a good idea to make sure all your letters... have indices?
		for(int i = 0; i < 52; i++) { 
		    adj[i] = new ArrayList<Integer>(); 
		}
		boolean[] ends = new boolean[52];
		boolean pos = true;
		for(int i = 0; i < str.length(); i++) {
		    char sChar = str.charAt(i);
		    char dChar = str2.charAt(i);
		    // Refactored indexing logic
		    int source;
		    if (sChar <= 'Z') {
		        source = sChar - 'A';      
		    } else {
		        source = sChar - 'a' + 26; 
		    }
		    int dest;
		    if (dChar <= 'Z') {
		        dest = dChar - 'A';
		    } else {
		        dest = dChar - 'a' + 26;
		    }
		    
		    ends[dest] = true;
		    
		    if(adj[source].size() > 0 && adj[source].get(0) != dest) {
		        pos = false;
		    }
		    if(adj[source].size() == 0) {
		        adj[source].add(dest);
		    }
		    
		    if(adj[source].size() > 1) { 
		        pos = false; 
		        break; 
		    }
		}
		
		int cnt = 0;
		for (int i = 0; i < 52; i++) if (ends[i]) cnt++;
		if (cnt == 52) pos = false;
		
		if(!pos) {
			io.println(-1); //this works fine
			continue;
		}
		//now we check how many nodes transform
		//this does NOT work fine
		int count = 0;
		int[] inDeg = new int[52];
		for (int i = 0; i < 52; i++) {
			if (adj[i].size() > 0 && adj[i].get(0) != i) {
				inDeg[adj[i].get(0)]++;
				count++;
			}
		}
		
		int[] visited = new int[52];
		for(int i=0;i<52;i++) {
			if (visited[i]!=0) continue;
			int node = i;
			while(node!=-1 && visited[node]==0) {
				visited[node]=i+1;
				if(adj[node].size()==0) {
					node = -1;
				} else {
					node = adj[node].get(0);
				}
			}
			// cycle check:
            // node != -1  => we didn't walk off into undefined
            // node != adj[node] => cycle length > 1 (ignore self-loop)
            // vis[node] == i+1 => back-edge into current walk => a cycle
			if(node!=-1 && adj[node].size() > 0 && node!=adj[node].get(0) && visited[node]==i+1) {
				int start = node;
				boolean pass = false;
				do {
					visited[node] = 2;
					if(inDeg[node] > 1) pass = true;
					node = adj[node].get(0);
				} while(node != start);
				if(!pass) count++;
			}
		}
		
		io.println(count);
	}
io.close();
	}
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}
