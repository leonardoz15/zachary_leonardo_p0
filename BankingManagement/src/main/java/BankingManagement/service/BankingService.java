package BankingManagement.service;

import BankingManagement.pojos.Account;

public interface BankingService {
	
	public void createBank(Account account);
	
	public void deposit(Account account, int amount);
	
	public void withdrawl(Account account, int amount);
	
	public double retrieveBalance(Account account);
}