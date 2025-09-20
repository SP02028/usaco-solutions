import java.io.*;
import java.util.*;
public class dbl {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter("notlast.out");
		StringTokenizer st= new StringTokenizer(br.readLine());
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("Bessie", 0);
		hmap.put("Maggie", 0);
		hmap.put("Elsie", 0);
		hmap.put("Henrietta", 0);
		hmap.put("Gertie", 0);
		hmap.put("Daisy", 0);
		hmap.put("Annabelle", 0);
		int N = Integer.parseInt(st.nextToken());
		for(int i =0;i<N;i++) {
			StringTokenizer t= new StringTokenizer(br.readLine());
			String person = t.nextToken();
			int increment = Integer.parseInt(t.nextToken());
			if(hmap.containsKey(person)) {
				int prevval = hmap.get(person);				
				hmap.replace(person, prevval + increment);
			}			
		}
		Collection<Integer> list = hmap.values();
		int min = Collections.max(list);
		for(int ele:list) {
			if(ele<min) {
				min = ele;
			}
		}
		while (list.remove(min));
		if(list.isEmpty()) {
			pw.println("Tie");
		}
		int newmin = Collections.min(list);
		int count =0;
		for(int ele2:list) {
			if(ele2==newmin) {
				count++;
			}
		}
		if(count>1) {
			pw.println("Tie");
		}
		else {
			  for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			        if (entry.getValue().equals(newmin)) {
			        	pw.println(entry.getKey());
			        }
			    }		
			  }
		pw.close();
	}
	
}
