  
/**
 * Homework 3 
 * Yunlu Li, yl4df 
 * Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;
import java.util.HashSet;

public class PhotoLibrary {

    /**
     * Holds the name, id, and photos of the person
     */
    private String name;
    final private int id;
    private ArrayList<Photograph> photos;
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
     * Get the photos with rating above than given.
     * 
     * @param rating The threshold of rating.
     * @return the list of photos with rating above than given
     */
    public ArrayList<Photograph> getPhotos(int rating) {
        ArrayList<Photograph> resultList = new ArrayList<>();
        for (Photograph photo : photos) {
            if (rating < 0 || rating > 5) {
                return null;
            } else if (photo.getRating() >= rating) {
                resultList.add(photo);
            }
        }
        return resultList;
    }

    /**
     * Get the photos post in the given year
     * 
     * @param year in which the photo was post.
     * @return the list of photos post in the given year
     */
    public ArrayList<Photograph> getPhotosInYear(int year) {
        ArrayList<Photograph> resultList = new ArrayList<>();
        for (Photograph photo : photos) {
            String[] dateList = photo.getDateTaken().split("-");
            if (dateList.length != 3) {
                return null;
            } else {
                int yearTaken = Integer.parseInt(dateList[0]);
                if (year > 2019 || year < 0 || yearTaken > 2019 || yearTaken < 0) {
                    return null;
                } else if (yearTaken == year) {
                    resultList.add(photo);
                }
            }
        }
        return resultList;
    }

    /**
     * Get the photos post in the given year and month. First, we rule out various situations that 
     * the date is in wrong format. Then based on getPhotosInYear(), we have the list of photos in
     * the given year. Then remove all the photos which is not in the given month from the list.
     * 
     * @param month in which the photo was post.
     * @param year  in which the photo was post.
     * @return the list of photos post in the given year and month
     */
    public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
        if (month > 12 || month < 1 || year > 2019 || year < 1000) {
            return null;
        }
        ArrayList<Photograph> yearList = getPhotosInYear(year);
        ArrayList<Photograph> resultList = getPhotosInYear(year);
        for (Photograph photo : yearList) {
            String[] dateList = photo.getDateTaken().split("-");
            if (dateList.length != 3) {
                return null;
            } else {
                int monthTaken = Integer.parseInt(dateList[1]);
                if (monthTaken > 12 || monthTaken < 1) {
                    return null;
                } else if (monthTaken != month) {
                    resultList.remove(photo);
                }
            }
        }
        return resultList;
    }

    /**
     * Get the photos post between the two dates.First, we rule out various situations that 
     * the date is in wrong format. Then based on different situations, we pull out the photos 
     * whose date is in between. 
     * 
     * @param beginDate Date of beginning
     * @param endDate   Date of ending
     * @return the list of photos post between the two dates
     */
    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {

        ArrayList<Photograph> resultList = new ArrayList<>();
        for (Photograph photo : photos) {
            String[] dateList1 = beginDate.split("-");
            String[] dateList2 = endDate.split("-");

            if (dateList1.length != 3 || dateList2.length != 3) {
                return null;
            } else {
                int yearBegin = Integer.parseInt(dateList1[0]);
                int monthBegin = Integer.parseInt(dateList1[1]);
                int dayBegin = Integer.parseInt(dateList1[2]);
                int yearEnd = Integer.parseInt(dateList2[0]);
                int monthEnd = Integer.parseInt(dateList2[1]);
                int dayEnd = Integer.parseInt(dateList2[2]);
                if (yearBegin > 2019 || yearBegin < 1000 || monthBegin < 1 || monthBegin > 12 || dayBegin > 31 || dayBegin < 1

                        || yearEnd > 2019 || yearEnd < 1000 || monthEnd < 1 || monthEnd > 12 || dayEnd > 31 || dayEnd < 1
                        || yearBegin > yearEnd || (yearBegin == yearEnd && monthBegin > monthEnd)
                        || (yearBegin == yearEnd && monthBegin == monthEnd && dayBegin > dayEnd)) {
                    return null;
                }

                String[] dateList = photo.getDateTaken().split("-");
                if (dateList.length != 3) {
                    return null;
                } else {
                    int yearTaken = Integer.parseInt(dateList[0]);
                    int monthTaken = Integer.parseInt(dateList[1]);
                    int dayTaken = Integer.parseInt(dateList[2]);
                    if (yearTaken > 2019 || yearTaken < 0 || monthTaken > 12 || monthTaken < 1 || dayTaken > 31 || dayTaken < 1) {
                        return null;
                    } else if (yearBegin == yearEnd) {
                        if (monthBegin == monthEnd) {
                            if (yearTaken == yearBegin && monthTaken == monthBegin && dayTaken >= dayBegin
                                    && dayTaken <= dayEnd) {
                                resultList.add(photo);
                            }
                        } else {
                            if (yearTaken == yearBegin && monthTaken > monthBegin && monthTaken < monthEnd) {
                                resultList.add(photo);
                            } else if (yearTaken == yearBegin && monthTaken == monthBegin && dayTaken >= dayBegin) {
                                resultList.add(photo);
                            } else if (yearTaken == yearBegin && monthTaken == monthEnd && dayTaken <= dayEnd) {
                                resultList.add(photo);
                            }
                        }
                    } else {
                        if (yearTaken > yearBegin && yearTaken < yearEnd) {
                            resultList.add(photo);
                        } else if (yearTaken == yearBegin && monthTaken > monthBegin) {
                            resultList.add(photo);
                        } else if (yearTaken == yearBegin && monthTaken == monthBegin && dayTaken >= dayBegin) {
                            resultList.add(photo);
                        } else if (yearTaken == yearEnd && monthTaken < monthEnd) {
                            resultList.add(photo);
                        } else if (yearTaken == yearEnd && monthTaken == monthEnd && dayTaken <= dayEnd) {
                            resultList.add(photo);
                        }

                    }

                }
            }
        }
        return resultList;
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

    /**
     * Remove the photo from the list of photos as well as from albums
     * 
     * @param p the photo
     * @return whether the photo was removed
     */
    public boolean erasePhoto(Photograph p) {
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

        p1.takePhoto(ph1);
        p1.takePhoto(ph3);
        p1.takePhoto(ph5);
        p1.takePhoto(ph6);

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
