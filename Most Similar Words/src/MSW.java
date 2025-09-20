import java.util.*;
import java.io.*;
public class MSW {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numwords = Integer.parseInt(st.nextToken());
			int lenwords = Integer.parseInt(st.nextToken());
			String[] words = new String[numwords];
			for(int i=0;i<numwords;i++) {
				words[i]= br.readLine();
				}
			int mincount=Integer.MAX_VALUE;
			for(int i= 0;i<numwords;i++) {
				for(int j=0;j<numwords;j++) {
					if(i!=j) {
						int temp =0;
						for(int k=0;k<lenwords;k++) {
							temp+=Math.abs( words[i].charAt(k) -words[j].charAt(k));
						}
						mincount=Math.min(temp, mincount);
					}
				}
			}
			pw.println(mincount);
		}
		pw.close();
	}

}
