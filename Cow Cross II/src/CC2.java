import java.util.*;
import java.io.*;

public class CC2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter("circlecross.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] str = st.nextToken().toCharArray();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(int i = 0; i < 52;i++) {
        	int chartoint = str[i] - 'A';
        	if(start[chartoint] == -1) {
        		start[chartoint] = i;
        	}
        	else {
        		end[chartoint] = i;
        	}
        }
        int count = 0;
        for(int i = 0; i <26;i++) {
        	for(int j = 0; j <26;j++) {
        		if(start[i]<start[j] && end[i] < end[j] && start[j] < end[i]) {
        			count++;
        		}
        	}
        }
        pw.println(count);
        pw.close();
    }
}
