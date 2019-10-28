import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class testReview {
    
    public static int numsCount(int input,ArrayList list) {
        int count;
        for(int i; i<=list.size();i++) {
            if(list[i]==input) {
                count++;
            }
        }
        return count
    }
 
    public static void main(String []args) {
      
    TreeSet<String> test = new TreeSet<String>();
    test.add("L");
    test.add("E");
    test.add("T");
    System.out.println(test);      
          
        

    }
}
