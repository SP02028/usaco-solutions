import java.util.*;
import java.io.*;

public class SG {
/*10 4 1
10 1 6 10 1 1 6 8 6 8
*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		long studentsavailable = Long.parseLong(st.nextToken());
		long maxdiff = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[len+1];
		for(int i =1;i<len+1;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		//Unless mentioned DO NOT assume sorted
		long[] differences = new long[len+1];
		for(int i = 2; i <=len;i++) {
			differences[i] = arr[i]-arr[i-1];
			//the ith element of differences is the difference between the ith and i-1th ele
		}
		int arrcount = 1;
		for(int i = 2; i <=len;i++) {
			if(differences[i]>maxdiff) {
				long studentsneeded = 0;
				if(differences[i]!=0) {
					if(differences[i]%maxdiff ==0) {
						studentsneeded = differences[i]/maxdiff-1;
						}
					else {
						studentsneeded = differences[i]/maxdiff;
						}
				}
				//formula for students needed
				if(studentsneeded<=studentsavailable) {
					//check if the number of students needed is less than the available students
					studentsavailable-=studentsneeded;
					continue;
				}
				else {
					//else increment array count
					arrcount++;
				}
			}
			else {
				continue;
			}
		}
		pw.println(arrcount);
		pw.close();
	}

}
