/**
 * 
 */
package BankingManagement.service;

import BankingManagement.pojos.Account;

/**
 * @author Zachary Leonardo
 *
 */
public interface LoanService {
	
	public void createLoan();
	
	public void returnAllLoans();
	
	public void applyForLoan(Account account);
}
