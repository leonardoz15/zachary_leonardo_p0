/**
 * 
 */
package BankingManagement.main;

import java.util.Scanner;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingManagmentDriver {
	/**
	 * @param args
	 */
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String userInput;
		
		do {
			System.out.println("Welcome to the Bank Manager");
			System.out.println("Please choose one of the following");
			System.out.println("[1] login");
			System.out.println("[2] create a new account");
			System.out.println("[3] view credit information");
			System.out.println("[4] apply for a loan");
			System.out.println("[0] exit");
			
			userInput = scan.nextLine();
			
			switch(userInput) {
			
			case "1":

				System.out.println("What is your name / username?");
				String name = scan.nextLine();
				System.out.println("What is your password?");
				String password = scan.nextLine();
				break;
			case "2":
				break;
			case "3":
				break;
			case "0":
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid input");
			
		} while(!"0".equals(userInput));

	}

}
