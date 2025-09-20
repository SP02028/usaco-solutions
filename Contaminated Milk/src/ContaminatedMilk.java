import java.util.*;
import java.io.*;
public class ContaminatedMilk {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> milk = new ArrayList<ArrayList<Integer>>(N);
		ArrayList<ArrayList<Integer>> time = new ArrayList<ArrayList<Integer>>(N);
		for( int j = 0; j < N;j++) {
			milk.add(j, new ArrayList<Integer>());
			time.add(j, new ArrayList<Integer>());
		}
		for(int i =0;i<D;i++) {
			StringTokenizer t= new StringTokenizer(br.readLine());
			int first = Integer.parseInt(t.nextToken());
			milk.get(first-1).add(Integer.parseInt(t.nextToken()));
			time.get(first-1).add(Integer.parseInt(t.nextToken()));
		}
		int[][] sickcows = new int[S][2];
		for(int index = 0; index<S;index++) {
			StringTokenizer s= new StringTokenizer(br.readLine());
			sickcows[index][0] = Integer.parseInt(s.nextToken());
			sickcows[index][1] = Integer.parseInt(s.nextToken());
		}
	//start to determine what milks are bad
	//for each person, get the last index less than the time they got sick, add each milk until that to an arraylist
	//go put all valid milks into multidimensional arraylist, for each element in the first sub-arraylist, check if its in all and if it is put in another arraylist
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int[] s: sickcows) {
			int sickperson = s[0]-1;
			int sicktime = s[1];
			
			int ind = 0;
			ArrayList<Integer> validmilks = new ArrayList<Integer>();
			for(int t = 0; t<time.get(sickperson).size();t++) {
				if(time.get(sickperson).get(t)<sicktime) {
					validmilks.add(milk.get(sickperson).get(t));
				}
				else {
					continue;
				}
			}	
			arr.add(validmilks);
			
		}
		
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		for(int n:arr.get(0)) {
			boolean containsval = true;
			for(ArrayList<Integer> a:arr) {
				if(a.contains(n)) {
					continue;
				}
				else {
					containsval = false;
					break;
				}
			}
			if(containsval ==true) {
				intersection.add(n);
			}
		}
		//iterate through the valid milks and see out of the cows that didn't sick, which ones would get sick in each case, and what the max sick # is
		int count = 0;
		for(int m:intersection) {
			int othercount = 0;
			//iterate through milk and see for each index whether it contains m
			for(ArrayList<Integer> e:milk) {
				if(e.contains(m)) {
					othercount++;
				}
			}
			if(othercount>count) {
				count = othercount;
			}
		}
		pw.println(count);
	pw.close();
	}
	
	
}
