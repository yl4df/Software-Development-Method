import java.util.Scanner;

public class OneDArrayActivity {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many values do you want in the array?");
		int x = keyboard.nextInt();
		int[] values = new int[x];
		for(int i = 0; i < x; i++){
			System.out.println("Enter the " + i + " value in the array");
			values[i] = keyboard.nextInt();
		}
		
		
		
		for(int j = 0; j < values.length; j++){
			System.out.print(values[j] + " ");
		}
		
		//Input your code here.
		boolean status = true;
		for(int j = 0; j+1 < values.length; j++) {
			if ( values[j+1] <= values[j] ) {
				status = false;
				break;
			}
		}
		
		if (status == true) {
		    System.out.println("");
	        System.out.println("The array is increasing!");
		}
		else {
			System.out.println("");
			System.out.println("The array is not increasing!");
		}
		keyboard.close();
}
}   
