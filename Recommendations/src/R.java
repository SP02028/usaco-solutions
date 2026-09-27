import java.util.*;
import java.io.*;
public class R {
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        long[][] arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = kattio.nextLong();
        }
        for (int i = 0; i < N; i++) {
            arr[i][1] = kattio.nextLong();
        }
        Arrays.sort(arr,Comparator.comparingLong(value -> value[0]));
        long total = 0;
        long curr = 0;
        long costsum =0;
        PriorityQueue<Long> costs = new PriorityQueue<>(Collections.reverseOrder());//maxheap
        int category =0;
        while (category < N || !costs.isEmpty()){
            if(costs.isEmpty()){
                curr = arr[category][0]; //jumps the item to next pos position in sorted array
            }
            while(category<N && arr[category][0]==curr){
                costsum +=arr[category][1];
                costs.add(arr[category][1]); // add items with initial position = curr to maxheap and add cost to costsum
                category++;
            }
            if(!costs.isEmpty()){
                long c = costs.poll();//pick the most expensive item from the heap to stay at the position
                costsum-=c;
                total +=costsum; //all other items move one step forward, thus add the costsum to total cost because they are all incremented
                curr++;
            }
        }
        kattio.println(total);
        kattio.close();
    }
    static class Kattio extends
            PrintWriter {
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
}
