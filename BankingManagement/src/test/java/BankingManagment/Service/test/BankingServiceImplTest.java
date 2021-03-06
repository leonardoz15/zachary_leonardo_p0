/**
 * 
 */
package BankingManagment.Service.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;
import BankingManagement.service.BankingServiceImpl;
import BankingManagement.service.CustomCacheServiceImpl;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingServiceImplTest {
	
	private static CustomCacheServiceImpl<Banking> cacheService;
	private BankingServiceImpl bankingService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cacheService = new CustomCacheServiceImpl<Banking>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Banking bank1 = new Banking(new Account("Zach","Password",0), 200);
		Banking bank2 = new Banking(new Account("Jake","word",0), 200);
		Banking bank3 = new Banking(new Account(null,null,0), 0);
		
		cacheService.addToCache(bank1);
		cacheService.addToCache(bank2);
		cacheService.addToCache(bank3);
		
		bankingService = new BankingServiceImpl(cacheService);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cacheService.emptyCache();
	}
	
	@Test
	public void retrieveBalanceFromAccountTest() {
		int balanceToTest = 100;
		Account accountToTest = new Account("Jake","word",0);
		cacheService.addToCache(new Banking(accountToTest, balanceToTest));
		assertEquals("Account balance should be 100", 100, bankingService.retrieveBalance(accountToTest),0);
	}
	@Test
	public void depostToAccountTest() {
		int amountToAdd = 100;
		Account accountToTest = new Account("Zach","Password",0);
		cacheService.addToCache(new Banking(accountToTest, 0));
		bankingService.deposit(accountToTest, amountToAdd);
		assertEquals("Account balance should be 100", 100, bankingService.retrieveBalance(accountToTest),0);
	}
	
	@Test
	public void withdrawlFromAccountTest() {
		int amountToWithdrawl = 100;
		Account accountToTest = new Account("Jake","word",0);
		cacheService.addToCache(new Banking(accountToTest, 200));
		bankingService.withdrawl(accountToTest, amountToWithdrawl);
		assertEquals("Account balance should be 100", 100, bankingService.retrieveBalance(accountToTest),0);
		
	}

}
