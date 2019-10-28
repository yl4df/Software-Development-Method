
/**
 * Homework 5 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */

import java.util.ArrayList;

public abstract class PhotographContainer {

    /**
     * Holds the name and the photos of the photograph container(Album or PhotoLibrary)
     */
    protected String name;
    protected ArrayList<Photograph> photos;

    /**
     * Constructors
     */
    public PhotographContainer() {
        name = "Album1";
        photos = new ArrayList<>();
    }

    public PhotographContainer(String name) {
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

    /**
     * Override toSting method for better printing result
     * 
     * @return desired printing result
     */
    public String toString() {
        return "Name: " + this.name + ", Photos: " + this.photos;
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
     * Get the photos post in the given year and month. First, we rule out various situations that the date is in wrong
     * format. Then based on getPhotosInYear(), we have the list of photos in the given year. Then remove all the photos
     * which is not in the given month from the list.
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
     * Get the photos post between the two dates.First, we rule out various situations that the date is in wrong format.
     * Then based on different situations, we pull out the photos whose date is in between.
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

}
