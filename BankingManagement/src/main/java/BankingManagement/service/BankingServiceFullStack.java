/**
 * 
 */
package BankingManagement.service;

import BankingManagement.dao.BankingDao;
import BankingManagement.dao.BankingDaoPostgres;
import BankingManagement.pojos.Banking;
import org.apache.log4j.Logger;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingServiceFullStack implements BankingService {

	private BankingDao bankingDao = new BankingDaoPostgres();
	
	private static Logger log = Logger.getRootLogger();

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
			log.warn("Attempted to withdrawl more than current balance. Current balance is " + balance + " but withdrawl amount is " + amount);
		}
	}

	@Override
	public double retrieveBalance(Banking bank) {
		
		bank = bankingDao.readBanking(bank);
		return bank.getCurrentBalance();
	}
	
	
}
