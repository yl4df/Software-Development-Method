import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
    JLabel instructions;
    JButton submit;
    JTextArea enterArea;

    JLabel livesRemaining;
    JLabel lettersEntered;
    JLabel wordOutput;

    boolean[] lettersCorrect = { false, false, false, false, false };
    int lives;
    String password;
    ArrayList<String> letters;
    String progress;

    public static void main(String[] args) {
        new GUILLOfFortune();
    }

    public GUILLOfFortune() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setSize(width, height);

        password = "super";
        progress = "_ _ _ _ _";
        lives = 5;
        letters = new ArrayList<String>();

        instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>");
        submit = new JButton("ENTER");
        enterArea = new JTextArea();
        livesRemaining = new JLabel("Lives: " + lives);
        lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
        wordOutput = new JLabel("_ _ _ _ _");
        wordOutput.setFont(new Font("Times", Font.BOLD, 20));

        instructions.setSize(23 * width / 60, height / 6);
        submit.setSize(width / 3, 50);
        enterArea.setSize(width / 3, 50);
        livesRemaining.setSize(width / 4, height / 12);
        lettersEntered.setSize(width / 3, height / 3);
        wordOutput.setSize(width / 2, height / 6);

        instructions.setLocation(width / 15, 1);
        submit.setLocation(width / 2, height / 2);
        enterArea.setLocation(width / 6, height / 2);
        livesRemaining.setLocation(11 * width / 15, 1);
        lettersEntered.setLocation(17 * width / 30, height / 20);
        wordOutput.setLocation(width / 3, height / 3);

        submit.addActionListener(new passwordButtonListener());

        this.add(instructions);
        this.add(submit);
        this.add(enterArea);
        this.add(livesRemaining);
        this.add(lettersEntered);
        this.add(wordOutput);

        this.add(new JLabel());
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private class passwordButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO: Implement the action taken by the button.
            String input = enterArea.getText();
            
            if (input.length() > 1) {
                input = input.substring(0, 1);
            }
            
            if (!letters.contains(input)) {
                letters.add(input);

                if (!password.contains(input)) {
                    lives--;
                    livesRemaining.setText("Lives: "+ lives);
                    lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
                } else {
                    if (input.equals("s")) {
                        progress = 's' + progress.substring(1);
                        wordOutput.setText(progress);
                        lettersCorrect[0] = true;
                        lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");

                    }
                    if (input.equals("u")) {
                        progress = progress.substring(0, 2) + 'u' + progress.substring(3);
                        wordOutput.setText(progress);
                        lettersCorrect[1] = true;
                        lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
                    }
                    if (input.equals("p")) {
                        progress = progress.substring(0, 4) + 'p' + progress.substring(5);
                        wordOutput.setText(progress);
                        lettersCorrect[2] = true;
                        lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
                    }
                    if (input.equals("e")) {
                        progress = progress.substring(0, 6) + 'e' + progress.substring(7);
                        wordOutput.setText(progress);
                        lettersCorrect[3] = true;
                        lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
                    }
                    if (input.equals("r")) {
                        progress = progress.substring(0, 8) + 'r';
                        wordOutput.setText(progress);
                        lettersCorrect[4] = true;
                        lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
                    }

                }

            }

            if (lettersCorrect[0] & lettersCorrect[1] & lettersCorrect[2] & lettersCorrect[3] & lettersCorrect[4]) {
                JOptionPane.showMessageDialog(null, "You will!");
            }
            if (lives <= 0) {
                JOptionPane.showMessageDialog(null, "You lose!");
            }
        }
    }
}
