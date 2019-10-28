/**
 * Homework 2 
 * Yunlu Li, yl4df 
 * 
 * Sources: Big Java Book, Lecture Notes
 */
public class Photograph {

    /**
     * Holds the caption and the filename of the Photograph
     */
    final private String caption;
    final private String filename;

    /**
     * Constructors
     */
    public Photograph() {
        caption = "Cute";
        filename = "My Pet";
    }

    public Photograph(String caption, String filename) {
        this.caption = caption;
        this.filename = filename;
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
     * Getter of Filename
     * 
     * @return filename
     */
    public String getFilename() {
        return this.filename;
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

    public String toString() {
        return "Caption: " + this.caption + ", Filename: " + this.filename + ".";
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
