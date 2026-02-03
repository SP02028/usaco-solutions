import java.util.*;
import java.io.*;

public class EF {
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int T = io.nextInt();
        
        while(T-->0) {
            int N = io.nextInt(); // number of folders
            int M = io.nextInt(); // number of emails
            int K = io.nextInt(); // window size
            
            int[] folder = new int[M]; // which folder each email belongs to (0-indexed)
            int[] remaining = new int[N]; // how many emails remaining for each folder
            
            for(int i = 0; i < M; i++) {
                folder[i] = io.nextInt() - 1; // convert to 0-indexed
                remaining[folder[i]]++;
            }
            
            int firstfolder = 0; // topmost folder currently visible
            int firstemail = 0; // first email position
            int lastemail = K - 1; // last email position in window
            boolean[] filed = new boolean[M];
            
            // store the __emails__ that are being processed at the moment
            PriorityQueue<Integer> currwindow = new PriorityQueue<>(Comparator.comparingInt(j -> folder[j]));
            
            for(int j = 0; j < K && j < M; j++) {
                currwindow.add(j);
            }
            
            String answer = "YES";
            
            // this simulates folder scrolling
            while(lastemail < M - 1 && firstfolder < N) {
                if(remaining[firstfolder] == 0) {
                    firstfolder++;
                } else if(!currwindow.isEmpty() && folder[currwindow.peek()] < firstfolder + K) {
                    // the folder for this email is in view at the moment
                    int j = currwindow.remove();
                    if(j >= firstemail) {
                        filed[j] = true;
                        remaining[folder[j]]--;
                        lastemail++;
                        if(lastemail < M) {
                            currwindow.add(lastemail);
                        }
                    }
                } else {
                    // the folder for this email is not in view but __emails__ still exist that belong to this folder
                    // scroll
                    while(firstemail < M && filed[firstemail]) {
                        firstemail++;
                    }
                    firstemail++;
                    lastemail++;
                    if(lastemail < M) {
                        currwindow.add(lastemail);
                    }
                }
            }
            
            // we've hit the end of emails
            // __theres__ no use continuing because if you __cant__ reach one of the skipped __emails__ its immediately over
            while(firstfolder < N) {
                if(remaining[firstfolder] == 0) {
                    firstfolder++;
                } else {
                    if(currwindow.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    int j = currwindow.remove();
                    if(j >= firstemail && !filed[j]) {
                        if(folder[j] >= firstfolder + K) {
                            answer = "NO";
                            break;
                        }
                        filed[j] = true;
                        remaining[folder[j]]--;
                        while(firstemail > 0) {
                            firstemail--;
                            if(!filed[firstemail]) {
                                currwindow.add(firstemail);
                                break;
                            }
                        }
                    }
                }
            }
            
            io.println(answer);
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
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
