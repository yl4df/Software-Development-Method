import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Homework 5 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes, Online API
 */
public class PhotoViewer extends JFrame {

    private PhotographContainer imageAlbum;
    private int imageIndex; // this field can help us to keep track on the index of current displayed image
    private Photograph currentImage; // this field can help us to keep track on the current displayed image

    private JFrame frame;

    private ArrayList<JRadioButton> buttons; // this field is used to store JRadioButtons, so later we can use for loop manipulate
                                             // them

    private JLabel thumbnailLabel1;
    private JLabel thumbnailLabel2;
    private JLabel thumbnailLabel3;
    private JLabel thumbnailLabel4;
    private JLabel thumbnailLabel5;
    private ArrayList<JLabel> thumbnails; // this field is used to store JLabels, so later we can use for loop manipulate them

    private JLabel mainImage;

    private JPanel panelThumbnails;

    public static void main(String[] args) {

        // Upload 5 images for testing
        PhotoViewer myViewer = new PhotoViewer();
        String imageDirectory = "images/";
        Photograph p1 = new Photograph("River", imageDirectory + "image1.jpg", "2019-03-12", 4);
        Photograph p2 = new Photograph("Myself", imageDirectory + "image2.jpg", "2019-03-09", 5);
        Photograph p3 = new Photograph("Galaxy", imageDirectory + "image3.jpg", "2019-02-12", 3);
        Photograph p4 = new Photograph("Mountain", imageDirectory + "image4.jpg", "2018-03-12", 4);
        Photograph p5 = new Photograph("Village", imageDirectory + "image5.jpg", "2019-01-12", 5);
        myViewer.imageAlbum = new PhotoLibrary("Test Library", 1);
        myViewer.imageAlbum.addPhoto(p1);
        myViewer.imageAlbum.addPhoto(p2);
        myViewer.imageAlbum.addPhoto(p3);
        myViewer.imageAlbum.addPhoto(p4);
        myViewer.imageAlbum.addPhoto(p5);
        Collections.sort(myViewer.imageAlbum.photos);
        javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI());

    }

    /**
     * This is the fundamental method, which we use to show GUI.
     */
    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);

        // Set imageIndex to be 0 and the current image to be the first photo in the photo list.
        imageIndex = 0;
        currentImage = imageAlbum.getPhotos().get(imageIndex);

        JPanel panelButton = new JPanel();// This is the panel for 6 JButtons at the north.
        frame.getContentPane().add(panelButton, BorderLayout.NORTH);

        // This is the "Exit" Button. Add an action listener to it to make sure we can exit when clicking it.
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelButton.add(btnExit);

        // This is the "Previous" Button. Add an action listener to it to make sure we can see the previous photo when clicking
        // it.
        // Also by using if-else loop, we will see the last photo when the first is selected.
        // At the same time, we update the current image and its index.
        JButton btnPrevious = new JButton("Previous");
        btnPrevious.setActionCommand("pre");
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("pre")) {

                    if (imageIndex - 1 > 0) {
                        imageIndex--;
                        currentImage = imageAlbum.getPhotos().get(imageIndex);
                        setMain(currentImage);
                        setRatingButton(currentImage);
                    } else {
                        imageIndex = 4;
                        currentImage = (imageAlbum.getPhotos().get(4));
                        setMain(currentImage);
                        setRatingButton(currentImage);
                    }
                }
            }
        });
        panelButton.add(btnPrevious);

        // This is the "Next" Button. Add an action listener to it to make sure we can see the next photo when clicking it.
        // Also by using if-else loop, we will see the first photo when the end is reached.
        // At the same time, we update the current image and its index.
        JButton btnNext = new JButton("Next");
        btnNext.setActionCommand("next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("next")) {

                    if (imageIndex + 1 < imageAlbum.getPhotos().size()) {
                        imageIndex++;
                        currentImage = imageAlbum.getPhotos().get(imageIndex);
                        setMain(currentImage);
                        setRatingButton(currentImage);

                    } else {
                        imageIndex = 0;
                        currentImage = (imageAlbum.getPhotos().get(0));
                        setMain(currentImage);
                        setRatingButton(currentImage);

                    }
                }
            }
        });
        panelButton.add(btnNext);

        // This is the "Sort-by-Date" Button. Add an action listener to it to make sure we sort photos by date when clicking it
        JButton btnSortByDate = new JButton("Sort-by-Date");
        btnSortByDate.setActionCommand("sortByDate");
        btnSortByDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("sortByDate")) {
                    Collections.sort(imageAlbum.getPhotos());
                    imageIndex = 0; // After we sort photos, we reset index to be 0 and current image to be the first one in the
                                    // list
                    currentImage = imageAlbum.getPhotos().get(imageIndex);
                    setMain(currentImage);
                    setRatingButton(currentImage);
                    makeEachThumbnailFunctional(thumbnails);// set icon and add mouse listener to each thumbnail
                }
            }
        });
        panelButton.add(btnSortByDate);

        // This is the "Sort-by-Caption" Button. Add an action listener to it to make sure we sort photos by caption when
        // clicking it
        JButton btnSortByCaption = new JButton("Sort-by-Caption");
        btnSortByCaption.setActionCommand("sortByCaption");
        btnSortByCaption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("sortByCaption")) {
                    Collections.sort(imageAlbum.getPhotos(), new CompareByCaption());
                    imageIndex = 0; // After we sort photos, we reset index to be 0 and current image to be the first one
                                    // in the list
                    currentImage = imageAlbum.getPhotos().get(imageIndex);
                    setMain(currentImage);
                    setRatingButton(currentImage);
                    makeEachThumbnailFunctional(thumbnails);// set icon and add mouse listener to each thumbnail
                }
            }
        });
        panelButton.add(btnSortByCaption);

        // This is the "Sort-by-Rating" Button. Add an action listener to it to make sure we sort photos by ratings when
        // clicking it
        JButton btnSortByRating = new JButton("Sort-by-Rating");
        btnSortByRating.setActionCommand("sortByRating");
        btnSortByRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("sortByRating")) {
                    Collections.sort(imageAlbum.getPhotos(), new CompareByRating());
                    imageIndex = 0;      // After we sort photos, we reset index to be 0 and current image to be the first one in
                                         // the list
                    currentImage = imageAlbum.getPhotos().get(imageIndex);
                    setMain(currentImage);
                    setRatingButton(currentImage);
                    makeEachThumbnailFunctional(thumbnails);// set icon and add mouse listener to each thumbnail

                }
            }
        });

        panelButton.add(btnSortByRating);

        // This is the panel for 5 JRadioButtons
        JPanel panelRadio = new JPanel();
        frame.getContentPane().add(panelRadio, BorderLayout.SOUTH);

        // initialize them and add them to the panel
        JRadioButton radbtn1 = new JRadioButton("1");
        panelRadio.add(radbtn1);
        JRadioButton radbtn2 = new JRadioButton("2");
        panelRadio.add(radbtn2);
        JRadioButton radbtn3 = new JRadioButton("3");
        panelRadio.add(radbtn3);
        JRadioButton radbtn4 = new JRadioButton("4", true);
        panelRadio.add(radbtn4);
        JRadioButton radbtn5 = new JRadioButton("5");
        panelRadio.add(radbtn5);

        // add them to the Button Group
        ButtonGroup ratingButtons = new ButtonGroup();
        ratingButtons.add(radbtn1);
        ratingButtons.add(radbtn2);
        ratingButtons.add(radbtn3);
        ratingButtons.add(radbtn4);
        ratingButtons.add(radbtn5);

        // add them to the ArrayList
        buttons = new ArrayList<>();
        buttons.add(radbtn1);
        buttons.add(radbtn2);
        buttons.add(radbtn3);
        buttons.add(radbtn4);
        buttons.add(radbtn5);

        // By using for loop, add action listener to each JRadioButton with the function to change rating
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    changeRating(currentImage);

                }
            });
        }

        // This is the panel for thumbnails
        panelThumbnails = new JPanel();
        panelThumbnails.setLayout(new BoxLayout(panelThumbnails, BoxLayout.Y_AXIS)); // Align them by Y-axis
        frame.getContentPane().add(panelThumbnails, BorderLayout.WEST);

        // initialize 5 JLabels
        thumbnailLabel1 = new JLabel();
        thumbnailLabel2 = new JLabel();
        thumbnailLabel3 = new JLabel();
        thumbnailLabel4 = new JLabel();
        thumbnailLabel5 = new JLabel();

        // Add them to the ArrayList
        thumbnails = new ArrayList<>();
        thumbnails.add(thumbnailLabel1);
        thumbnails.add(thumbnailLabel2);
        thumbnails.add(thumbnailLabel3);
        thumbnails.add(thumbnailLabel4);
        thumbnails.add(thumbnailLabel5);

        // set icon and add mouse listener to each thumbnail
        makeEachThumbnailFunctional(thumbnails);

        // This is the panel for displaying the current image
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // try-catch box for IOException
        try {
            mainImage = new JLabel(new ImageIcon(ImageIO.read(imageAlbum.getPhotos().get(0).getImageFile())));
            mainPanel.add(mainImage);
        } catch (IOException e1) {

            e1.printStackTrace();
        }
    }

    /**
     * This helper function is used to scale image for thumbnail
     * 
     * @param i the image need to be scaled
     * @return the image of desired size
     */
    private Image rescale(BufferedImage i) {
        Image desiredImage = i.getScaledInstance(80, 50, java.awt.Image.SCALE_SMOOTH);
        return desiredImage;
    }

    /**
     * This helper function is used to set photo as icon of JLabel(thumbnail)
     * 
     * @param p the photo to be set as icon
     * @param l the JLabel where the icon is set
     */
    private void setThumbnail(Photograph p, JLabel l) {
        // try-catch box for IOException
        try {
            BufferedImage image = ImageIO.read(p.getImageFile());
            Image imageAfter = rescale(image);
            l.setIcon(new ImageIcon(imageAfter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This helper function is used to display the photo in the main panel
     * 
     * @param p the photo to be displayed in the main panel
     */
    // try-catch box for IOException
    private void setMain(Photograph p) {
        try {
            BufferedImage image = ImageIO.read(p.getImageFile());
            mainImage.setIcon(new ImageIcon(image));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This helper function is used to set icon and add mouse listener to each thumbnail.
     * 
     * @param thumbnails The array list of thumbnails(JLabel)
     */
    private void makeEachThumbnailFunctional(ArrayList<JLabel> thumbnails) {
        for (int i = 0; i < thumbnails.size(); i++) {    // By using for loop, we add each image to each JLabel(thumbnail)
            Photograph p = imageAlbum.getPhotos().get(i);
            setThumbnail(p, thumbnails.get(i));
            thumbnails.get(i).addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent event) {  // Add mouse listener to make sure to display the
                                                              // photo when clicking the thumbnail
                    try {
                        setMain(p);
                        setRatingButton(p);
                        currentImage = p;
                        imageIndex = imageAlbum.getPhotos().indexOf(p);
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }
                }
            });
            thumbnails.get(i)
                    .setText("Caption: " + p.getCaption() + ", Date Taken: " + p.getDateTaken() + ", Rating: " + p.getRating());
            panelThumbnails.add(thumbnails.get(i));
        }
    }

    /**
     * This helper function is used to select the corresponding JRadioButton.
     * 
     * @param p the photo's rating to be set
     */
    private void setRatingButton(Photograph p) {
        int rating = p.getRating();
        for (int i = 0; i < buttons.size(); i++) {
            if (Integer.valueOf(buttons.get(i).getText()) == rating) {
                buttons.get(i).setSelected(true);
            }
        }
    }

    /**
     * This helper function is used to change rating when we select a new JRadioButton
     * 
     * @param p the photo's rating to be changed
     */
    private void changeRating(Photograph p) {
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                int newRating = Integer.valueOf(buttons.get(i).getText());
                p.setRating(newRating);
                thumbnails.get(imageIndex).setText(
                        "Caption: " + p.getCaption() + ", Date Taken: " + p.getDateTaken() + ", Rating: " + p.getRating());
            }
        }
    }

}
