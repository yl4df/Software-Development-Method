import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PineapplePizzaExample extends JFrame {

    private JRadioButton rdbtnYes;
    private JRadioButton rdbtnNo;
    private JTextField toppings;
    
    // day 2
    private JLabel buttonEventLabel;
    private JPanel left;
    private JPanel right;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    PineapplePizzaExample window = new PineapplePizzaExample();
                    
                    // Resize to fit content
                    //window.pack();
                    
                    // Display the Window
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PineapplePizzaExample() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Initial Size (minW minH maxW maxH)
        setBounds(100, 100, 450, 300);
        
        // Set what happens when you click the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Give it a layout: border = N, S, E, W, and Center
        // can specify a gap between components (horiz, vert)
        // here it is 0,0
        getContentPane().setLayout(new BorderLayout(0, 0));

        
        // Day 1
        // Panel 4 first, but with "Hello World"
        // then change it to the question, then add yes/no radio buttons
        // then add box for other toppings
        // 
        // Day 2
        // add submit button
        // then add image to the top
        // then mention pack() and how it changes
        // BACK TO SLIDES
        // Remember: any data elements, set as fields (access them in inner classes)
        // add listener to button (with eww/why label next to it)
        // add listener to yes/no buttons with changing colors on click
        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Do you like pineapple on your pizza?"));

        rdbtnYes = new JRadioButton("Yes");
        rdbtnNo = new JRadioButton("No");
        ButtonGroup pineapple = new ButtonGroup();
        pineapple.add(rdbtnYes);
        pineapple.add(rdbtnNo);
        panel4.add(rdbtnYes);
        panel4.add(rdbtnNo);
        
        getContentPane().add(panel4, BorderLayout.CENTER);
        
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Reasoning: "));
        toppings = new JTextField(15);
        panel2.add(toppings);
        
        // Day 2        
        JButton btn = new JButton("Submit");

            // part 2
            btn.setActionCommand("submit");
            btn.addActionListener(new ButtonListener());
        
        panel2.add(btn);        
        // add the result label (should be a field for the listener
        buttonEventLabel = new JLabel();
        panel2.add(buttonEventLabel);
        getContentPane().add(panel2, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        try { //why this?  Checked Exception (what if file doesn't exist!)
            // Note that the filenames without a path are in the root of our project (drag/drop the file)
            BufferedImage myPicture = ImageIO.read(new File("pineapple-pizza.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Add it to the top!
        getContentPane().add(panel, BorderLayout.NORTH);
        
        
        left = new JPanel();
        getContentPane().add(left, BorderLayout.WEST);
        right = new JPanel();
        getContentPane().add(right, BorderLayout.EAST);


        
        // add listeners to the radio buttons
        rdbtnYes.setActionCommand("radio");
        rdbtnNo.setActionCommand("radio");
        rdbtnYes.addActionListener(new ButtonListener());
        rdbtnNo.addActionListener(new ButtonListener());
        
    }
    
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // part 1
            if (e.getActionCommand().equals("submit")) {
                if (rdbtnYes.isSelected()) {
                    buttonEventLabel.setText("Eww!");
                } else if (rdbtnNo.isSelected()) {
                    buttonEventLabel.setText("Why!");
                }
            // part 2
            } else if (e.getActionCommand().equals("radio")) {
                if (rdbtnYes.isSelected()) {
                    left.setBackground(Color.RED);
                    right.setBackground(null);
                } else if (rdbtnNo.isSelected()) {
                    left.setBackground(null);
                    right.setBackground(Color.GREEN);
                }
            }
        }
        
    }

}
