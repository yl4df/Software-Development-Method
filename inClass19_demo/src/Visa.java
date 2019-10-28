

public class Visa implements Payments{
    double limit;
    
    public Visa() {
        limit = 1000;
    }
    
    public boolean hasSufficientFunds(double amount) {
        if(amount < limit) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
