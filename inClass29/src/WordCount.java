import java.util.concurrent.locks.ReentrantLock;

/**
   Counts how many words in a file.
 */
public class WordCount extends Thread
{
    public static void main(String argv[])
    {
        WordCountRunnable.threadCount = 0;
        WordCountRunnable.combinedWordCount = 0;
        // ** Can do the following two lines here OR in the constructor of WordCountRunnable ** 
        //WordCountRunnable.threadCountLock = new ReentrantLock();
        //WordCountRunnable.combinedWordCountLock = new ReentrantLock();
        argv = new String[4];
        argv[0] = "BramStoker-Dracula.txt";
        argv[1] = "mary1.txt";
        argv[2] = "shakespeare-hamlet.txt";
        argv[3] = "shakespeare-macbeth.txt";

        for (int i = 0; i < argv.length; i++) {
            WordCountRunnable wcr = new WordCountRunnable(argv[i]);
            Thread t = new Thread(wcr);
            t.start();
        }
    }
}