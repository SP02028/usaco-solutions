package whereami;
import java.util.*;
import java.io.*;

public class where {

	
		public static void main(String[] args) throws IOException {
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(System.out);
			Set<Integer> hs = new HashSet<Integer>();
			StringTokenizer st = new StringTokenizer(r.readLine());
			int x = Integer.parseInt(st.nextToken());
			StringTokenizer s = new StringTokenizer(r.readLine());
			for(int i =0; i < x; i++){
				hs.add(Integer.parseInt(s.nextToken()));
			}
			pw.println(hs.size());
			/*
			 * Make sure to include the line below, as it
			 * flushes and closes the output stream.
			 */
			pw.close();
		}
	}

