//

public class Taxi {
		
    /*
     * Put global fields here.
     */
    private double rate;
    private int capacity;
    private int passengers;

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        /*
         * Initialize global fields.
         * These values will never be changed because the constructor has no parameters.
         */
	    rate = 5.0;
	    capacity = 4;
	    passengers = 0;
	}
	
	public Taxi(double rate, int capacity) {
        /*
         * Initialize global fields.
         * These values can be changed via constructor parameters.
         */
	    this.rate = rate;
	    this.capacity = capacity;
	    this.passengers = 0;
	}
	
	public double calculateFare(int passengersLeaving, int durationOfRide) {
        /*
         * Your method implementation goes here.
         */
	    this.passengers -= passengersLeaving;
	    return rate*durationOfRide;
	}
	
	public boolean pickUp(int passengersLoading) {
        /*
         * Your method implementation goes here.
         */
	    
	    if(this.passengers+passengersLoading <= capacity) {
	        return true;
	    }else {
	        return false;
	    }
	}

}
