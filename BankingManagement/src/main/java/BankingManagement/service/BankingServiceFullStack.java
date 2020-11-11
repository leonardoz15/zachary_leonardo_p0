/**
 * 
 */
package BankingManagement.service;

import BankingManagement.dao.BankingDao;
import BankingManagement.dao.BankingDaoPostgres;
import BankingManagement.pojos.Banking;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingServiceFullStack implements BankingService {

	private BankingDao bankingDao = new BankingDaoPostgres();

	@Override
	public Banking createBank(Banking bank) {
		
		bankingDao.createBanking(bank);
		return bank;
	}

	@Override
	public void deposit(Banking bank, double amount) {
		
		double balance = retrieveBalance(bank);
		double newBalance = balance + amount;
		
		bankingDao.updateBanking((int)newBalance, bank);
		
	}

	@Override
	public void withdrawl(Banking bank, double amount) {
		
		double balance = retrieveBalance(bank);
		if (balance >= amount) {
			double newBalance = balance - amount;
			bankingDao.updateBanking((int)newBalance, bank);
		}
		else {
			//log
		}
	}

	@Override
	public double retrieveBalance(Banking bank) {
		
		bank = bankingDao.readBanking(bank);
		return bank.getCurrentBalance();
	}
	
	
}
