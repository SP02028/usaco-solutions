import java.io.*;
import java.util.*;

public class Subset {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String a = r.readLine();
		String b = r.readLine();
		int querries = Integer.parseInt(r.readLine());
		for(int i=0; i<querries; i++)
		{
			String h=r.readLine();
			boolean[] letters = new boolean[18];
			for(int j=0; j<h.length(); j++)
				letters[h.charAt(j)-'a']=true;
			int pointer1=0;
			int pointer2=0;
			while(pointer1<a.length()&&pointer2<b.length())
			{
				if(a.charAt(pointer1)==b.charAt(pointer2))
				{
					pointer1++;
					pointer2++;
				}
				else if(!letters[a.charAt(pointer1)-'a'])
					pointer1++;
				else if(!letters[b.charAt(pointer2)-'a'])
					pointer2++;
				else
					break;
			}
			if(pointer1==a.length()&&pointer2==b.length())
				pw.print("Y");
			else
			{
				while(pointer1<a.length()&&!letters[a.charAt(pointer1)-'a'])
					pointer1++;
				while(pointer2<b.length()&&!letters[b.charAt(pointer2)-'a'])
					pointer2++;
				if(pointer1==a.length()&&pointer2==b.length())
					pw.print("Y");
				else
					pw.print("N");
			}
		}
		pw.close();
	}
}
