
public class Palindrome {
    public static boolean testForPalindrome(String s) {
        System.out.println(s);

        if (s.length() == 1 || s.length()==0) {
            return true;
        }
        
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                String newString = s.substring(1, s.length() - 1);
                 return testForPalindrome(newString);
                
            } 
          return false;  

        }
    
    public static int fibonacci_1(int n) {
        if (n < 2)
           return 1;
        return fibonacci_1(n-1) + fibonacci_1(n-2);
     }
    
    public static int mystery(int n, int m) { 
        if (n == 0) { return 0; } 
        if (n == 1) { return m; }  
        return m + mystery(n - 1, m); 
    }

    public static void main(String Arg[]) {
        System.out.println(testForPalindrome("weabaew"));
        System.out.println(fibonacci_1(5));
        System.out.println(mystery(3,6));
    }
}
