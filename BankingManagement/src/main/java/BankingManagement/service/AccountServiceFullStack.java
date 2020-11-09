/**
 * 
 */
package BankingManagement.service;

import BankingManagement.dao.AccountDao;
import BankingManagement.dao.AccountDaoPostgres;
import BankingManagement.pojos.Account;

/**
 * @author Zachary Leonardo
 *
 */
public class AccountServiceFullStack implements AccountService {
	
	AccountDao accountDao = new AccountDaoPostgres();

	@Override
	public boolean authenticate(Account account) {
		
		return false;
	}

	@Override
	public Account createAccount(Account account) {
		accountDao.createAccount(account);
		return account;
	}

	@Override
	public void updateAccount(int accountId, Account account) {
		accountDao.updateAccount(accountId, account);
	}

	@Override
	public void removeAccount(Account account) {
		accountDao.deleteAccount(account);	
	}



}
