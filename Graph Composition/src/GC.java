import javax.naming.NameNotFoundException;
import java.io.*;
import java.net.DatagramSocketImpl;
import java.util.*;

public class GC {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int T = kattio.nextInt();
        while(T-->0){
            //we're going to use a HashSet to store the edges to easily lookup how many are in both
            //Since O(1) deletion, we'll delete as we go.
            //After this is done, we know we must delete f.size() and add g.size() so we add these to our answer
            HashSet<int[]> f = new HashSet<>();
            HashSet<int[]> g = new HashSet<>();
            int N = kattio.nextInt();
            int fe = kattio.nextInt();
            int ge = kattio.nextInt();
            DSU dsuf = new DSU(N);
            DSU dsug = new DSU(N);
            for (int i = 0; i <fe; i++) {
                int a = kattio.nextInt();
                int b = kattio.nextInt();
                f.add(new int[] {a,b});
            }
            for (int i = 0; i < ge; i++) {
                int a  =kattio.nextInt();
                int b = kattio.nextInt();
                dsug.union_set(a, b);
            }
            int removals = 0;
    for(int[] e : f){
        int a = e[0];
        int b = e[1];
        int ra = dsug.findSet(a);
        int rb = dsug.findSet(b);
        if(ra!=rb){
            removals++;
        } else{
            dsuf.union_set(a,b);
        }
    }
            Map<Integer, Set<Integer>> comps = new HashMap<>();
            for (int i = 1; i <=N ; i++) {
                int groot = dsug.findSet(i);
                int froot = dsuf.findSet(i);
            if(!comps.containsKey(groot)) comps.put(groot, new HashSet<>());
            comps.get(groot).add(froot);
            }
            int additions = 0;
            for(Set<Integer> r: comps.values()){
                int len = r.size();
                if(len>0){
                    additions+=len-1;
                }
            }
            kattio.println(removals+additions);
        }
        kattio.close();
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
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
    static class Pair {
        public int first, second;

        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }
    static class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findSet(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = findSet(parent[i]);
        }
        void union_set(int x, int y) {
            int s1 = findSet(x);
            int s2 = findSet(y);

            if (s1 != s2) {
                parent[s1] = s2;
            }
        }
    }

}
