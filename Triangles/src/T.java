import java.util.*;
import java.io.*;
public class T {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int num = Integer.parseInt(br.readLine());
		int[][] points = new int[num][2];
		for(int i=0;i<num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		int maxarea=0;
		for(int i=0;i<num;i++) {
			for(int j =0;j<num;j++) {
				for(int k =0; k<num;k++) {
					Set<Integer> x = new HashSet<Integer>();
					Set<Integer> y = new HashSet<Integer>();
					x.add(points[i][0]);
					x.add(points[j][0]);
					x.add(points[k][0]);
					y.add(points[i][1]);
					y.add(points[j][1]);
					y.add(points[k][1]);
					if(x.size()==2&&y.size()==2) {
						maxarea= Math.max(area(points[i], points[j], points[k]), maxarea);
					}
				}
			}
		}
		pw.println(maxarea);
		pw.close();
	}
    public static int area(int[] x, int[] y, int[] z) {
        int area = Math.abs(x[0] * (y[1] - z[1]) + y[0] * (z[1] - x[1]) + z[0] * (x[1]- y[1]));       
        return Math.abs(area);
    }

}
