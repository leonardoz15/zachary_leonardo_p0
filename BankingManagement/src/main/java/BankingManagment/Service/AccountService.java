package BankingManagment.Service;

import BankingManagment.pojos.Account;

public class AccountService {

	public AccountService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean login(Account account) {
		
		
		return true;
		
	}
	
	public Account createAccount(String name, String password) {
		
		int id = (int)Math.random()* 100;
		Account account = new Account(name, password,id);
		return account;
	}
	
}
