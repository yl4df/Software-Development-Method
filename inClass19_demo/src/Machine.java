import java.util.ArrayList;

public class Machine {
     
    ArrayList<Payments> sales = new ArrayList<>();
    public static void main(String[] args) {
         Machine testMachine = new Machine();
         
         Visa myCard = new Visa();
          if(myCard.hasSufficientFunds(2000)) {
              testMachine.sales.add(myCard);
          }
          System.out.println("success!");
    }
    
}
