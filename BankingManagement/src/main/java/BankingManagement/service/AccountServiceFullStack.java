/**
 * 
 */
package BankingManagement.service;

import BankingManagement.dao.AccountDao;
import BankingManagement.dao.AccountDaoPostgres;
import BankingManagement.pojos.Account;
import org.apache.log4j.Logger;

/**
 * @author Zachary Leonardo
 *
 */
public class AccountServiceFullStack implements AccountService {
	
	private AccountDao accountDao = new AccountDaoPostgres();
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public boolean authenticate(Account account) {
		Account returned =  new Account();
		if (account != null) {
			returned = accountDao.readAccount(account.getId());
			if(returned.getName().equals(account.getName()) & returned.getPassword().equals(account.getPassword())) {
				return true;
			} else {
				log.warn("Account doesnt match account in database " + returned.toString());
				return false;
			}
		} else {
			log.warn("Account doesn't exist in database");
			return false;
		}
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
