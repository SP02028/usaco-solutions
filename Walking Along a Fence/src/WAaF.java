import java.util.*;
import java.io.*;
public class WAaF {
	static int perimeter = 0;
	static int[][] grid = new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int prevX = startX;
        int prevY = startY;
        for(int i=1; i <P;i++) {
        	st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());
            walk(prevX, prevY, nextX, nextY);
            prevX = nextX;
            prevY = nextY;
        }
        walk(prevX, prevY, startX, startY);
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	int startx = Integer.parseInt(st.nextToken());
        	int starty = Integer.parseInt(st.nextToken());
        	int endx = Integer.parseInt(st.nextToken());
        	int endy = Integer.parseInt(st.nextToken());
        	
        	int dist = Math.abs(grid[startx][starty]-grid[endx][endy]);
        //	pw.println(perimeter);
        	//pw.println(dist);
        	int min = Math.min(perimeter-dist, dist);
        	pw.println(min);
        }
        pw.close();
    }
    public static void walk(int currX, int currY, int endX, int endY) {
    	int dirx =0;
    	int diry = 0;
    	if(currX<endX) {
    		dirx = 1;
    	}
    	else if(currX>endX) {
    		dirx = -1;
    	}
    	if(currY<endY) {
    		diry= 1;
    	}
    	if(currY>endY) {
    		diry =-1;
    	}
    	while(currX!=endX ||currY!=endY) {
    		perimeter++;
    		currX +=dirx;
    		currY +=diry;
    		grid[currX][currY] =perimeter;
    	}
    }
}