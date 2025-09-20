import java.io.*;
import java.util.*;

public class LAD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            boolean can = true;
            long num = Long.parseLong(br.readLine());
            //from here to
            String n = Long.toString(num);
           if(n.charAt(0)=='1'&&n.charAt(n.length()-1)!='9') {
        	   for(int j=1; j <n.length()-2;j++) {
        		   if(n.charAt(j)=='0') {
        			   can = false;
        		   }
        	   }
           }
           else {
        	   can = false;
           }
            //about here, is the main part that causes the tle
            //hint 1: What must the first (largest) digit be?
            //Answer to hint 1: First digit must always be 1 because each number will carry over so the last two numbers will carry over r
           //The in between digits can be 1-9
            //The first digit can 0-8
            //check if middle digit is not zero, first digit is 1 and last is not 9
            if (can) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }   
        }
        pw.close();
    }

    public static boolean islarge(Long k) {
        String str = Long.toString(k);
        return !str.contains("0") && !str.contains("1") && !str.contains("2") &&
               !str.contains("3") && !str.contains("4");
    }
}

