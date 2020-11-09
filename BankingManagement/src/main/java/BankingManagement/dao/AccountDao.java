/**
 * 
 */
package BankingManagement.dao;

import BankingManagement.pojos.Account;

/**
 * @author Zachary Leonardo
 *
 */
public interface AccountDao {
	
	public void createAccount(Account account);
	
	public Account readAccount(int accountId);
	
	public Account readAllAccounts();
	
	public Account updateAccount(int acountId, Account account);
	
	public void deleteAccount(Account account);
	
}
