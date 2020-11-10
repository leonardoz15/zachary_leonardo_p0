/**
 * 
 */
package BankingManagement.service;

import BankingManagement.dao.BankingDao;
import BankingManagement.dao.BankingDaoPostgres;
import BankingManagement.pojos.Account;
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
	public void deposit(Banking bank, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawl(Banking bank, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double retrieveBalance(Banking bank) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
