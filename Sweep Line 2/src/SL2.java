import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SL2 {
    /*read N
array events2D[][4] //x, 0/1 (left/right), y1, y2
repeat N times
    read x1, y1, x2, y2
    append(events2D, { x1, 0, y1, y2 })
    append(events2D, { x2, 1, y1, y2 })
sort(events2D)
res = "No" //consider that no overlaps
set events1D[2] //y, 0/1(left/right)

for each e1 in events2D
    if (e1[1] = 0) //left-hand side
        add(events1D, { e1[2], 0 }) //(y1, 0), starting end point
        add(events1D, { e1[3], 1 }) //(y2, 1), ending end point
        //A new sweep line for testing the line segment overlaps
        cnt = 0
        for each e2 in events1D
            if e2[1] = 0
                if (cnt > 0)
                    res = "Yes"
                cnt++
            else
                cnt--
    else //right-hand side
        remove(events1D, { e1[2], 0 }) //(y1, 0), starting end point
        remove(events1D, { e1[3], 1 }) //(y2, 1), ending end point

print res

*/
    public static void main(String[] args) {
        Kattio kattio = new Kattio();
        int N = kattio.nextInt();
        int[][] events = new int[2*N][4];
        for (int i = 0; i < N; i++) {
            int x1 = kattio.nextInt();
            int y1=  kattio.nextInt();
            int x2 = kattio.nextInt();
            int y2 = kattio.nextInt();
            events[2 * i] = new int[]{x1, 0, y1, y2};     // 0 = Left endpoint
            events[2 * i + 1] = new int[]{x2, 1, y1, y2};
        }
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        TreeSet<Integer[]> active = new TreeSet<>((a, b) -> {
            if (!a[0].equals(b[0])) return a[0] - b[0];
            return a[1] - b[1];
        });        String res="";
        for(int[] e : events){
            if(e[1] ==0){
                active.add(new Integer[] {e[2],0});
                active.add(new Integer[] {e[3],1});
                int cnt =0 ;
                for(Integer[] e2 : active){
                    if (e2[1] ==0){
                        if(cnt>0){
                            res = "Yes";
                        }
                        cnt++;
                    }else{
                        cnt--;
                    }
                }
            }
            else{
                active.remove(new Integer[]{e[2], 0});
                active.remove(new Integer[]{e[3], 1});
                //i dont think these lines are legit in java because its creating a copy... whats the workaround
            }
        }
        kattio.println(res);
        kattio.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            this.r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while(this.st == null || !this.st.hasMoreTokens()) {
                    String line = this.r.readLine();
                    if (line == null) {
                        return null;
                    }

                    this.st = new StringTokenizer(line);
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }

        public long nextLong() {
            return Long.parseLong(this.next());
        }
    }
}
