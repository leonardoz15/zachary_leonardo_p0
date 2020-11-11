package BankingManagement.main;

import BankingManagement.controller.AccountController;
import BankingManagement.controller.BankingController;
import io.javalin.Javalin;

public class ServerDriver {
	
	private static AccountController accountController = new AccountController();
	
	private static BankingController bankingController = new BankingController();
	
	public static final String ACCOUNT_PATH = "/BM/account";
	
	public static final String BANKING_PATH = "/BM/banking";
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090);
		app.get("/BM", ctx -> ctx.html("Welcome to the Bank Management App"));
		app.post(ACCOUNT_PATH, ctx -> accountController.createAccount(ctx));
		app.delete(ACCOUNT_PATH, ctx -> accountController.deleteAccount(ctx));
		app.post(BANKING_PATH, ctx -> bankingController.createBanking(ctx));
		app.patch(BANKING_PATH, ctx -> bankingController.depositFunds(ctx));
		app.patch(BANKING_PATH + "/withdrawl", ctx -> bankingController.withdrawlFunds(ctx));
		
	}

}
