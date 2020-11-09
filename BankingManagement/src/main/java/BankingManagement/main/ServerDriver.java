package BankingManagement.main;

import BankingManagement.controller.AccountController;
import io.javalin.Javalin;

public class ServerDriver {
	
	private static AccountController accountController = new AccountController();
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090);
		
	}

}
