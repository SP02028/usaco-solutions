import java.util.*;
import java.io.*;
public class block {

			public static void main(String[] args) throws IOException{
				Scanner scan = new Scanner(new FileReader("blocks.in"));
				PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
				int amount = scan.nextInt();
				String letters = "abcdefghijklmnopqrstuvwxyz";
				int[][] newMax = new int[2][26];
				int[] max = new int[26];
				String[][] words = new String[amount][2];
				for (int i = 0; i < amount; i++) {
					for(int j =0;j<2;j++) {
						words[i][j] = scan.next();
					}
				}
				
				int x =0;
				for(int j = 0;j<amount;j++) {
					for(int i = 0;i < 2;i++) {
						Arrays.fill(newMax[i], 0);
					}
					for(int i =0;i<2;i++) {	
						for(int m = 0; m < words[j][i].length();m++) {
								x = letters.indexOf(Character.toString(words[j][i].charAt(m)));
								newMax[i][x] += 1;
						}
					}
					for(int m = 0; m < 26; m++) {
						max[m] += Math.max(newMax[0][m],newMax[1][m]);
					}
				}
				for(int i = 0; i < 26;i++) {
					writer.println(max[i]);
				}
				scan.close();
				writer.close();
			}
		}
	


