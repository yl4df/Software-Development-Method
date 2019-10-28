import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

public class Homework5test {

    private JFrame frame;
   
    private JLabel mainLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Homework5test window = new Homework5test();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Homework5test() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 663 , 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        JButton btnNext = new JButton("Next");
        panel.add(btnNext);
        
        JButton btnPrevious = new JButton("Previous");
        panel.add(btnPrevious);
        
        JButton btnSortbydate = new JButton("Sort-by-Date");
        panel.add(btnSortbydate);
        
        JButton btnSortbycaption = new JButton("Sort-by-Caption");
        panel.add(btnSortbycaption);
        
        JButton btnSortbyrating = new JButton("Sort-by-Rating");
        panel.add(btnSortbyrating);
        
        
        
        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        JRadioButton radioButton = new JRadioButton("1");
        panel_1.add(radioButton);
        
        JRadioButton radioButton_1 = new JRadioButton("2");
        panel_1.add(radioButton_1);
        
        JRadioButton radioButton_2 = new JRadioButton("3");
        panel_1.add(radioButton_2);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("4");
        panel_1.add(rdbtnNewRadioButton);
        
        JRadioButton radioButton_3 = new JRadioButton("5");
        panel_1.add(radioButton_3);
        
        
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainLabel = new JLabel();
        mainPanel.add(mainLabel);
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BoxLayout(panel_2,BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel_2, BorderLayout.WEST);
        
        JLabel label1 = new JLabel("label1");
        
        label1.setText("Information for label1");
        ImageIcon imageIcon1 = rescale(Homework5test.class.getResource("/images/WechatIMG155.jpeg"));
        label1.setIcon(imageIcon1);
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                mainLabel.setIcon( new ImageIcon(Homework5test.class.getResource("/images/WechatIMG155.jpeg")));
                
            }
        });
        panel_2.add(label1);
        
        JLabel label2 = new JLabel("label2");
        label2.setText("Information for labe2");
        ImageIcon imageIcon2 = rescale(Homework5test.class.getResource("/images/WechatIMG156.jpeg"));
        label2.setIcon(imageIcon2);
        panel_2.add(label2);
        
        JLabel label3 = new JLabel("label3");
        label3.setText("Information for labe3");
        ImageIcon imageIcon3 = rescale(Homework5test.class.getResource("/images/WechatIMG157.jpeg"));
        label3.setIcon(imageIcon3);
        panel_2.add(label3);
        
        JLabel label4 = new JLabel("label4");
        label4.setText("Information for label4");
        ImageIcon imageIcon4 = rescale(Homework5test.class.getResource("/images/WechatIMG158.jpeg"));
        label4.setIcon(imageIcon4);
        panel_2.add(label4);
        
        JLabel label5 = new JLabel("label5");
        label5.setText("Information for label5");
        ImageIcon imageIcon5 = rescale(Homework5test.class.getResource("/images/WechatIMG159.jpeg"));
        label5.setIcon(imageIcon5);
        panel_2.add(label5);
        
        
        
        
        
        
        
       
    }
    
    public ImageIcon rescale(URL link) {
        ImageIcon imageIcon = new ImageIcon(link);
        Image i = imageIcon.getImage();
        Image desiredImage = i.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(desiredImage);
        return imageIcon;
    }
    
   
   
}


