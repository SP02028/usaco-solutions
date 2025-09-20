import java.util.*;
import java.io.*;
public class CEA {
	static List<Integer>[] graph;
	static int[] subtreeSize;
	static 		int countedges =0;

	public static void main(String[] args) throws IOException{
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int numnodes = Integer.parseInt(br.readLine());
		subtreeSize = new int[numnodes+1];
		graph = new ArrayList[numnodes+1];
		for(int i =1;i<=numnodes;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		StringTokenizer st;
		for(int i = 0; i <numnodes-1;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		if(numnodes%2 == 1) {
			pw.println(-1);
			pw.close();
			return;
		}
		dfs(2,1);
		pw.println(countedges);
		pw.close();
	}
	  static int dfs(int node, int par) {
	        int size = 1;
	        for(int nbr:graph[node]) {
	        	if(nbr!=par) {
	        		int childSize = dfs(nbr, node);
	        		if(childSize%2==0) {
	        			countedges++;
	        		}
	        		else {
	        			size+= childSize;
	        		}
	        	}
	        }
	        subtreeSize[node]=size;
	        return size;
}
}
