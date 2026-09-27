import java.util.*;
import java.lang.*;
import java.io.*;

public class POTMS
{
    public static void main (String[] args)
    {
        Kattio kattio = new Kattio();
        int t=kattio.nextInt();
        while(t-->0)
        {
            int n=kattio.nextInt();
            int k=kattio.nextInt();
            long arr[][]=new long[n][2];
            for(int i=0;i<n;i++)
                arr[i][0]=kattio.nextLong();
            for(int i=0;i<n;i++)
                arr[i][1]=kattio.nextLong();
            Arrays.sort(arr,(a,b)->Long.compare(a[0],b[0]));
            long low=0,high=2*(long)1e9;long ans=0;
            while(low<=high){
                long mid=(low+high)/2;
                long req=(n+1)/2+1;
                long rem=k;
                for(int i=n-1;i>=0;i--){
                    if(arr[i][0]>=mid) req--;
                    else if(arr[i][1]==1){
                        if(mid-arr[i][0]<=rem){
                            rem=rem-(mid-arr[i][0]);
                            req--;
                        }
                    }
                }
                if(req<=0){
                    ans=Math.max(ans,arr[n-1][0]+mid);
                    low=mid+1;
                }else high=mid-1;
            }
            int j=-1;
            for(int i=n-1;i>=0;i--){
                if(arr[i][1]==1){
                    j=i;break;
                }
            }
            if(j==-1)
                kattio.println(ans);
            else if(j+1<=n/2)
                kattio.println(Math.max(ans,arr[j][0]+k+arr[n/2+1-1][0]));
            else
                kattio.println(Math.max(ans,arr[j][0]+k+arr[(n/2)-1][0]));

        }
kattio.close();
    }
    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
