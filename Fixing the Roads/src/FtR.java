import java.io.*;
import java.util.*;

public class FtR {
   static ArrayList<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int A= Integer.parseInt(st.nextToken())-1;
        int B= Integer.parseInt(st.nextToken())-1;
        graph =new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken())-1;
            int b =Integer.parseInt(st.nextToken())-1;
            graph[a].add(new int[]{b,0});
            graph[b].add(new int[]{a,1});
        }
        //0-1 BFS to find min cost
    int[] dists = new int[N];
        for (int i = 0; i < N; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        dists[A] =0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(A);
        while(!deque.isEmpty()){
            int vertex = deque.pollFirst();

            if(vertex ==B) break;
            for (int[] edge: graph[vertex]){
                int next = edge[0];
                int weight = edge[1];

                if(dists[vertex]+weight<dists[next]){
                    dists[next] = dists[vertex] +weight;

                if(weight==0){
                    deque.addFirst(next);
                }else{
                    deque.addLast(next);
                }
                }
            }
        }
        System.out.println(dists[B]);
    }

}
