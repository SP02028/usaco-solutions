import java.util.*;
import java.io.*;

public class CS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        
        while (tc-- > 0) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] segs = str.split("W");
            boolean pos = true;

            for (String s : segs) {
                if (s.isEmpty()) {
                	continue;
                }
                boolean rcount = false;
                boolean bcount = false;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'R') {
                    	rcount = true;
                    }
                    if (s.charAt(i) == 'B') {
                    	bcount = true;
                    }
                }

                if (rcount ^ bcount) { 
                    pos = false;
                    break;
                }
            }
            if(pos) {
            	pw.println("YES");
            }
            else {
            	pw.println("NO");
            }
        }
        pw.close();
    }
}
