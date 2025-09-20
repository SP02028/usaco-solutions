package generate;

import java.io.*;
import java.util.*;

public class datagen {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\palsh\\Downloads\\1000000.txt");
            ArrayList<Integer> arr = new ArrayList<>();
            Random random = new Random();

            for (int i = 2; i <= 1000000; i++) {
                arr.add(i);
            }

            for (int i = 0; i < 1000000; i++) {
               
                    int randomIndex = random.nextInt(arr.size());

                    writer.write(arr.get(randomIndex) + "\n");

                    arr.remove(randomIndex);
                }
            

            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
