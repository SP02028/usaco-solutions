import java.io.*;
import java.util.*;

public class LM {
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] t = new int[n + 2];
    int[] lorL = new int[n + 2];
    int[] lorR = new int[n + 2];
    int[] lfl = new int[n + 2];
    int[] lfr = new int[n + 2];
    int[] evL = new int[n + 2];
    int[] evR = new int[n + 2];       
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
        String s = st.nextToken();
        if (s.equals("false")) {
            t[i] = 0;
        } else if (s.equals("true")) {
            t[i] = 1;
        } else if (s.equals("and")) {
            t[i] = 2;
        } else if (s.equals("or")) {
            t[i] = 3;
        }
    }       
    // Precompute last OR position to the left
    for (int i = 1; i <= n; i++) {
        if (t[i] == 3) {
            lorL[i] = i;
        } else {
            lorL[i] = lorL[i - 1];
        }
    }  
    // Precompute last OR position to the right
    lorR[n + 1] = n + 1;
    for (int i = n; i >= 1; i--) {
        if (t[i] == 3) {
            lorR[i] = i;
        } else {
            lorR[i] = lorR[i + 1];
        }
    }   
    // Precompute last FALSE position to the left
    lfl[0] = -1;
    for (int i = 1; i <= n; i++) {
        if (t[i] == 0) {
            lfl[i] = i;
        } else {
            lfl[i] = lfl[i - 1];
        }
    }
    
    // Precompute last FALSE position to the right
    lfr[n + 1] = n + 2;
    for (int i = n; i >= 1; i--) {
        if (t[i] == 0) {
            lfr[i] = i;
        } else {
            lfr[i] = lfr[i + 1];
        }
    }   
    // Compute left-side subexpression evaluations
    int ov = 0;
    for (int i = 1; i <= n; ) {
        int j = i + 1, v = t[i];
        while (j <= n && t[j] != 3) { // Process AND sequences
            v &= t[j + 1];
            j += 2;
        }
        if (v == 1) {
            ov = 1;
        } // If any AND sequence is true, overall becomes true
        evL[j] = ov;
        i = j + 1;
    }
    
    // Compute right-side subexpression evaluations
    int ov2 = 0;
    for (int i = n; i >= 1; ) {
        int j = i - 1, v = t[i];
        while (j >= 1 && t[j] != 3) { // Process AND sequences in reverse
            v &= t[j - 1];
            j -= 2;
        }
        if (v == 1) {
            ov2 = 1;
        }
        evR[j] = ov2;
        i = j - 1;
    }
    for (int i = 1; i <= q; i++) {
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        String str = st.nextToken();       
        int pl = lorL[l]; // Most recent OR to the left of L
        int pr = lorR[r]; // Most recent OR to the right of R      
        // If any subexpression is already true, we cannot change the result
        if (evL[pl] == 1 || evR[pr] == 1) {
            if (str.equals("false")) {
                pw.print("N");
            } else {
                pw.print("Y");
            }
        } else {
            // If there is a FALSE inside the range, the result is fixed as false
            if (str.equals("false")) {
                pw.print("Y");
            } else if (lfl[l - 1] >= pl || lfr[r + 1] <= pr) {
                pw.print("N");
            } else {
                pw.print("Y");
            }
        }
    }
    pw.close();
}
}