package lab1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Lab1Scanner {

	public static void main(String[] args) {
		
		/*Scanner theInput = new Scanner(System.in);
		System.out.println("Enter your five number: ");
		while( theInput.hasNextInt()) {
		
			int i1 = theInput.nextInt();
			int i2 = theInput.nextInt();
			int i3 = theInput.nextInt();
			int i4 = theInput.nextInt();
			int i5 = theInput.nextInt();
			int avg = (i1 + i2 +i3 + i4 + i5)/5;
			System.out.println("The average of "+i1+", "+i2+", "+i3+", "+i4+" and "+i5+" is "+avg+".");
		}*/
		File theFile = new File("data1.txt");
		Scanner fileScnr;
		try {
			fileScnr = new Scanner(theFile);
			while (fileScnr.hasNext()) {
				String str = fileScnr.nextLine();
				System.out.println(str);
			}
			fileScnr.close();
			System.out.println(theFile.length());
		    System.out.println(theFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}