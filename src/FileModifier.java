import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileModifier extends JFrame implements ActionListener {
    private JButton selectInputButton;
    private JButton processButton;
    private JTextField inputField;

    public FileModifier() {
        super("File Modifier");

        // Set up the layout
        setLayout(new GridLayout(2, 2));

        // Initialize components
        selectInputButton = new JButton("Select Input File");
        processButton = new JButton("Process File");
        inputField = new JTextField();

        // Set input field to be non-editable
        inputField.setEditable(false);

        // Add components to the frame
        add(selectInputButton);
        add(inputField);
        add(new JLabel()); // Empty label for spacing
        add(processButton);

        // Add action listeners
        selectInputButton.addActionListener(this);
        processButton.addActionListener(this);

        // Set frame properties
        setSize(400, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectInputButton) {
            JFileChooser inputFileChooser = new JFileChooser();
            int result = inputFileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = inputFileChooser.getSelectedFile();
                inputField.setText(selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == processButton) {
            String inputFilePath = inputField.getText();
            if (inputFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select an input file.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                File inputFile = new File(inputFilePath);
                JFileChooser outputFileChooser = new JFileChooser();
                outputFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
                int result = outputFileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File outputFile = outputFileChooser.getSelectedFile();
                    modifyAndSaveFile(inputFile, outputFile);
                }
            }
        }
    }

    private void modifyAndSaveFile(File inputFile, File outputFile) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            StringBuilder toBeBuilt = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.charAt(0) == '>'){ //I.e. the line is the beginning of a new title line
                    lines.add(toBeBuilt.toString());
                    toBeBuilt.delete(0, toBeBuilt.length());
                } else {
                    toBeBuilt.append(line);
                }
            }
            lines.add(toBeBuilt.toString());

            ModifiedTrie storageTrie = new ModifiedTrie(lines);
            List<Pair> newLines = storageTrie.modifiedList();

            for(int i = 0; i < newLines.size(); ++i){
                Pair pear = newLines.get(i);
                writer.write(">" + String.valueOf(pear.first()) + "\n"); //The first info line
                String[] stringChunks = StringSplitter.StringSplit(pear.second(), 80);
                for(String a : stringChunks) {
                    writer.write(a + "\n"); //The sequence following it
                }
            }


            JOptionPane.showMessageDialog(this, "File modified and saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileModifier::new);
    }
}



