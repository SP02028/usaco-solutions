import java.util.*;
import java.io.*;
public class HPSMO {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numhoofs = Integer.parseInt(st.nextToken());
		int numgames = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> wins = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i <=numhoofs;i++) {
			wins.add(new ArrayList<Integer>());
		}
		//pw.println();
		for(int i = 1; i <=numhoofs;i++) {
			String str=br.readLine();
			for(int j = 0; j<str.length();j++) {
				if(str.charAt(j)=='D') {
					continue;
				}
				else if(str.charAt(j)== 'L') {
					wins.get(i).add(j+1);
			//		System.out.println(j+1 + " wins against " + i);
				}
				else if(str.charAt(j)=='W') {
					wins.get(j+1).add(i);
			//		System.out.println(i + " wins against " + j+1);
				}
			}
		}
		/*for(int i=0;i<wins.size();i++) {
			pw.println(i + ":" );
			for(int a:wins.get(i)) {
				pw.print(a + " ");
			}
			pw.println();
		}*/
		//populated input
		//for each game, see which ones win no matter what
		for(int i =1; i <=numgames;i++) {
			 st = new StringTokenizer(br.readLine());
			int game1 = Integer.parseInt(st.nextToken());
			int game2 = Integer.parseInt(st.nextToken());
			ArrayList<Integer> g1wins = new ArrayList<Integer>();
			for(int j =0; j<wins.get(game1).size();j++) {
				g1wins.add(wins.get(game1).get(j));
			}
			ArrayList<Integer> g2wins = new ArrayList<Integer>();
			for(int j =0; j<wins.get(game2).size();j++) {
				g2wins.add(wins.get(game2).get(j));
			}
			/*for(int a:g2wins) {
				pw.println(a);
			}*/
			//check which are in both
			int winsboth = 0;
			/*if(g1size<g2size) {
				for(int j =0; j<g1size;j++) {
					if(g2wins.contains(g1wins.get(j))) {
						winsboth++;
					}
				}
			}
			else {
				for(int j =0; j<g1size;j++) {
					if(g1wins.contains(g2wins.get(j))) {
						pw.println(j);
						winsboth++;
					}
				}
			}*/
			for(int a: g1wins) {
		//		pw.print("g1 " + a + " ");
			}
		//	pw.println();
			for(int a : g2wins) {
		//		pw.print("g2 "+ a + " ");
			}
		//	pw.println();
			g2wins.retainAll(g1wins); //so this is the problem but how the heck do i fix it
			for(int a: g2wins) {
			//	pw.print("intersection " + a + " ");
			}
			//pw.println();
			winsboth = g2wins.size();	
			int total = numhoofs*numhoofs- ((numhoofs-winsboth)*(numhoofs-winsboth));
			pw.println(total);
		}
		pw.close();
	}	
}
