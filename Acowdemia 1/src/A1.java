import java.util.*;
import java.io.*;
public class A1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Integer[] papers = new Integer[len];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <len;i++) {
			papers[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(papers, Collections.reverseOrder());
       int h = calch(papers);
        if(h<len) {
        	for(int i = h;i >=Math.max(0, h-L +1);i--) {
        		papers[i] = papers[i]+1;
        	}
        }
        Arrays.sort(papers, Collections.reverseOrder());
        pw.println(calch(papers));
        pw.close();
	}
	public static int calch  ( Integer[] papers) {
		int h = papers.length;
        while(h>0&&papers[h-1]<h) {
        	h--;
        }
        return h;
	}

}
