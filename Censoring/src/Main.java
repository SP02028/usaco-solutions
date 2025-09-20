import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        String str = st.nextToken();
        StringTokenizer t = new StringTokenizer(r.readLine());
        String sub = t.nextToken();

        boolean containssub = true;
        while (containssub) {
            str = str.replace(sub, ""); 
            if (str.contains(sub)) {
            	continue;
            } else {
                containssub = false;
            }
        }

        pw.println(str);
        pw.close();
    }
}

