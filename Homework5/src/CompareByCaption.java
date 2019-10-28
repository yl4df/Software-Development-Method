
/**
 * Homework 5 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */
import java.util.Comparator;

public class CompareByCaption implements Comparator<Photograph> {

    /**
     * Compares two Photographs by caption (in alphabetical order). If two captions are identical, then compare
     * by rating,in descending order with the highest-rated photo first.
     * 
     * @param the two Photographs to be compared
     * @return If the p1’s caption is before p2’s, return a negative number. If p2’s is earlier, return a positive number.
     *         If they are equal, return the comparison of the p1’s rating with p2’s rating.
     */
    public int compare(Photograph p1, Photograph p2) {
        if (p1.getCaption().equals(p2.getCaption())) {
            return p2.getRating() - p1.getRating();
        }
        return p1.getCaption().compareTo(p2.getCaption());
    }
}
