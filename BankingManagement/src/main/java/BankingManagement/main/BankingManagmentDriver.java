/**
 * 
 */
package BankingManagement.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

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
	private static Logger log = Logger.getRootLogger();
	private static Scanner scan = new Scanner(System.in);
	private static BankingServiceImpl bankService = new BankingServiceImpl();
	private static AccountServiceImpl accountService = new AccountServiceImpl();
	private boolean loggedIn = false;
	private static Account account = new Account();
	private static String userInput;
	
	public static void main(String[] args) {
		
		
		BankingManagmentDriver driver = new BankingManagmentDriver();
		log.info("Program has started");
		
		while(!"0".equals(userInput)) {
			System.out.println("Welcome to the Bank Manager");
			System.out.println("Please choose one of the following");
			System.out.println("[1] login");
			System.out.println("[2] create a new account");
			System.out.println("[3] manage your account");
			System.out.println("[4] apply for a loan (not yet)");
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
				log.warn("Invalid input in main menu");
				break;
			}
		}
	}
	
	public void login() {
		loggedIn = false;
		log.info("Logging in");
		System.out.println("What is your name / username?");
		String name = scan.nextLine();
		System.out.println("What is your password?");
		String password = scan.nextLine();
		account = accountService.authenticate(name, password);
		try {
			if(!account.equals(null)) {
				System.out.println("Successfully logged in");
				loggedIn = true;
				log.info("Logged in sucessfully to " + account.toString());
				manageFunds();
			}
		} catch(Exception NullPointerException) {
			System.out.println("Please create a new account first");
			loggedIn = false;
		}
	}
	
	public void createNewAccount() {
		loggedIn = false;
		log.info("Creating new account");
		System.out.println("Please enter a new name / username");
		String name = scan.nextLine();
		System.out.println("Please enter a new password");
		String password = scan.nextLine();
		accountService.createAccount(name, password);
	}
	
	public void manageFunds() {
		if(loggedIn == false) {
			System.out.println("Please login first");
			login();
		}
		
		String input;
		do {
			System.out.println("Would you like to view, add, or remove funds? --- 0 to return to main menu.");
			input = scan.nextLine();
			
			switch(input) {
			case "view":
				viewFunds();
				break;
			case "add":
				addFunds();
				break;
			case "remove":
				removeFunds();
				break;
			case "0":
				System.out.println("Returning to main menu");
				break;
			default:
				System.out.println("Invalid input");
				log.warn("Invalid input in manage funds");
				break;
			}
		} while(!"0".equals(input));
	}
	
	public void viewFunds() {
		System.out.println("Current balance: " + bankService.retrieveBalance(account));
		manageFunds();
	}
	
	public void addFunds() {
		System.out.println("How much would you like to add?");
		int amount = scan.nextInt();
		bankService.deposit(account, amount);
		System.out.println("New balance: " + bankService.retrieveBalance(account));
	}
	
	public void removeFunds() {
		System.out.println("How much would you like to remove?");
		int amount = scan.nextInt();
		bankService.withdrawl(account, amount);
		System.out.println("New balance: " + bankService.retrieveBalance(account));
	}
	
	public void applyForLoan() {
		
	}
}
