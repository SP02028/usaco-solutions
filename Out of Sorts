import java.io.*;
import java.util.*;

public class OoS3 {
public static void main(String[] args) throws IOException{
Kattio kattio = new Kattio("sort");
int N = kattio.nextInt();
int[] arr = new int[N];
HashMap<Integer, List<Integer>> map = new HashMap<>();
int[] sortedarr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = kattio.nextInt();
        sortedarr[i] = arr[i];
        if(!map.containsKey(arr[i])){
            map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }else{
            map.get(arr[i]).add(i);
        }
    }
    Arrays.sort(sortedarr);
    int maxdisp=-1;
    for (int i = 0; i <N ; i++) {
    int ogidx = map.get(sortedarr[i]).get(0);
    map.get(sortedarr[i]).remove(0);
    maxdisp = Math.max(maxdisp, ogidx-i);
    }
  /*  boolean sorted=false;
    while(!sorted){
        sorted=  true;
      count++;
        for (int i = 0; i < N-1; i++) {
            if(arr[i+1]<arr[i]){
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
                sorted= false;
            }
        }
    }*/
    kattio.println(maxdisp+1);
    kattio.close();
}

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
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
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
