import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;

/**
   Counts how many words all files (books) -- SOLUTION to Concurrency In-Class Activity (Day 2; using locks)
 */
public class WordCountRunnable implements Runnable // WordCountRunnable needs to implement the Runnable Interface (we write run() method)
{
    private String filename;

    // add 'threadCount' and 'combinedWordCount' counts (just ints) [static variables]
    // add 'threadCountLock' and 'combinedWordCountLock' Lock objects [static objects]
    public static int threadCount, combinedWordCount;
    public static Lock threadCountLock, combinedWordCountLock;
    
    /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count word
     */
    public WordCountRunnable(String aFilename)
    {
        filename = aFilename;
        threadCountLock = new ReentrantLock(); // finish proper instantiation of 'threadCountLock' and 'combinedWordCountLock' Lock objects
        combinedWordCountLock = new ReentrantLock();
    }

    public void run()
    {
        // To know when a thread is STARTING, increment the 'threadCount' counter at the START of the run() method
        // Remember, 'threadCount' is a shared variable, so surround it with threadCountLock lock() and unlock()
        threadCountLock.lock();
        threadCount++;
        threadCountLock.unlock();
        
        int count = 0;
        try
        {
            Scanner in = new Scanner(new FileInputStream(filename)); // create a Scanner object to go through the input file 'filename'

            while (in.hasNext()) // are there words left in the file?
            {
                in.next(); // consume the word
                count++;   // count the word
            }
            in.close(); // important: close the scanner
        } 
        catch (FileNotFoundException e) // catch a FileNotFoundException exception incase the file doesn't exist
        {
            System.out.println(filename + " not found!");
        }
        System.out.println(filename + ": " + count); // count how many words are in a particular file (book)

        combinedWordCountLock.lock();   // using 'combinedWordCount' which is a shared resource, so in this section
                                        // combinedWordCountLock should lock() and unlock()
        combinedWordCount += count; // accumulate the count of each book: add 'count' to 'combinedWordCount'
        threadCountLock.lock();
        threadCount--; // To know when a thread is ENDING, decrement the 'threadCount' counter near the END of the run() method
        if(threadCount <1) // ONLY when the LAST thread is about to end (exit)... (so check threadCount < 1)
            System.out.println("Combined Total: " + combinedWordCount); // ... print the total number of words in ALL books (combinedWordCount)
        threadCountLock.unlock();
        combinedWordCountLock.unlock();
    }
}