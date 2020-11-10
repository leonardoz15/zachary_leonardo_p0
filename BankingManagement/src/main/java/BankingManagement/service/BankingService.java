package BankingManagement.service;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;

public interface BankingService {
	
	public Banking createBank(Banking bank);
	
	public void deposit(Banking bank, int amount);
	
	public void withdrawl(Banking bank, int amount);
	
	public double retrieveBalance(Banking bank);
}