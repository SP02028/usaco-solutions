import java.io.*;
import java.util.*;

public class abc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i = 0; i < 7; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr);
        
        int abc = arr.get(6);
        
        int a = arr.get(0);
        int b = arr.get(1);
        int c = abc - a - b;  
        
        System.out.println(a + " " + b + " " + c);
        
        pw.close();
    }
}


