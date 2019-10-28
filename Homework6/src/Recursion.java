/**
 * Homework 6 Implement the following methods on recursion as defined in the homework 6 document.
 * 
 * @author yourid yl4df
 * Sources: Big Java Book, Lecture Notes
 */
public class Recursion {

    /**
     * To test whether the string is a palindrome
     * 
     * @param s the String to be tested
     * @return returns true if the string is a palindrome and false otherwise.
     */
    public static boolean palindrome(String s) {

        if (s.length() == 1) {   // Base Case 1
            return true;
        }
        if (s.length() == 0) {    // Base Case 2
            return true;
        } else {       // recursive step
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return palindrome(s.substring(1, s.length() - 1));
            }
            return false;
        }
    }

    /**
     * Takes in a string and returns the reverse of the string.
     * 
     * @param s the String to be reversed
     * @return returns the reverse of the string.
     */
    public static String reverseString(String s) {

        if (s.length() == 1) {     // Base Case 1
            return s;
        } else {       // recursive step
            return reverseString(s.substring(1)) + s.charAt(0);
        }

    }

    /**
     * To calculate the total number of handshakes for the given number of people.
     * 
     * @param n the number of people
     * @return the total number of handshakes for n people.
     */
    public static int handshakes(int n) {

        if (n == 0) {   // Base Case 1
            return 0;
        }
        if (n == 1) {   // Base Case 2
            return 0;
        } else {     // recursive step
            return handshakes(n - 1) + n - 1;

        }

    }

    /**
     * Solves Ackermann’s function
     * 
     * @param m first parameter
     * @param n second parameter
     * @return the result given by Ackermann’s function
     */
    public static long ackermann(long m, long n) {
        if (m == 0) {  //Case 1
            return n + 1;
        } else if (m > 0 && n == 0) {  //Case 2
            return ackermann(m - 1, 1);
        } else {   //Case 3
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

    public static void main(String[] args) {

        // Tests for palindrome
        System.out.println(palindrome("acbca")); // expected output = true = actual output
        System.out.println(palindrome("aebca")); // expected output = false = actual output

        // Test for reverseString
        System.out.println(reverseString("abcde"));   // expected output = "edcba" = actual output
        System.out.println(reverseString("I love sleeping"));    // expected output = "gnipeels evol I" = actual output

        // Test for handshakes
        System.out.println(handshakes(7));    // expected output = 21 = actual output
        System.out.println(handshakes(4));    // expected output = 6 = actual output

        // Test for ackermann
        System.out.println(ackermann(1, 0));   // expected output = 2 = actual output
        System.out.println(ackermann(3, 3));   // expected output = 61 = actual output

    }
}
