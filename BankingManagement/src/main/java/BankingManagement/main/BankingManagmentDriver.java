/**
 * 
 */
package BankingManagement.main;

import java.util.Scanner;

import BankingManagement.pojos.Account;
import BankingManagement.service.AccountServiceImpl;
import BankingManagement.service.BankingServiceImpl;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingManagmentDriver {
	/**
	 * @param args
	 */
	
	private static Scanner scan = new Scanner(System.in);
	BankingServiceImpl bankService = new BankingServiceImpl();
	AccountServiceImpl accountService = new AccountServiceImpl();
	boolean loggedIn = false;
	Account account = new Account();
	
	public static void main(String[] args) {
		
		String userInput;
		BankingManagmentDriver driver = new BankingManagmentDriver();
		
		do {
			System.out.println("Welcome to the Bank Manager");
			System.out.println("Please choose one of the following");
			System.out.println("[1] login");
			System.out.println("[2] create a new account");
			System.out.println("[3] manage your account");
			System.out.println("[4] apply for a loan");
			System.out.println("[0] exit");
			
			userInput = scan.nextLine();
			
			switch(userInput) {
			
			case "1":
				driver.login();
				break;
			case "2":
				driver.createNewAccount();
				break;
			case "3":
				driver.manageFunds();
				break;
			case "4":
				driver.applyForLoan();
				break;
			case "0":
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid input");
			}
			
		} while(!"0".equals(userInput));

	}
	
	public void login() {
		System.out.println("What is your name / username?");
		String name = scan.nextLine();
		System.out.println("What is your password?");
		String password = scan.nextLine();
		account = accountService.authenticate(name, password);
		if(account != null) {
			System.out.println("Successfully logged in to account " + account.toString());
			loggedIn = true;
		}
	}
	
	public void createNewAccount() {
		System.out.println("Please enter a new name / username");
		String name = scan.nextLine();
		System.out.println("Please enter a new password");
		String password = scan.nextLine();
		accountService.createAccount(name, password);
	}
	
	public void manageFunds() {
		if(loggedIn = true) {
			
		}
		else {
			System.out.println("Please login first");
			login();
		}
	}
	
	public void applyForLoan() {
		
	}
}
