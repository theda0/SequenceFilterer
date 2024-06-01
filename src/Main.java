import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        // Path to the file
        String filePath = "seqdump2.txt";
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

        ModifiedTrie storageTrie = new ModifiedTrie(lines);
        List<Pair> newLines = storageTrie.modifiedList();

        //We know write the modified contents into a new file
        String fileName = "output.txt";
        try(FileWriter writer = new FileWriter(fileName)) {
            for(int i = 0; i < newLines.size(); ++i){
                Pair pear = newLines.get(i);
                writer.write(">" + String.valueOf(pear.first()) + "\n"); //The first info line
                writer.write(pear.second() + "\n"); //The sequence following it
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("An IOException was caught: " + e.getMessage());
        }
;    }
}