import java.util.*;
import java.io.*;
public class RACT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            int numtri = Integer.parseInt(t.nextToken());
            int base = Integer.parseInt(t.nextToken());
            int height = Integer.parseInt(t.nextToken());
            double area = numtri * base * height * 0.5;
            
            StringTokenizer s = new StringTokenizer(br.readLine());
            int[] triangles = new int[numtri];
            for(int j = 0; j < numtri; j++) {
                triangles[j] = Integer.parseInt(s.nextToken());
            }
            
            double newarea = 0;
            int intersection = 0;
            double newbase = 0;
            
            if(numtri == 1) {
                pw.println(area);
                continue;
            } else {
                for(int n = 0; n < numtri-1; n++) {
                    if((triangles[n] + height) > triangles[n+1]) {
                        intersection = triangles[n] + height - triangles[n+1];
                        newbase = intersection * 1.0 / height * base;
                        newarea = (newbase * intersection) / 2;
                    }
                    area -= newarea;
                }
                pw.println(area);
            }
        }
        pw.close();
    }
}
