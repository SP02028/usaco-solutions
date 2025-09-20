import java.io.*;
import java.util.*;

public class ac {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < N; i++) max = Math.max(max, calculateExplosions(arr, i));
        System.out.println(max);
    }

    public static int calculateExplosions(int[] positions, int startIndex) {
        int count = 1; // Start with the initial position exploded
        int radius = 1;

        // Explode to the right
        int currIndex = startIndex;
        while (true) {
            int nextIndex = currIndex + 1;
            while (nextIndex < positions.length && positions[nextIndex] - positions[currIndex] <= radius) {
                nextIndex++;
            }
            if (nextIndex == currIndex + 1) break; // No new explosions
            count += (nextIndex - currIndex - 1);
            currIndex = nextIndex - 1;
            radius++;
        }

        // Explode to the left
        radius = 1;
        currIndex = startIndex;
        while (true) {
            int nextIndex = currIndex - 1;
            while (nextIndex >= 0 && positions[currIndex] - positions[nextIndex] <= radius) {
                nextIndex--;
            }
            if (nextIndex == currIndex - 1) break; // No new explosions
            count += (currIndex - nextIndex - 1);
            currIndex = nextIndex + 1;
            radius++;
        }

        return count;
    }
}

