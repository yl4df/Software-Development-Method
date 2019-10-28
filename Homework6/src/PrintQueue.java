import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 PrintQueue Implement the class below as specified in the homework 6 document.
 * 
 * @author yourid yl4df
 * Sources: Big Java Book, Lecture Notes
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

    private LinkedList<String> toPrint;     // the printer's list of documents
    private Lock documentChangeLock = new ReentrantLock();  // a ReentrantLock lock
    private Condition hasPrintTask;   // a condition object
    private boolean isOn;             // boolean variable describing if the
                                      // queue is on (accepting jobs)

    // TODO: Handle locking and conditions around the
    // enqueueing and dequeuing of documents
    // in this PrintQueue's document list (toPrint)
    // Note: See the BetterBestBank example in Bank.zip
    // or in zip folder 'Thread Example 6 - Bank Deadlock'
    // on Collab.
    // Bank.zip: http://tinyurl.com/cs2110bank

    /**
     * Constructor
     */
    public PrintQueue() {
        toPrint = new LinkedList<String>(); // create the list of documents
        isOn = true; // turn on the print queue
        hasPrintTask = documentChangeLock.newCondition(); // condition object associated with specific lock object
    }

    /**
     * Add the String parameter onto the end of the print queue.
     * 
     * @param s the string to be added
     */
    public void enqueue(String s) {
        documentChangeLock.lock();
        toPrint.add(s); // add to the list of documents
        hasPrintTask.signalAll();  // Unblock other threads waiting on the condition by "signalAll"
        documentChangeLock.unlock();
    }

    /**
     * Remove the head element off the queue and return it.
     * 
     * @return the head element
     * @throws InterruptedException
     */
    public String dequeue() throws InterruptedException {
        documentChangeLock.lock();

        try {
            while (toPrint.size() <= 0) { // If the size is less than 0, condition object calls "await"
                hasPrintTask.await(); // Another thread can now acquire the lock object
            }
            return toPrint.remove(0);   // return the first document

        } finally {
            documentChangeLock.unlock();
        }

    }

    /**
     * Turn off the print queue
     */
    public void turnOff() {

        isOn = false;

    }

    /**
     * To see whether the print queue accept jobs.
     * 
     * @return Returns true if the PrintQueue is still accepting jobs, false if it has been “turned off.”
     */
    public boolean isOn() {
        return isOn;
    }
}
