import java.util.*;
import java.io.*;
public class CF {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc= Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			String line = br.readLine();
			int CC = 0;
			int CCW = 0;
			for(int i = 0; i <line.length()-2;i++) {
				if(line.substring(i, i+2).equals("NE")||line.substring(i, i+2).equals("SW")||line.substring(i, i+2).equals("ES")||line.substring(i, i+2).equals("WN")) {
					CC++;
					CC++;
				}
				else if(line.substring(i, i+2).equals("NW")||line.substring(i, i+2).equals("SE")||line.substring(i, i+2).equals("WS")||line.substring(i, i+2).equals("EW")) {
					CCW++;
					CCW++;
				}
			}
			if(CC >CCW) {
				pw.println("CW");
			}
			else {
				pw.println("CCW");
			}
		}
		pw.close();

	}

}
