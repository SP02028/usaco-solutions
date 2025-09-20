import java.util.*;
import java.io.*;

public class GCKaS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int len = Integer.parseInt(br.readLine());
            char[] line = br.readLine().toCharArray();
            int min = Integer.MAX_VALUE;
            for(char c = 'a';c<='z';c++) {
            	int left = 0; //left pointer
            	int right = len-1; //right pointer
            	int numdel = 0; //num deletions
            	while(left<right) {
            		char leftc = line[left];
            		char rightc = line[right];
            		if(leftc == rightc) {
            			left++;
            			right--;
            			//characters at both ends match so move both pointers inward
            		} else if(leftc == c) {
            			left++;
            			numdel++;
            			//remove the left character
            		}
            		else if(rightc == c) {
            			right--;
            			numdel++;
            			//remove right character
            		}else {
            			numdel = Integer.MAX_VALUE;
            			break;
            			//impossible to make palindrome so you make the numdel max to signify not possible
            		}
            	}
                min = Math.min(min, numdel); //update min deletions
            }
        	if( min == Integer.MAX_VALUE) {
        		pw.println(-1);
        	}
        	else {
        		pw.println(min);
        	}
        }

        pw.close();
    }
}

