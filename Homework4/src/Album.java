
/**
 * Homework 4 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;

public class Album extends PhotographContainer {

    /**
     * Constructors
     */
    public Album() {
        name = "Album1";
        photos = new ArrayList<>();
    }

    public Album(String name) {
        this.name = name;
        this.photos = new ArrayList<>();

    }
}
