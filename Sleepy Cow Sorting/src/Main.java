import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int[] arr = new int[n];
        StringTokenizer t = new StringTokenizer(r.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(t.nextToken());
        }

        int count = n-1;
        for(int i=n-2;i>=0;i--)
    	{
    		if(arr[i] < arr[i+1])
    			count = i;
    		else
    			break;
    	}

        pw.println(count);
        pw.close();
    }
}

