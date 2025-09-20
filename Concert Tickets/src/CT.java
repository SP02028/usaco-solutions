import java.util.*;
import java.util.function.Predicate;
import java.io.*;
public class CT {
static int[] a;
static int n;
static int m;
	public static void main(String[] args) {
		Kattio io = new Kattio();
		MultiSet tickets =new MultiSet();
		 n = io.nextInt();
		 m = io.nextInt();
		for(int i = 0; i < n;i++) {
			tickets.add(io.nextInt());
		}
		a = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = io.nextInt();
		}
		tickets.add(Integer.MAX_VALUE);
		for(int j = 0;j <m;j++) {
			int ans = tickets.floor(a[j]);
			if(ans==Integer.MAX_VALUE) {
				io.println(-1);
			}
			else {
			io.println(ans);
			tickets.remove(ans);
			}
		}
		io.close();
	}

	public static class MultiSet {
        public TreeMap<Integer, Integer> map;
        public int size = 0;

        public MultiSet()
        { // constructor for empty multiset
            map = new TreeMap<>();
            size = 0;
        }

        public MultiSet(int[] a)
        { // constructor to create a multiset with array
            map = new TreeMap<>();
            size = a.length;
            for (int i = 0; i < a.length; i++) {
                map.put(a[i],
                        map.getOrDefault(a[i], 0) + 1);
            }
        }

        void add(int a)
        { // add element in multiset
            size++;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        void remove(int a)
        {
        	if (map.get(a) > 1) {
        	    map.put(a, map.get(a) - 1);
        	}
        	else {
        	    map.remove(a)   ;        
        	}
        	size -= 1;
        }
        int count(int a)
        { // count occurrence of a
            return map.getOrDefault(a, 0);
        }

        int ceiling(int a)
        { // finds smallest element greater than or equal to
            // a
            if (map.ceilingKey(a) != null) {
                int find = map.ceilingKey(a);
                return find;
            }
            else
                return Integer.MIN_VALUE;
        }

        int floor(int a)
        { // finds largest element less than or equal to a
            if (map.floorKey(a) != null) {
                int find = map.floorKey(a);
                return find;
            }
            else
                return Integer.MAX_VALUE;
        }

        int lower(int a)
        { // finds  largest element smaller than a
            if (map.lowerKey(a) != null) {
                int find = map.lowerKey(a);
                return find;
            }
            else
                return Integer.MAX_VALUE;
        }

        int higher(int a)
        { // finds smallest element greater than a
            if (map.higherKey(a) != null) {
                int find = map.higherKey(a);
                return find;
            }
            else
                return Integer.MIN_VALUE;
        }

        int first()
        { // return smallest element in multiset
            return map.firstKey();
        }

        int last()
        { // return largest element in  multiset
            return map.lastKey();
        }

        boolean contains(int a)
        {
            if (map.containsKey(a))
                return true;
            return false;
        }

        int size() { return size; }

        void clear() { map.clear(); }
    }
	

static class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName + ".out");
		r = new BufferedReader(new FileReader(problemName + ".in"));
	}
	// returns null if no more input
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
