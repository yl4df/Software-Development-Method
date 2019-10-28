import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *  Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable{
   private String filename;
   
   /**
    * Constructs a WordCountRunnable object with a file name.
    * @param aFilename the file name that needs to count words
    */
   public WordCountRunnable(String aFilename) {
      filename = aFilename;
   }

   public void run() {
      //add your code here
       int count = 0;
      
           Scanner sca = new Scanner(filename);
           while(sca.hasNext()) {
               sca.next();
               count++;
        System.out.println(count);
   }
   }
}
