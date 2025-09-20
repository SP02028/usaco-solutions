import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
     //user input
    	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] spotty = new char[m][n];
        char[][] plain = new char[m][n];
        for(int i =0; i <n;i++) {
        	StringTokenizer s = new StringTokenizer(r.readLine());
        	String str = s.nextToken();
        	char[] temp = str.toCharArray();
        	for(int j = 0; j < m; j++) {
        	spotty[j][i] = temp[j];
        	}
        }
        for(int a =n; a <2*n;a++) {
        	StringTokenizer s = new StringTokenizer(r.readLine());
        	String str = s.nextToken();
        	char[] temp = str.toCharArray();
        	for(int b = 0; b < m; b++) {
        	plain[b][a-n] = temp[b];
        	}
        }
        //check for overlap
        int count = 0;
     for(int index = 0; index < m; index++) {
         boolean common = false;
         ArrayList<Character> arr= new ArrayList<>();
    	 for(int index2 = 0; index2 < n; index2++) {
    		 arr.add(spotty[index][index2]);
    		 
    	 }
    	 for(char ele:plain[index]) {
    		 if(arr.contains(ele)) {
    			 common=true;
    		 }
    	 }
     

    	 if(common !=true) {
    		 count++;
    	 }
     }
        pw.println(count);
        pw.close();
    }
}

