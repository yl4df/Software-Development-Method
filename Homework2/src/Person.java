
/**
 * Homework 2 
 * Yunlu Li, yl4df 
 * 
 * Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;

public class Person {

    /**
     * Holds the name, id, and photos of the person
     */
    private String name;
    final private int id;
    private ArrayList<Photograph> photos;

    /**
     * Constructors
     */
    public Person() {
        name = "Michael";
        id = 2290703;
        photos = new ArrayList<Photograph>();
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
        photos = new ArrayList<Photograph>();
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
     * Getter of id
     * 
     * @return id
     */
    public int getId() {
        return this.id;
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
     * @param a The updated name of the person
     */
    public void setName(String a) {
        this.name = a;
    }

    /**
     * Add the photograph to the list of photos when it as not already in the list
     * 
     * @param p The photograph to be added
     * @return Whether the photograph is added or not
     */
    public boolean takePhoto(Photograph p) {
        if (!photos.contains(p)) {
            photos.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check whether the photograph is in the list of photos
     * 
     * @param p The photograph to be checked
     * @return Whether the photograph is in the list of photos
     */
    public boolean hasPhoto(Photograph p) {
        if (photos.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Erase the photograph if it is in the list of photos
     * 
     * @param p The photograph to be erased
     * @return Whether the photograph is erased or not
     */
    public boolean erasePhoto(Photograph p) {
        if (hasPhoto(p) == true) {
            photos.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tell us the number of photographs in the list
     * 
     * @return the number of photographs in the list
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Check whether two Persons are equal according to their id
     * 
     * @return true or false depends on whether they have the same id
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Person) {
            Person otherPerson = (Person) o;
            if (this.id == otherPerson.getId()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Name: " + this.name + ", ID: " + this.id + ", Photos: " + this.photos + ".";
    }

    /**
     * Get the photos that Person a and Person b have in common, and return a list of the common photographs
     * 
     * @param a Person a's photos to be compared
     * @param b Person b's photos to be compared
     * @return The list of the common photographs
     */
    public static ArrayList<Photograph> commonPhotos(Person a, Person b) {
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
    public static double similarity(Person a, Person b) {
        if (a.photos.size() == 0 || b.photos.size() == 0) {
            return 0.0;
        } else {
            int numCommonPhotos = commonPhotos(a, b).size();
            double denominator = Math.min(a.numPhotographs(), b.numPhotographs());
            return numCommonPhotos / denominator;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Chris", 2230709);
        Person p3 = new Person("Michael", 2290703);

        Photograph ph1 = new Photograph();
        Photograph ph2 = new Photograph("Cute", "My Pet");
        Photograph ph3 = new Photograph("Strong", "My Dad");
        Photograph ph5 = new Photograph("Great", "Yellow Stone Nation Park");
        Photograph ph6 = new Photograph("Nice", "My Grade");

        p1.takePhoto(ph1);
        p1.takePhoto(ph5);

        p2.takePhoto(ph1);
        p2.takePhoto(ph3);
        p2.takePhoto(ph5);

        // test toString()
        System.out.println("Person 1: " + p1);
        System.out.println("Person 2: " + p2);
        System.out.println("Person 3: " + p3);

        // test equals(Object o):
        System.out.println("Is Person 1 equal to Person 2: " + p1.equals(p2));
        System.out.println("Is Person 1 equal to Person 3: " + p1.equals(p3));

        // test takePhoto(Photograph p)
        System.out.println("Is ph6 added to Person 1's photos: " + p1.takePhoto(ph6));
        System.out.println("Is ph2 added to Person 1's photos: " + p1.takePhoto(ph2));

        // test hasPhoto(Photograph p)
        System.out.println("Does Person 2 has ph2: " + p2.hasPhoto(ph2));
        System.out.println("Does Person 2 has ph6: " + p2.hasPhoto(ph6));

        // test erasePhoto(Photograph p)
        System.out.println("Can ph1 be deleted from Person 1's photos: " + p1.erasePhoto(ph1));
        System.out.println("Can ph3 be deleted from Person 1's photos: " + p1.erasePhoto(ph3));

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
