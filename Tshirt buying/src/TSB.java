import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
public class TSB {

	public static void main(String[] args) throws IOException{
		Kattio io = new Kattio();
		int t = io.nextInt();
		//at max 200000
		long[][] temp = new long[t][3];
		//stores price, front, back
		for(int i = 0; i <t;i++) {
			temp[i][0] = io.nextLong();
		}
		for(int i = 0 ; i < t;i++) {
			temp[i][1] = io.nextLong();
		}
		for(int i = 0 ; i < t;i++) {
			temp[i][2] = io.nextLong();
		}
		ArrayList<Long[]> one = new ArrayList<Long[]>();
		ArrayList<Long[]> two = new ArrayList<Long[]>();
		ArrayList<Long[]> three = new ArrayList<Long[]>();

		for(int i = 0;i < t;i++) {
			if(temp[i][1]==1 || temp[i][2]==1) {
				one.add(new Long[] { temp[i][0], (long) i});
			}
			if(temp[i][1]==2 || temp[i][2]==2) {
				two.add(new Long[] { temp[i][0], (long) i});
			}
			if(temp[i][1]==3 || temp[i][2]==3) {
				three.add(new Long[] { temp[i][0], (long) i});
			}
		}
		Collections.sort(one, new Comparator<Long[]>() {
            @Override
            public int compare(Long[] arr1, Long[] arr2) {
                return arr1[0].compareTo(arr2[0]);
            }
        });
		Collections.sort(two, new Comparator<Long[]>() {
            @Override
            public int compare(Long[] arr1, Long[] arr2) {
                return arr1[0].compareTo(arr2[0]);
            }
        });
		Collections.sort(three, new Comparator<Long[]>() {
            @Override
            public int compare(Long[] arr1, Long[] arr2) {
                return arr1[0].compareTo(arr2[0]);
            }
        });
		int curr1 = 0;
		int curr2 = 0;
		int curr3 = 0;
		HashSet<Long> used = new HashSet<Long>();
		int p = io.nextInt();
		for(int i = 0; i <p;i++) {
			int color = io.nextInt();
			if (color == 1) {
			    while (curr1 < one.size() && used.contains(one.get(curr1)[1])) {
			        curr1++;
			    }
			    if (curr1 == one.size()) {
			        io.print(-1 + " ");
			    } else {
			        io.print(one.get(curr1)[0] + " ");
			        used.add(one.get(curr1)[1]);
			    }
			}
			else if (color == 2) {
			    while (curr2 < two.size() && used.contains(two.get(curr2)[1])) {
			        curr2++;
			    }
			    if (curr2 == two.size()) {
			        io.print(-1 + " ");
			    } else {
			        io.print(two.get(curr2)[0] + " ");
			        used.add(two.get(curr2)[1]);
			    }
			}
			else {
			    while (curr3 < three.size() && used.contains(three.get(curr3)[1])) {
			        curr3++;
			    }
			    if (curr3 == three.size()) {
			        io.print(-1 + " ");
			    } else {
			        io.print(three.get(curr3)[0] + " ");
			        used.add(three.get(curr3)[1]);
			    }
			}

			
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
	        public Kattio(String problemName) throws IOException {
	            super(problemName + ".out");
	            r = new BufferedReader(new FileReader(problemName + ".in"));
	        }

	        public String next() {
	            try {
	                while (st == null || !st.hasMoreTokens())
	                    st = new StringTokenizer(r.readLine());
	                return st.nextToken();
	            } catch (Exception e) {}
	            return null;
	        }
	        public int nextInt() { return Integer.parseInt(next()); }
	        public long nextLong() { return Long.parseLong(next()); }
	        public double nextDouble() { return Double.parseDouble(next()); }
	    }
}
