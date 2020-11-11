package BankingManagement.controller;

import BankingManagement.dao.AccountDao;
import BankingManagement.dao.AccountDaoPostgres;
import org.apache.log4j.Logger;
import BankingManagement.pojos.Account;
import BankingManagement.service.AccountService;
import BankingManagement.service.AccountServiceFullStack;
import io.javalin.http.Context;

public class AccountController {

		private AccountService accountService = new AccountServiceFullStack();
		
		public static Account account;
		
		private static Logger log = Logger.getRootLogger();
		
		public void createAccount(Context ctx) {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			account = new Account(username,password);
			
			ctx.html("Created account: " + accountService.createAccount(account).toString());
			
			log.info("Created account: " + account.toString());
			
		}
		
		public void deleteAccount(Context ctx) {
			
			String username = ctx.formParam("username");
			String password = ctx.formParam("password");
			
			account.setName(username);
			account.setPassword(password);
			
			accountService.removeAccount(account);
			
			ctx.html("Removed account with ID: " + account.getId());
			
			log.info("Removed account: " + account.toString());
			
		}

}
