package BankingManagement.main;

import BankingManagement.controller.AccountController;
import BankingManagement.controller.BankingController;
import io.javalin.Javalin;

public class ServerDriver {
	
	private static AccountController accountController = new AccountController();
	
	private static BankingController bankingController = new BankingController();
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090);
		app.get("/BM", ctx -> ctx.html("Welcome to the Bank Management App"));
		app.post("/BM/createAccount", ctx -> accountController.createAccount(ctx));
		app.delete("/BM/deleteAccount", ctx -> accountController.deleteAccount(ctx));
		app.post("/BM/createBanking", ctx -> bankingController.createBanking(ctx));
		
	}

}
