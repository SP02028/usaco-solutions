//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MR {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int M = io.nextInt();
        int[] layover = new int[N + 1];
        List<Flight>[] flights = new ArrayList[N + 1];

        for(int i = 1; i <= N; ++i) {
            flights[i] = new ArrayList();
        }

        for(int i = 0; i < M; ++i) {
            int c = io.nextInt();
            int r = io.nextInt();
            int d = io.nextInt();
            int s = io.nextInt();
            flights[c].add(new Flight(r, s, d));
        }

        for(int i = 1; i <= N; ++i) {
            layover[i] = io.nextInt();
        }

        for(int i = 1; i <= N; ++i) {
            flights[i].sort(Comparator.comparingInt((f) -> f.departTime));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] arrival = new int[N + 1];
        Arrays.fill(arrival, Integer.MAX_VALUE);
        arrival[1] = 0;
        pq.add(new int[]{0, 1});

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] <= arrival[temp[1]]) {
                for(Flight flight : flights[temp[1]]) {
                    int readyTime = 0;
                    if (temp[1] == 1) {
                        readyTime = temp[0];
                    } else {
                        readyTime = temp[0] + layover[temp[1]];
                    }

                    if (flight.departTime >= readyTime && flight.arriveTime < arrival[flight.dest]) {
                        arrival[flight.dest] = flight.arriveTime;
                        pq.add(new int[]{flight.arriveTime, flight.dest});
                    }
                }
            }
        }

        for(int i = 1; i <= N; ++i) {
            if (arrival[i] == Integer.MAX_VALUE) {
                io.println(-1);
            } else {
                io.println(arrival[i]);
            }
        }

        io.close();
    }

    static class Flight {
        int departTime;
        int arriveTime;
        int dest;

        Flight(int r, int s, int d) {
            this.departTime = r;
            this.arriveTime = s;
            this.dest = d;
        }
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
                    this.st = new StringTokenizer(this.r.readLine());
                }

                return this.st.nextToken();
            } catch (Exception var2) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(this.next());
        }
    }
}
