import java.io.*;
import java.util.*;

public class YACD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);      
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deck.add(Integer.parseInt(st.nextToken()));
        }       
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int color = Integer.parseInt(st.nextToken());
            int pos = 0;
            // Find the position of the first card with the color
            for (int j = 0; j < deck.size(); j++) {
                if (deck.get(j) == color) {
                    pos = j;
                    break;
                }
            }     
            pw.print((pos + 1) + " ");
            // Move the card to the top of the deck
            int card = deck.remove(pos);
            deck.add(0, card);
        }
        pw.close();
    }
}