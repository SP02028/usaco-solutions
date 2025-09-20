	import java.util.*;
	import java.io.*;
public class Main {


	public static int power(int a, int b){
	int res = 1;
	while(b != 0){
	 if ((b & 1) == 1) {
	res = res*a;
	}
	b = b>>1;
	a = a*a;
	}
	return res;
	}
	public static void main(String[] args) throws IOException{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  PrintWriter pw = new PrintWriter(System.out);
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  int A = Integer.parseInt(st.nextToken());
	  int B = Integer.parseInt(st.nextToken());
	  int C = Integer.parseInt(st.nextToken());
	  int powac = power(A, C);
	  int powbc = power(B, C);
	  if(powac > powbc){
	    pw.println(">");
	  }
	  else if(powbc > powac){
	    pw.println("<");
	  }
	  else{
	    pw.println("=");
	  }
	  pw.close();
	}
}
