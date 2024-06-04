import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileModifier::new);
    }
}