/**
 * Homework 3 
 * Yunlu Li, yl4df 
 * 
 * Sources: Big Java Book, Lecture Notes
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Tester {

    Photograph photo1 = new Photograph("Strong", "My Dad", "2018-07-21", 4);
    Photograph photo2 = new Photograph("Cute", "My Pet", "2019-02-10", 5);
    Photograph photo3 = new Photograph("Nice", "My Grade", "2019-01-15", 3);
    Photograph photo4 = new Photograph("Great", "Yellow Stone National Park", "2018-01-29", 3);

    PhotoLibrary p1 = new PhotoLibrary("Chris", 2230709);
    PhotoLibrary p2 = new PhotoLibrary("Michael", 2290703);

    /**
     * Tester for getPhotos(). The method successfully returns a list of photos with rating greater or equal to 4.
     */
    @Test(timeout = 100)
    public void testGetPhotos1() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> expectList = new ArrayList<>();
        expectList.add(photo1);
        expectList.add(photo2);
        ArrayList<Photograph> testList = p1.getPhotos(4);
        assertTrue(expectList.equals(testList));
    }

    /**
     * Tester for getPhotos(). The method successfully returns null as a result of invalid rating.
     */
    @Test(timeout = 100)
    public void testGetPhotos2() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> testList = p1.getPhotos(6);
        assertNull(testList);
    }

    /**
     * Tester for getPhotosInMonth(). The method successfully returns the list of photos post in January 2019.
     */
    @Test(timeout = 100)
    public void testGetPhotosInMonth1() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> expectList = new ArrayList<>();
        expectList.add(photo3);
        ArrayList<Photograph> testList = p1.getPhotosInMonth(1, 2019);
        assertTrue(expectList.equals(testList));
    }

    /**
     * Tester for getPhotos(). The method successfully returns null as a result of invalid month.
     */
    @Test(timeout = 100)
    public void testGetPhotosInMonth2() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> testList = p1.getPhotosInMonth(13, 2018);
        assertNull(testList);
    }

    /**
     * Tester for getPhotosBetween(). The method successfully returns the list of photos post between 2018-02-29 and
     * 2019-01-15.
     */
    @Test(timeout = 100)
    public void testGetPhotosBetween1() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> expectList = new ArrayList<>();
        expectList.add(photo1);
        expectList.add(photo3);
        ArrayList<Photograph> testList = p1.getPhotosBetween("2018-02-29", "2019-01-15");
        assertTrue(expectList.equals(testList));
    }

    /**
     * Tester for getPhotos(). The method successfully returns null as a result of invalid date.
     */
    @Test(timeout = 100)
    public void testGetPhotosBetween2() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        ArrayList<Photograph> testList = p1.getPhotosBetween("202-03-29", "2018-02-15");
        assertNull(testList);
    }

    /**
     * Tester for erasePhoto(). The method successfully remove the photo from photos and albums.
     */
    @Test(timeout = 100)
    public void testErasePhoto1() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        p1.createAlbum("album1");
        p1.addPhotoToAlbum(photo1, "album1");
        p1.addPhotoToAlbum(photo2, "album1");
        p1.erasePhoto(photo2);
        assertTrue(!p1.hasPhoto(photo2));
        for (Album album : p1.getAlbums()) {
            assertTrue(!album.hasPhoto(photo2));
        }
    }

    /**
     * Tester for erasePhoto(). The method successfully remove the photo from photos and albums.
     */
    @Test(timeout = 100)
    public void testErasePhoto2() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        p1.createAlbum("album1");
        p1.addPhotoToAlbum(photo1, "album1");
        p1.addPhotoToAlbum(photo2, "album1");
        p1.erasePhoto(photo3);
        assertTrue(!p1.hasPhoto(photo3));
        for (Album album : p1.getAlbums()) {
            assertFalse(!album.hasPhoto(photo1));
        }
    }

    /**
     * Tester for similarity(). The methods successfully returns the desire outcome 1.
     */
    @Test(timeout = 100)
    public void testSimilarity1() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        p1.takePhoto(photo3);
        p1.takePhoto(photo4);
        p2.takePhoto(photo1);
        p2.takePhoto(photo2);
        p2.takePhoto(photo3);
        assertTrue(1 == PhotoLibrary.similarity(p1, p2));
    }

    /**
     * Tester for similarity(). The method successfully returns 0 because there is no photo in p2.
     */
    @Test(timeout = 100)
    public void testSimilarity2() {
        p1.takePhoto(photo1);
        p1.takePhoto(photo2);
        assertTrue(0 == PhotoLibrary.similarity(p1, p2));
    }

}
