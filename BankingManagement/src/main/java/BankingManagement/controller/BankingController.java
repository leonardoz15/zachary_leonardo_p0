/**
 * 
 */
package BankingManagement.controller;

import BankingManagement.service.AccountService;
import BankingManagement.service.AccountServiceFullStack;
import BankingManagement.service.BankingService;
import BankingManagement.service.BankingServiceFullStack;
import io.javalin.http.Context;
import BankingManagement.controller.AccountController;
import BankingManagement.pojos.Banking;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingController {
	
	private BankingService bankingService = new BankingServiceFullStack();
	
	private AccountService accountService = new AccountServiceFullStack();
	
	public Banking bank;
	
	public void createBanking(Context ctx) {
		
		double currentBalance = Double.parseDouble(ctx.formParam("balance"));
		int creditScore = Integer.parseInt(ctx.formParam("creditScore"));
		
		if (accountService.authenticate(AccountController.account)) {
			
			bank = new Banking(AccountController.account, currentBalance, creditScore);
			
			ctx.html("Created banking: " + bankingService.createBank(bank).toString());
			
		} else {
			
			ctx.html("Error authenticating account");
			ctx.status(500);
		}		
	}
	
	public void depositFunds(Context ctx) {
		
		double deposit = Double.parseDouble(ctx.formParam("deposit"));
		
		if (accountService.authenticate(AccountController.account)) {
			
			bankingService.deposit(bank, deposit);
			
			ctx.html("Successfully deposited " + deposit + "\nNew balance : " + bankingService.retrieveBalance(bank));
			
		} else {
			
			ctx.html("Error authenticating account");
			ctx.status(500);
		}	
	}
	
	public void withdrawlFunds(Context ctx) {
		
		double withdrawl = Double.parseDouble(ctx.formParam("withdrawl"));
		
		if (accountService.authenticate(AccountController.account)) {
			
			bankingService.withdrawl(bank, withdrawl);
			
			ctx.html("Successfully withdrew " + withdrawl + "\nNew balance : " + bankingService.retrieveBalance(bank));
			
		} else {
			
			ctx.html("Error authenticating account");
			ctx.status(500);
		}	
	}

}
