
/**
 * Homework 3 
 * Yunlu Li, yl4df 
 * Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;

public class Album {

    /**
     * Holds the name and photos of the album
     */
    private String name;
    private ArrayList<Photograph> photos;

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

    /**
     * Getter of name
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of photos
     * 
     * @return photos
     */
    public ArrayList<Photograph> getPhotos() {
        return this.photos;
    }

    /**
     * Setter of name
     * 
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Add the photo to the album
     * 
     * @param p The photo to be added
     * @return whether the photo is added
     */
    public boolean addPhoto(Photograph p) {
        if (p != null && !this.photos.contains(p)) {
            this.photos.add(p);
            return true;
        } else if (p == null) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * Check whether the photo is in the album
     * 
     * @param p The photo to be checked
     * @return whether the photo is in the album
     */
    public boolean hasPhoto(Photograph p) {
        return photos.contains(p);
    }

    /**
     * Remove the photo from the album
     * 
     * @param p The photo to be removed
     * @return whether the photo is removed
     */
    public boolean removePhoto(Photograph p) {
        return photos.remove(p);
    }

    /**
     * To see how many photos in the album
     * 
     * @return the number of photos in the album
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Check whether two Albums are equal
     * 
     * @return whether two Albums are equal
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Album) {
            Album otheralbum = (Album) o;
            if (this.name == otheralbum.getName()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Name: " + this.name + ", Photos: " + this.photos;
    }

}
