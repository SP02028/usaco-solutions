import java.util.*;
import java.io.*;
public class L {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int len =Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[len];
		for(int i =0 ; i <len;i++) {
			arr[i] = Integer.parseInt(st.nextToken())-1;
		}
		int earlyg = -1;
		int lastg = -1;
		int earlyh = -1;
		int lasth = -1;
		for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'G' && earlyg == -1) {
                earlyg = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == 'G' && lastg == -1) {
                lastg = i;
            }
        }
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'H' && earlyh == -1) {
                earlyh = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == 'H' && lasth == -1) {
                lasth = i;
            }
        }
        int count =0;
        if(arr[earlyg]>=lastg) {
        	//g visited everyone --> leader
        	//h leader needs to visit g or visit all hs
        	for (int i = 0; i < earlyg; i++) {
                if (i == earlyh) {
                    continue;
                }
                if (str.charAt(i) == 'H' && arr[i] >= earlyg) {
                    count++;
                }
            }
        }
        if (arr[earlyh] >= lasth) {
            // earlyh visited everybody.
            for (int i = 0; i < earlyh; i++) {
                if (i == earlyg) {
                    continue;
                }
                if (str.charAt(i) == 'G' && arr[i] >= earlyh) {
                    count++;
                }
            }
        }
        if ((arr[earlyg] >= lastg || (earlyg <= earlyh && arr[earlyg] >= earlyh)) && (arr[earlyh] >= lasth || (earlyh <= earlyg && arr[earlyh] >= earlyg))) {
            count++;
        }
		pw.println(count);
		pw.close();
	}

}
