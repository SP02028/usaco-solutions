import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		int[][] edges = {{1,2},{5,1},{1,3},{1,4}};
		System.out.println(findCenter(edges));
	}
public static int findCenter(int[][] edges) {
	int max = 0;
	for(int[] e:edges) {
		max = Math.max(max, Math.max(e[0], e[1]));
	}
	int[] freq = new int[max+1];
	for(int[] e:edges) {
		freq[e[0]]++;
		freq[e[1]]++;
	}
	for(int i = 0; i <=max;i++) {
		if(freq[i]==max-1) {
			return i;
		}
	}
	return -1;
	}
}
