import java.io.*;
import java.util.*;

public class Lock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int i = 0; i < tc; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
        	int line = Integer.parseInt(t.nextToken());
        	
        	//for loop condition is skipping
        	if(line%33==0) {
        		pw.println("Yes");
        	}
        	else {
        		pw.println("No");
        	}

        }
        pw.close();
    }
}
