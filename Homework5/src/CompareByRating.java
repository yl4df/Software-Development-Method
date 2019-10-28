
/**
 * Homework 5 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */
import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph> {

    /**
     * Compares two Photographs by rating (in descending order). If two ratings are identical, then compare by caption in
     * alphabetical order.
     * 
     * @param the two Photographs to be compared
     * @return If the p1’s rating is higher than p2’s, return a negative number. If p2’s is higher, return a positive
     *         number. If they are equal, return the comparison of the p1’s caption with p2’s caption.
     */
    public int compare(Photograph p1, Photograph p2) {
        if (p1.getRating() == p2.getRating()) {
            return p1.getCaption().compareTo(p2.getCaption());
        }
        return p2.getRating() - p1.getRating();
    }
}
