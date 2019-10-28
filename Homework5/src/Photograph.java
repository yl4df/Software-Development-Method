import java.awt.Image;
import java.io.File;

/**
 * Homework 5 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */
public class Photograph implements Comparable<Photograph> {

    /**
     * Holds the caption, the filename, the date and the rating of the Photograph
     */
    private String caption;
    final private String filename;
    private String dateTaken;
    private int rating;
    private File imageFile;

    /**
     * Constructors
     */
    public Photograph() {
        caption = "Cute";
        filename = "My Pet";
        dateTaken = "2017-12-20";
        rating = 5;
        imageFile = new File("filename");

    }

    public Photograph(String caption, String filename) {
        this.caption = caption;
        this.filename = filename;
        dateTaken = "2017-12-20";
        rating = 5;
        imageFile = new File(filename);
    }

    public Photograph(String caption, String filename, String dateTaken, int rating) {

        this.caption = caption;
        this.filename = filename;
        this.dateTaken = dateTaken;
        this.rating = rating;
        imageFile = new File(filename);
    }

    /**
     * Getter of caption
     * 
     * @return caption
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     * Getter of filename
     * 
     * @return filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Getter of dateTaken
     * 
     * @return dateTaken
     */
    public String getDateTaken() {
        return this.dateTaken;
    }

    /**
     * Getter of rating
     * 
     * @return rating
     */
    public int getRating() {
        return this.rating;
    }
    
    /**
     * Getter of image file
     * 
     * @return image file
     */
    public File getImageFile() {
        return this.imageFile;
    }

    /**
     * Setter of rating
     * 
     * @param rating to set
     */
    public void setRating(int rating) {
        if (rating <= 5 && rating >= 0) {
            this.rating = rating;
        }
    }

    /**
     * Setter of caption
     * 
     * @param caption to set
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * Setter of image file
     * 
     * @param imageFile to set
     */
    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public int hashCode() {
        return (this.caption + "---" + this.filename).hashCode();
    }

    /**
     * Check whether two Photographs are equal according to their captions and filenames
     * 
     * @return true or false depends on whether they have the same caption and filename
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Photograph) {
            Photograph otherObject = (Photograph) o;

            if (this.caption == otherObject.getCaption() && this.filename == otherObject.getFilename()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * toString method for photograph
     * 
     * @return the desired string to be displayed 
     */
    public String toString() {
        return "Filename: " + this.filename + ", Caption: " + this.caption + ".";
    }

    /**
     * Compares the dateTaken of the current Photograph object with the parameter p.
     * 
     * @param photograph p to be compared with
     * @return If the current object’s dateTaken is before p’s, return a negative number. If p’s is earlier, return a
     *         positive number. If they are equal, return the comparison of the this object’s caption with p’s caption.
     */
    public int compareTo(Photograph p) {
        if (this.getDateTaken().equals(p.getDateTaken())) {
            return this.getCaption().compareTo(p.getCaption());
        }
        return this.getDateTaken().compareTo(p.getDateTaken());
    }

    public static void main(String[] args) {
        Photograph ph1 = new Photograph();
        Photograph ph2 = new Photograph("Cute", "My Pet");
        Photograph ph3 = new Photograph("Strong", "My Dad");

        // test toString()
        System.out.println("ph1: " + ph1);
        System.out.println("ph2: " + ph2);
        System.out.println("ph3: " + ph3);

        // test equals(Object o)
        System.out.println("ph1 equals ph2: " + ph1.equals(ph2));
        System.out.println("ph1 equals ph3: " + ph1.equals(ph3));

    }
}
