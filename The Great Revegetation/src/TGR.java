import java.util.*;
import java.io.*;

public class TGR {
    static List<List<Integer>> same;
    static List<List<Integer>> diff;
    static boolean[] visited;
    static int[] colors;
    static boolean impossible =  false;
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int M = io.nextInt();
        same = new ArrayList<>();
        diff = new ArrayList<>();
        for(int i = 0;i<N;i++){
            same.add(new ArrayList<>());
            diff.add(new ArrayList<>());
        }
        for(int i =0;i<M;i++){
            String S = io.next();
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            if (S.equals("S")) {
                same.get(a).add(b);
                same.get(b).add(a);
            }
            else{
                diff.get(a).add(b);
                diff.get(b).add(a);
            }
        }
        colors= new int[N];
        visited=new boolean[N];
        int comp =0;
        for(int i = 0; i<N;i++){
            if(colors[i]==0){
                dfs(i,1);
                comp++;
            }
        }
        if(impossible){
            io.println(0);
        }
        else{
            io.print(1);
            for(int i = 0;i <comp;i++){
                io.print(0);
            }
        }
io.close();
}
public static void dfs(int s,int color){
    colors[s]=color;
    for(int nbr: same.get(s)){
        if(colors[nbr]==0){
            dfs(nbr, color);
        }
        if(colors[nbr]==3-color){
            impossible=true;
        }
    }
    for(int nbr: diff.get(s)){
        if(colors[nbr]==0){
            dfs(nbr, 3-color);
        }
        if(colors[nbr]==color){
            impossible=true;
        }
    }
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
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
