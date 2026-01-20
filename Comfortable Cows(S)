import java.util.*;
import java.io.*;

public class CC {
	static int[][] grid = new int[3001][3001]; //grid is 0 indexed
	static int currcount = 0;
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.nextInt();
		Queue<int[]> q = new LinkedList<>();

		for(int i=0;i<n;i++) {
			int a = io.nextInt()+1000;
			int b = io.nextInt()+1000;
			
			if(grid[a][b] == 2) {
				currcount--;
			}
			grid[a][b] = 1;

			q.add(new int[] {a,b});
			q.add(new int[] {a+1,b});
			q.add(new int[] {a-1,b});
			q.add(new int[] {a,b+1});
			q.add(new int[] {a,b-1});

			while(!q.isEmpty()) {
				int[] temp = q.poll();
				if(grid[temp[0]][temp[1]] > 0 && comfortable(temp[0], temp[1])) {
					int[] pos = unfilled(temp[0], temp[1]);
					grid[pos[0]][pos[1]] = 2;
					currcount++;
					
					q.add(new int[]{pos[0], pos[1]});
					q.add(new int[]{pos[0]+1, pos[1]});
					q.add(new int[]{pos[0]-1, pos[1]});
					q.add(new int[]{pos[0], pos[1]+1});
					q.add(new int[]{pos[0], pos[1]-1});
				}
			}
			io.println(currcount);
		}
		io.close();
	}

	public static int[] unfilled(int a, int b) {
		if(grid[a+1][b] == 0) return new int[] {a+1,b};
		if(grid[a-1][b] == 0) return new int[] {a-1,b};
		if(grid[a][b+1] == 0) return new int[] {a,b+1};
		return new int[] {a,b-1};
	}

	public static boolean comfortable(int a, int b) {
		int count = 0;
		if(grid[a+1][b] > 0) count++;
		if(grid[a-1][b] > 0) count++;
		if(grid[a][b+1] > 0) count++;
		if(grid[a][b-1] > 0) count++;
		return count == 3;
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
	}
}
