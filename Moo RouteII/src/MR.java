/*# Input:
# N airports, M flights
# a[i] = layover time at airport i
# flights[i] = list of (r_j, s_j, d_j) for flights leaving i, sorted by r_j

initialize arrival[i] = +infinity for all airports
arrival[1] = 0   # Bessie starts at airport 1 at time 0

pq = min-heap()
pq.push((0, 1))  # (time, airport)

while pq not empty:
    t, i = pq.pop()
    if t > arrival[i]:
        continue  # skip outdated entry

    for (r_j, s_j, d_j) in flights[i]:
        if r_j >= t + a[i]:           # can she catch it?
            if s_j < arrival[d_j]:    # does it improve arrival time?
                arrival[d_j] = s_j
                pq.push((s_j, d_j))

# Output:
# print arrival[i] for each airport (earliest reachable time)
*/
import java.io.*;
import java.util.*;

public class MR {
    static class Flight {
        int departTime, arriveTime, dest;
        Flight(int r, int s, int d) { departTime = r; arriveTime = s; dest = d; }
    }

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int M = io.nextInt();

        int[] layover = new int[N + 1]; // 1-indexed
        List<Flight>[] flights = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) flights[i] = new ArrayList<>();

        // Read M flights
        for (int i = 0; i < M; i++) {
            int c = io.nextInt();
            int r = io.nextInt();
            int d = io.nextInt();
            int s = io.nextInt();
            flights[c].add(new Flight(r, s, d));
        }

        // Read layover times
        for (int i = 1; i <= N; i++) {
            layover[i] = io.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            flights[i].sort(Comparator.comparingInt(f -> f.departTime));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] arrival = new int[N+1];
        Arrays.fill(arrival, Integer.MAX_VALUE);
        arrival[1] = 0;
        pq.add(new int[]{0,1});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[0]>arrival[temp[1]]){
                continue;
            }
            for(Flight flight: flights[temp[1]]){
                int readyTime = 0;
                if(temp[1]==1){
                    readyTime=temp[0];
                }
                else{
                    readyTime = temp[0]+layover[temp[1]];
                }
                if (flight.departTime>=readyTime){
                    if(flight.arriveTime<arrival[flight.dest]){
                        arrival[flight.dest] = flight.arriveTime;
                        pq.add(new int[]{flight.arriveTime, flight.dest});
                    }
                }
            }
        }
        for (int i = 1; i <=N ; i++) {
            if(arrival[i] == Integer.MAX_VALUE){
                io.println(-1);
                continue;
            }
            io.println(arrival[i]);
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
