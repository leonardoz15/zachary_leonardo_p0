/**
 * 
 */
package BankingManagement.dao;

import java.util.ArrayList;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;

/**
 * @author Zachary Leonardo
 *
 */
public interface BankingDao {
	
	public void createBanking(Banking bank);
	
	public Banking readBanking(Banking bank);
	
	public ArrayList<Banking> readAllBankings();
	
	public Banking updateBanking(int amount, Banking bank);
	
	public void deleteBanking(Banking bank);

}
