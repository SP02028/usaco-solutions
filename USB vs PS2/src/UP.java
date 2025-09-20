import java.util.*;
import java.io.*;
public class UP {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		long USB = Long.parseLong(st.nextToken());
		long PS2 = Long.parseLong(st.nextToken());
		long both = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long nummice = Long.parseLong(st.nextToken());
		ArrayList<Long> usbs = new ArrayList<Long>();
		ArrayList<Long> PS2s = new ArrayList<Long>();
		ArrayList<Long> remaining = new ArrayList<Long>();
		for(int i = 0; i <nummice;i++) {
			st = new StringTokenizer(br.readLine());
			long cost = Long.parseLong(st.nextToken());
			String type = st.nextToken();
			if(type.equals("USB")){
				usbs.add(cost);
			}
			else {
				PS2s.add(cost);
			}
			
		}
		long sum = 0;
		long numcomp = 0;
		Collections.sort(usbs);
		Collections.sort(PS2s);
		//take the minimum of the number of usbs and the number of available mice
		long numusbs = Math.min(usbs.size(), USB);
		for(int i = 0; i <usbs.size();i++) {
			if(i < numusbs) {
				sum +=usbs.get(i);
				numcomp++;
			}
			else {
				remaining.add(usbs.get(i));
			}
		}
		//take the minimum of the number of usbs and the number of available mice
				long numps2s = Math.min(PS2s.size(), PS2);
				for(int i = 0; i <PS2s.size();i++) {
					if(i < numps2s) {
						sum +=PS2s.get(i);
						numcomp++;
					}
					else {
						remaining.add(PS2s.get(i));
					}
				}
		Collections.sort(remaining);
		//take min of both and the num of remaining mice
		long numremaining = Math.min(remaining.size(), both);
		for(int i = 0; i < numremaining;i++) {
			sum+=remaining.get(i);
			numcomp++;
		}
		pw.print(numcomp + " " + sum);
		pw.close();
	}

}
