package BankingManagment.Service;

import BankingManagment.pojos.Account;

public interface AccountService {

	public Account authenticate(String name, String password);

	public void createAccount(String name, String password);
	
	public void removeAccount(String name, String password);
}