package generate;

import java.io.FileWriter;
import java.io.IOException;

public class Data {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\palsh\\Downloads\\1000000.txt");
            for (int i = 0; i < 1000000; i++) {
                writer.write(i + "\n");  
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
