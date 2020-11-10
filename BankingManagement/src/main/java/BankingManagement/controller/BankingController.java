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
		}		
	}

}
