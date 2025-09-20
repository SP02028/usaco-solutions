import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int tc = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < tc; i++) {
            char[] line = br.readLine().toCharArray();
            
            if (line[0] == '0' && line[1] == '0') {  // Updated logic here
                String time = "12:" + line[3] + line[4];
                pw.println(time + " AM");
                continue;
            } 
            else if (line[0] == '0') {
                String time = line[0] + "" + line[1] + ":" + line[3] + line[4];
                pw.println(time + " AM");
                continue;
            } 
            else if (line[0] == '1' && (line[1] == '0' || line[1] == '1' || line[1] == '2')) {
                String time = line[0] + "" + line[1] + ":" + line[3] + line[4];
                if (line[1] == '0' || line[1] == '1') {
                    pw.println(time + " AM");
                } else {
                    pw.println(time + " PM");
                }
            } 
            else {
                String hour = "" + line[0] + line[1];
                int newhour = Integer.parseInt(hour) - 12;
                String hr = Integer.toString(newhour);
                if(hr.length() == 1 && !hr.equals("0")) {
                    hr = 0 + hr;
                    String time = hr + ":" + line[3] + line[4];
                    pw.println(time + " PM");
                } 
                else if(hr.equals("00")) {
                    String time = 12 + ":" + line[3] + line[4];
                    pw.println(time + " AM");
                } 
                else {  
                    String time = hr + ":" + line[3] + line[4];
                    pw.println(time + " PM");
                }
            }
        }
        pw.close();
    }
}
