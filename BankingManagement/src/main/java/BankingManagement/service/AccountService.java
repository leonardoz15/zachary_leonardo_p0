package BankingManagement.service;

import BankingManagement.pojos.Account;

public interface AccountService {

	public boolean authenticate(Account account);

	public Account createAccount(Account account);
	
	public void updateAccount(int accountId, Account account);
	
	public void removeAccount(Account account);
}