
/**
 * Homework 4 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;
import java.util.HashSet;

public class PhotoLibrary extends PhotographContainer {

    /**
     * Holds the id and albums of the PhotoLibrary
     */

    final private int id;

    private HashSet<Album> albums;

    /**
     * Constructors
     */
    public PhotoLibrary() {
        name = "Michael";
        id = 2290703;
        photos = new ArrayList<Photograph>();
        albums = new HashSet<Album>();
    }

    public PhotoLibrary(String name, int id) {
        this.name = name;
        this.id = id;
        photos = new ArrayList<Photograph>();
        albums = new HashSet<Album>();
    }

    /**
     * Getter of id
     * 
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter of albums
     * 
     * @return albums
     */
    public HashSet<Album> getAlbums() {
        return this.albums;
    }

    /**
     * Setter of name
     * 
     * @param a The updated name of the person
     */
    public void setName(String a) {
        this.name = a;
    }

    /**
     * Check whether two Persons are equal according to their id
     * 
     * @return true or false depends on whether they have the same id
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof PhotoLibrary) {
            PhotoLibrary otherPerson = (PhotoLibrary) o;
            if (this.id == otherPerson.getId()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Name: " + this.name + ", ID: " + this.id + ", Photos: " + this.photos + "." + ", Albums: " + this.albums;
    }

    /**
     * Get the photos that Person a and Person b have in common, and return a list of the common photographs
     * 
     * @param a Person a's photos to be compared
     * @param b Person b's photos to be compared
     * @return The list of the common photographs
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
        ArrayList<Photograph> list = new ArrayList<Photograph>();
        for (Photograph a_photo : a.photos) {
            for (Photograph b_photo : b.photos) {
                if (a_photo.equals(b_photo)) {
                    list.add(a_photo);
                }
            }
        }
        return list;
    }

    /**
     * Calculate the similarity between the photographs posted by a and the photographs posted by b.
     * 
     * @param a a Person a's photos to be compared
     * @param b Person b's photos to be compared
     * @return 0.0 if either person has not posted any photographs. Otherwise, it is the number of photographs common to
     *         both people divided by smaller of the number of photos posted by a and the number of photos posted by b.
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        if (a.photos.size() == 0 || b.photos.size() == 0) {
            return 0.0;
        } else {
            int numCommonPhotos = commonPhotos(a, b).size();
            double denominator = Math.min(a.numPhotographs(), b.numPhotographs());
            return numCommonPhotos / denominator;
        }
    }

    /**
     * Create a album based on the given name
     * 
     * @param albumName the name of the album
     * @return whether the album was created
     */
    public boolean createAlbum(String albumName) {
        Album newAlbum = new Album(albumName);
        if (!albums.contains(newAlbum)) {
            albums.add(newAlbum);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove a album based on the given name
     * 
     * @param albumName the name of the album
     * @return whether the album was removed
     */
    public boolean removeAlbum(String albumName) {
        return albums.remove(new Album(albumName));
    }

    /**
     * Add the photo to the album whose name is given.
     * 
     * @param p         the photo
     * @param albumName the name of album
     * @return whether the photo was added to the album whose name is given.
     */
    public boolean addPhotoToAlbum(Photograph p, String albumName) {
        Album album = getAlbumByName(albumName);
        if (album != null && p != null && photos.contains(p) && !album.getPhotos().contains(p)) {
            album.addPhoto(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove the photo from the album whose name is given.
     * 
     * @param p         the photo
     * @param albumName the name of album
     * @return whether the photo was removed from the album whose name is given.
     */
    public boolean removePhotoFromAlbum(Photograph p, String albumName) {
        Album album = getAlbumByName(albumName);
        if (album != null && p != null && album.getPhotos().contains(p)) {
            album.getPhotos().remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the album based on the given name
     * 
     * @param albumName the name of album
     * @return the album whose name is given
     */
    private Album getAlbumByName(String albumName) {
        for (Album album : albums) {
            if (album.getName() == albumName) {
                return album;
            }
        }
        return null;
    }

    @Override
    /**
     * Remove the photo from the list of photos as well as from albums; Override removePhoto method from PhotographContainer
     * 
     * @param p the photo
     * @return whether the photo was removed
     */
    public boolean removePhoto(Photograph p) {
        if (hasPhoto(p)) {
            photos.remove(p);
            for (Album album : albums) {
                if (album.getPhotos().contains(p)) {
                    album.getPhotos().remove(p);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        PhotoLibrary p1 = new PhotoLibrary();
        PhotoLibrary p2 = new PhotoLibrary("Chris", 2230709);
        PhotoLibrary p3 = new PhotoLibrary("Michael", 2290703);

        Photograph ph1 = new Photograph();
        Photograph ph2 = new Photograph("Cute", "My Pet");
        Photograph ph3 = new Photograph("Strong", "My Dad");
        Photograph ph5 = new Photograph("Great", "Yellow Stone Nation Park");
        Photograph ph6 = new Photograph("Nice", "My Grade");

        p1.addPhoto(ph1);
        p1.addPhoto(ph3);
        p1.addPhoto(ph5);
        p1.addPhoto(ph6);

        p2.addPhoto(ph1);
        p2.addPhoto(ph3);
        p2.addPhoto(ph5);

        // test toString()
        System.out.println("Person 1: " + p1);
        System.out.println("Person 2: " + p2);
        System.out.println("Person 3: " + p3);

        // test equals(Object o):
        System.out.println("Is Person 1 equal to Person 2: " + p1.equals(p2));
        System.out.println("Is Person 1 equal to Person 3: " + p1.equals(p3));

        // test takePhoto(Photograph p)
        System.out.println("Is ph6 added to Person 1's photos: " + p1.addPhoto(ph6));
        System.out.println("Is ph2 added to Person 1's photos: " + p1.addPhoto(ph2));

        // test hasPhoto(Photograph p)
        System.out.println("Does Person 2 has ph2: " + p2.hasPhoto(ph2));
        System.out.println("Does Person 2 has ph6: " + p2.hasPhoto(ph6));

        // test erasePhoto(Photograph p)
        System.out.println("Can ph1 be deleted from Person 1's photos: " + p1.removePhoto(ph1));
        System.out.println("Can ph3 be deleted from Person 1's photos: " + p1.removePhoto(ph3));

        // test numPhotographs()
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("How many photographs does Person 1 have: " + p1.numPhotographs());
        System.out.println("How many photographs does Person 1 have: " + p2.numPhotographs());

        // test commonPhotos(Person a, Person b)
        System.out.println("Photographs that Person 1 and Person 2 have in common: " + commonPhotos(p1, p2));
        System.out.println("Photographs that Person 1 and Person 3 have in common: " + commonPhotos(p1, p3));

        // test similarity(Person a, Person b)
        System.out.println(similarity(p1, p2));
        System.out.println(similarity(p1, p3));

    }
}
