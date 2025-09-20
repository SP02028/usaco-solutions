import java.util.*;
import java.io.*;
public class QM {

	public static void main(String[] args) {
		Kattio io = new Kattio();
		int T= io.nextInt();
		while(T-->0) {
			int n=io.nextInt();
			int m = io.nextInt();
			int[] arr = new int[n];
			for(int i=0; i <n;i++) {
				arr[i] = io.nextInt();
			}
		//set up a map so that for each student we have all the topics they're proficient in.
		Arrays.sort(arr);
		Map<Integer, ArrayList<Integer>> map= new HashMap<Integer, ArrayList<Integer>>();
		for(int i: arr) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 1; j <=Math.sqrt(i);j++) {
				if(i%j==0) {
					if(j<=m) {
						temp.add(j);
						int other=i/j;
						 if (other != j && other <= m) {
							 temp.add(other);
						 }
					}
					
				}
			}
			map.put(i, temp);
		}
		//now use two pointers to find the ideal subset.
		HashMap<Integer, Integer> topicFreq = new HashMap<>();
		int left  = 0;
		int have = 0;
		int minlen = Integer.MAX_VALUE;
		for(int right = 0;right<n;right++) {
			 int c = arr[right];
			 for(int topic : map.get(c)) {
				 topicFreq.put(topic, topicFreq.getOrDefault(topic, 0) + 1);		
				 
			    if (topicFreq.get(topic) == 1) {
			        have++;
			    }
			 }
			    while (have == m) {
					  minlen = Math.min(minlen, arr[right]-arr[left]);
			        int l = arr[left];
			        for(int topic : map.get(l)) {
                        topicFreq.put(topic, topicFreq.get(topic) - 1);
			        
			        if (topicFreq.get(topic) == 0) {
			            have--;
			        }
			        }
			        left++;
			    }
		}
		if(minlen == Integer.MAX_VALUE) {
			io.println(-1);
		}
		else {
			io.println(minlen);
		}
		}
		io.close();

	}
	static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

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
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
