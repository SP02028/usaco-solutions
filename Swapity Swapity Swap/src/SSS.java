import java.util.*;
import java.io.*;
public class SSS {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int N = io.nextInt();
		int M = io.nextInt();
		int K = io.nextInt();
		int[] pos = new int[N+1];
		for(int i=1;i<=N;i++) {
		pos[i] = i;
		}
		int[][] ranges = new int[M][2];
		for(int i=0;i<M;i++) {
			ranges[i][0] = io.nextInt();
			ranges[i][1] = io.nextInt();
	}
		for(int[] a: ranges){
			reverse(pos, a[0], a[1]);
		}
		HashMap<Integer, Integer> aoc = new HashMap<Integer, Integer>();
		for(int i=1;i<=N;i++) {
			aoc.put(i, pos[i]); //allgood till here
		}
		int[] finalpos = new int[N+1];
		boolean[] visited = new boolean[N+1];
	
	    for(int i=1;i<=N;i++) {
	    	if(!visited[i]) { //if its in another cycle its not tracking
	    		ArrayList<Integer> cycle = new ArrayList<Integer>();
	    		int curr = i;
	    		while(!visited[curr]) {
	    			visited[curr] = true;
	    			cycle.add(curr);
	    			curr = aoc.get(curr);
	    		}
	    		int cyclelen = cycle.size();
	    		//add line that handles self loops
	    		if(cycle.size()==1) finalpos[i] = i;
	    		for(int j=0; j< cyclelen;j++) {
	    			int ogpos = cycle.get(j);
	    			int finalposidx = (j+K)%cyclelen;
	    			finalpos[ogpos] = cycle.get(finalposidx);
	    		}
	    	}
	    }
	    for(int i=1;i<=N;i++) {
	    	io.println(finalpos[i]);
	    }
	    io.close();
	}	
	public static void reverse (int [] arr, int a, int b) {
	    int left = a;
	    int right = b;
	    while (left < right) {
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;
	        left++;
	        right--;
	    }
	  
	    
	}
	static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
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
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
