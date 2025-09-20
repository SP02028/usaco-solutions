import java.util.*;
import java.io.*;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numcows = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cowpos = new int[numcows];
        int[] passesr = new int[numcows];
        for (int i = 0; i < numcows; i++) {
            cowpos[i] = Integer.parseInt(st.nextToken());
        }
        // Determine the target cow for each cow
        for (int i = 0; i < numcows; i++) {
            int targetcow = findTargetCow(i, cowpos, numcows);
            passesr[targetcow]++;
        }
        int count = 0;
        // Calculate the number of isolated cows and cow pairs passing to each other
        for (int i = 0; i < numcows; i++) {
            if (passesr[i] == 0) {
                count++; // Add one for each isolated cow
            }
            if (i < findTargetCow(i, cowpos, numcows) 
                && findTargetCow(findTargetCow(i, cowpos, numcows), cowpos, numcows) == i 
                && passesr[i] == 1 
                && passesr[findTargetCow(i, cowpos, numcows)] == 1) {
                count++; // Add one for each pair of cows passing to each other
            }
        }
        pw.println(count);
        pw.close();
    }
    public static int findTargetCow(int currentcow, int[] cowpos, int numcows) {
        int leftcow = -1, leftdist = Integer.MAX_VALUE;
        int rightcow = -1, rightdist = Integer.MAX_VALUE;
        // Find the closest cow on the left
        for (int othercow = 0; othercow < numcows; othercow++) {
            if (cowpos[othercow] < cowpos[currentcow] 
                && cowpos[currentcow] - cowpos[othercow] < leftdist) {
                leftcow = othercow;
                leftdist = cowpos[currentcow] - cowpos[othercow];
            }
        }
        // Find the closest cow on the right
        for (int othercow = 0; othercow < numcows; othercow++) {
            if (cowpos[othercow] > cowpos[currentcow] 
                && cowpos[othercow] - cowpos[currentcow] < rightdist) {
                rightcow = othercow;
                rightdist = cowpos[othercow] - cowpos[currentcow];
            }
        }
        // Decide whether the left or right neighbor is closer
        if (leftdist <= rightdist) {
            return leftcow;
        }
        return rightcow;
    }
}
