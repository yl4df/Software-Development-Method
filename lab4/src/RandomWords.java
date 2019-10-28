//Lab 4
//RandomWords.java

import java.util.Random;

public class RandomWords {

	public static void main(String[] args) {
	    String[] words = generateRandomWords(500);
	    String[] hashTable = new String[500];
	    
	    int collision=0;
	    
	    for(int j =0; j<words.length;j++) {
	        int run = hashFunction(words[j]);
	        
	        while(hashTable[run]!=null) {
	            run++;
	            collision++;
	            if(run>=500) {
	                run = 0;
	            }
	        }
	        hashTable[run]=words[j];
	        
	    }
	    
	    System.out.println(collision);
     
	}

	//A static method that takes in the number or words you would like in your array of 
	//random words.  Each word is between 3 and 10 characters in length and contain only
	//lower case letters.  
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // Words of length 3 through 10. (Because 1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
	
	public static int hashFunction(String s) {
	    int num = 0;
	    for( int i =0; i<s.length();i++) {
	        num += s.charAt(i);
	    }
	    return num%500;
	}
}
