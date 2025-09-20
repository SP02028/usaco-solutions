import java.io.*;
import java.util.*;
public class MO {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int t = Integer.parseInt(br.readLine());
    for(int tc= 0 ;tc<t;tc++){
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] h = new int[n];
      for(int i = 0; i < n; i++) h[i] = Integer.parseInt(st.nextToken());
      boolean[] valid = new boolean[n+1];
      for(int i = 0; i + 1 < n; i++) {
        if(h[i] == h[i+1]) {
        	valid[h[i]] = true;
        }
        if(i+2 < n && h[i] == h[i+2]) {
        	valid[h[i]] = true;
        }
      }
      boolean hastrue = false;
      for(int i = 1; i <= n; i++) {
        if(valid[i]) {
          if(hastrue) pw.print(' ');
          hastrue = true;
          pw.print(i);
        }
      }
      if(!hastrue) {
    	  pw.print(-1);
      }
      pw.println();
    }
    pw.close();
  }
}