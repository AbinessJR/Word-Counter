import javax.swing.*;
import java.awt.event.*;

public class WordCounterSwing extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel, charCountLabel, paragraphCountLabel;

    public WordCounterSwing() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating components
        textArea = new JTextArea();
        JButton countButton = new JButton("Count");
        wordCountLabel = new JLabel("Word Count: 0");
        charCountLabel = new JLabel("Character Count: 0");
        paragraphCountLabel = new JLabel("Paragraph Count: 0");

        // Setting layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Adding components to the frame
        add(new JScrollPane(textArea));
        add(countButton);
        add(wordCountLabel);
        add(charCountLabel);
        add(paragraphCountLabel);

        // Count button action
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String text = textArea.getText();

        // Counting words
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        // Counting characters
        int charCount = text.replaceAll("\\s", "").length();

        // Counting paragraphs
        String[] paragraphs = text.split("\n\n|\r\n\r\n");
        int paragraphCount = paragraphs.length;

        // Update labels with counts
        wordCountLabel.setText("Word Count: " + wordCount);
        charCountLabel.setText("Character Count: " + charCount);
        paragraphCountLabel.setText("Paragraph Count: " + paragraphCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WordCounterSwing app = new WordCounterSwing();
                app.setVisible(true);
            }
        });
    }
}
