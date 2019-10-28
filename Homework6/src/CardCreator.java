import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 Card Creator This class defines the thread task that will "come up with" and submit greeting card ideas to
 * the print queue. We have added the code necessary to read from the file, but it's up to you to handle turning off the
 * printer (keeping track of how many threads are open) and adding the read-in line from the inspiration file to the
 * queue.
 * 
 * @author YOURID yl4df
 * Sources: Big Java Book, Lecture Notes
 */
public class CardCreator implements Runnable {

    /**
     * Print queue to add new card ideas
     */
    private PrintQueue printQueue;

    /**
     * Inspiration file name
     */
    private String filename;

    /**
     * The number of running threads
     */
    private static int threadCount;

    /**
     * The lock for counting threads
     */
    private ReentrantLock threadCountLock = new ReentrantLock();

    /**
     * Constructor
     */
    public CardCreator(PrintQueue d, String filename) {
        printQueue = d;
        this.filename = filename;
    }

    /**
     * Run method that is the main method for the thread
     */
    @Override
    public void run() {
        Scanner s = null;

        threadCountLock.lock();
        threadCount++;   // increment the threadCount when a new thread is started
        threadCountLock.unlock();
        try {
            s = new Scanner(new FileReader(filename));
            while (s.hasNextLine()) {
                printQueue.enqueue(s.nextLine()); // Enqueue the line into the print queue
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            System.out.println("Could not read file");
        } catch (InterruptedException e) {
            // do nothing but exit
        } finally {
            if (s != null)
                s.close();

        }

        threadCountLock.lock();
        threadCount--;   // decrement the threadCount when a new thread is finished
        threadCountLock.unlock();

        if (threadCount == 0) {     // if this is the last thread, we turn off the print queue.
            printQueue.turnOff();
        }
    }

}
