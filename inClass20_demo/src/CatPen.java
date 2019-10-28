import java.util.ArrayList;
import java.util.Collections;

public class CatPen {
  
    public static void main(String[] args) {
        
        ArrayList <Cat> catPen= new ArrayList<>();
        
        Cat tom = new Cat("Orange",0.25,85);
        Cat garfield = new Cat("Orange",0.5,78);
        Cat sylive = new Cat("Black",0.35,75);
        
        catPen.add(tom);
        catPen.add(garfield);
        catPen.add(sylive);
        
        Collections.sort(catPen);
        
        System.out.println(catPen);
    }
}
