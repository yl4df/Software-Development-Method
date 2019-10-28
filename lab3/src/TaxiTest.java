import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;


public class TaxiTest {

    //pickUp() test #1
    @Test(timeout=100)
    public void testPickUpSuccess() {
        Taxi t = new Taxi(12.00, 5);
        assertTrue(t.pickUp(5));
    }
    
    //calculateFare() test #1
    @Test(timeout=100)
    public void testCalculateFare() {
        /*
         * Your test implementation goes here.
         */
        Taxi t = new Taxi(12.00, 5);
        assertTrue(120==t.calculateFare(5, 10));
    }
    
    //pickUp() test #2
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
        /*
         * Make sure pickUp() returns true when you try to pick up some
         * number of passengers within capacity.
         */
        Taxi t = new Taxi(12,5);
        assertFalse(t.pickUp(6));
    }
    
  //calculateFare() test #2
    @Test(timeout=100)
    public void testCalculateFare2() {
        /*
         * Your test implementation goes here.
         */
        Taxi t = new Taxi(13.00, 5);
        assertTrue(130==t.calculateFare(5, 10));
    }  
      
}