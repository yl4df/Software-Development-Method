import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class FirstGUI extends JFrame {
    private JLabel instruction;
    private JTextField input;
    private JLabel result;
    private JRadioButton clickIt;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    FirstGUI window = new FirstGUI();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FirstGUI() {
        initialize();
    }

    private void initialize() {

        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JPanel panel1 = new JPanel();
        instruction = new JLabel("Convert from kilometers to miles");
        panel1.add(instruction);
        clickIt = new JRadioButton("Click Me");
        panel1.add(clickIt);
        getContentPane().add(panel1, BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        result = new JLabel("Result");
        panel1.add(result);
        input = new JTextField(15);
        panel2.add(input);
        JButton btn = new JButton("Submit");

        btn.setActionCommand("submit");
        btn.addActionListener(new ButtonListener());
        panel2.add(btn);
        getContentPane().add(panel2, BorderLayout.SOUTH);
        
    }
        private class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("submit")) {
                    String s = input.getText();
                    int num = Integer.parseInt(s);
                    double num_2 = num *(1/1.609344);
                    String x = String.valueOf(num_2);
                    result.setText(x);
                }
            }
        }
            }
    

