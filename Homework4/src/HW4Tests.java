
/**
 * Homework 4 Yunlu Li, yl4df Sources: Big Java Book, Lecture Notes
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class HW4Tests {

    Photograph photo1 = new Photograph("My Dad", "Strong", "2018-07-21", 4);
    Photograph photo2 = new Photograph("My Pet", "Cute", "2019-02-10", 5);
    Photograph photo3 = new Photograph("My Grade", "Nice", "2019-01-15", 3);
    Photograph photo4 = new Photograph("Yellow Stone National Park", "Great", "2018-01-29", 3);

    PhotoLibrary p1 = new PhotoLibrary("Chris", 2230709);
    PhotoLibrary p2 = new PhotoLibrary("Michael", 2290703);

    // Test removePhoto method
    @Test
    public void testRemovePhoto1() {
        p1.addPhoto(photo1);
        p1.addPhoto(photo2);
        p1.addPhoto(photo3);
        p1.addPhoto(photo4);
        p1.createAlbum("album1");
        p1.addPhotoToAlbum(photo1, "album1");
        p1.addPhotoToAlbum(photo2, "album1");
        p1.removePhoto(photo2);
        assertTrue(!p1.hasPhoto(photo2));
        for (Album album : p1.getAlbums()) {
            assertTrue(!album.hasPhoto(photo2));
        }
    }

    // Test removePhoto method
    @Test
    public void testRemovePhoto2() {
        p1.addPhoto(photo1);
        p1.addPhoto(photo2);
        p1.addPhoto(photo3);
        p1.addPhoto(photo4);
        p1.createAlbum("album1");
        p1.addPhotoToAlbum(photo1, "album1");
        p1.addPhotoToAlbum(photo2, "album1");
        p1.removePhoto(photo3);
        assertTrue(!p1.hasPhoto(photo3));
        for (Album album : p1.getAlbums()) {
            assertFalse(!album.hasPhoto(photo1));
        }
    }

    // Test compareTo method
    @Test
    public void testCompareTo1() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        Collections.sort(testList);
        assertTrue(testList.get(0) == photo1 && testList.get(1) == photo2);
    }

    // Test compareTo method
    @Test
    public void testCompareTo2() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        testList.add(photo3);
        testList.add(photo4);
        Collections.sort(testList);
        assertTrue(
                testList.get(0) == photo4 && testList.get(1) == photo1 && testList.get(2) == photo3 && testList.get(3) == photo2);
    }

    // Test compare method in class CompareByCaption
    @Test
    public void testCompareByCaption1() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        Collections.sort(testList, new CompareByCaption());
        assertTrue(testList.get(0) == photo2 && testList.get(1) == photo1);
    }

    // Test compare method in class CompareByCaption
    @Test
    public void testCompareByCaption2() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        testList.add(photo3);
        testList.add(photo4);
        Collections.sort(testList, new CompareByCaption());
        assertTrue(
                testList.get(0) == photo2 && testList.get(1) == photo4 && testList.get(2) == photo3 && testList.get(3) == photo1);
    }

    // Test compare method in class CompareByRating
    @Test
    public void testCompareByRating1() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        Collections.sort(testList, new CompareByRating());
        assertTrue(testList.get(0) == photo2 && testList.get(1) == photo1);
    }

    // Test compare method in class CompareByRating
    @Test
    public void testCompareByRating2() {
        ArrayList<Photograph> testList = new ArrayList<>();
        testList.add(photo1);
        testList.add(photo2);
        testList.add(photo3);
        testList.add(photo4);
        Collections.sort(testList, new CompareByRating());
        assertTrue(
                testList.get(0) == photo2 && testList.get(1) == photo1 && testList.get(2) == photo4 && testList.get(3) == photo3);
    }
}
