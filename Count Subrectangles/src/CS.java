import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
public class CS {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int cols = io.nextInt();
		int rows = io.nextInt();
		int area =io.nextInt();
		int[] column = new int[cols];
		int[] row = new int[rows];
		int[][] matrix = new int[rows+1][cols+1];
		int[][] pfx = new int[rows+1][cols+1];
		for(int i =0;i<cols;i++) {
			column[i] = io.nextInt();
		}
		for(int i = 0; i <rows;i++) {
			row[i]= io.nextInt();
		}
		//construct matrix
		for(int i = 1; i <=rows;i++) {
			for(int j =1;j<=cols;j++) {
				matrix[i][j] = row[i] * column[j];
			}
		}
		//prefix sum on matrix
		
		//generate all possible rectangles w/ area A and compute how many are valid???
		int count = 0;
		
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
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(r.readLine()); }
                catch (IOException e) { throw new RuntimeException(e); }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
