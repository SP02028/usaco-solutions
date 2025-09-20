import java.io.*;
import java.util.*;

public class CT {
    static boolean[] infectedCows;
    static int totalCows; 
    static final int MAX_TIME = 250; 
    static final int MAX_COWS = 100;
    static int[] cowX = new int[MAX_TIME + 1]; 
    static int[] cowY = new int[MAX_TIME + 1];
    // Simulates infection spread based on patient zero and number of handshakes before not contagious k
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalCows = Integer.parseInt(st.nextToken());
        int totalHandshakes = Integer.parseInt(st.nextToken());
        String str = br.readLine(); 
        infectedCows = new boolean[totalCows + 1];
        for (int i = 1; i <= totalCows; i++) {
            infectedCows[i] = (str.charAt(i - 1) == '1'); 
        }
        for (int i = 0; i < totalHandshakes; i++) {
            st= new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            cowX[time] = Integer.parseInt(st.nextToken());
            cowY[time] = Integer.parseInt(st.nextToken());
        }
        boolean[] posp0 = new boolean[MAX_COWS + 1];
        boolean[] posk = new boolean[MAX_TIME + 2];
        // Iterate through all patient zero and K possibilities
        for (int p0 = 1; p0 <= totalCows; p0++) {
            for (int k = 0; k <= MAX_TIME + 1; k++) {
                if (validdata(p0, k)) {
                    posp0[p0] = true;
                    posk[k] = true;
                }
            }
        }
        int minK = MAX_TIME + 1;
        int maxK = 0;
        int numPatientZeros = 0;
        // Determine the range of K and count possible patient zeros
        for (int k = 0; k <= MAX_TIME + 1; k++) {
            if (posk[k]) maxK = k;
        }
        for (int k = MAX_TIME + 1; k >= 0; k--) {
            if (posk[k]) minK = k;
        }
        for (int i = 1; i <= totalCows; i++) {
            if (posp0[i]) numPatientZeros++;
        }
        pw.print(numPatientZeros + " " + minK + " ");
        pw.println((maxK == MAX_TIME + 1) ? "Infinity" : maxK);
        pw.close();
    }
    static boolean validdata(int patientZero, int k) {
        boolean[] infected = new boolean[MAX_COWS + 1];
        int[] handshakeCounts = new int[MAX_COWS + 1]; // Tracks the number of handshakes
        infected[patientZero] = true;
        // Simulate handshake events over time
        for (int t = 0; t <= MAX_TIME; t++) {
            int cow1 = cowX[t];
            int cow2 = cowY[t];
            if (cow1 > 0) { 
                if (infected[cow1]) handshakeCounts[cow1]++;
                if (infected[cow2]) handshakeCounts[cow2]++;
                if (handshakeCounts[cow1] <= k && infected[cow1]) infected[cow2] = true;
                if (handshakeCounts[cow2] <= k && infected[cow2]) infected[cow1] = true;
            }
        }
        for (int i = 1; i <= totalCows; i++) {
            if (infected[i] != infectedCows[i]) {
            	return false;
            }
        }
        return true; // Data is valid
    }
}
