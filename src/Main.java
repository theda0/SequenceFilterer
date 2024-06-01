import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Path to the file
        String filePath = "testFile.txt";
        List<String> lines = new ArrayList<>();

        // Create a BufferedReader in a try-with-resources statement
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder toBeBuilt = new StringBuilder();
            //
            while ((line = br.readLine()) != null) {
                if (line.charAt(0) == '>'){
                    lines.add(toBeBuilt.toString());
                    toBeBuilt.delete(0, toBeBuilt.length());
                } else {
                    toBeBuilt.append(line);
                }
            }
            lines.add(toBeBuilt.toString());
        } catch (IOException e) {
            // Handle the exception
            System.err.println("Error reading file: " + e.getMessage());
        }

        for(String c : lines){
            System.out.println(c);
            System.out.println( '\n');
        }
    }
}