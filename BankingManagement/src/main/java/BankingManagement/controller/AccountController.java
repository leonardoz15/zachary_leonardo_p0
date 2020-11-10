package BankingManagement.controller;

import BankingManagement.dao.AccountDao;
import BankingManagement.dao.AccountDaoPostgres;
import BankingManagement.pojos.Account;
import BankingManagement.service.AccountService;
import BankingManagement.service.AccountServiceFullStack;
import io.javalin.http.Context;

public class AccountController {

		AccountService accountService = new AccountServiceFullStack();
		
		AccountDao accountDao = new AccountDaoPostgres();
		
		Account account;
		
		public void createAccount(Context ctx) {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			account = new Account(username,password);
			
			ctx.html("Created account: " + accountService.createAccount(account).toString());
			
		}
		
		public void deleteAccount(Context ctx) {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			account.setName(username);
			account.setPassword(password);
			accountService.removeAccount(account);
			ctx.html("Removed account with ID: " + account.getId());
		}

}
