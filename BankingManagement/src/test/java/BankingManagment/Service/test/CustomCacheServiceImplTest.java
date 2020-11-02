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
import BankingManagement.service.CustomCacheServiceImpl;

/**
 * @author Zachary Leonardo
 *
 */
public class CustomCacheServiceImplTest {
	
	private CustomCacheServiceImpl<Account> cacheService;
	private static Set<Account> testCache;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testCache = new HashSet<>();
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
		Account account1 = new Account("Zach","Password",0);
		Account account2 = new Account("Jake","another word",1);
		Account account3 = new Account(null,null,0);
		
		testCache.add(account1);
		testCache.add(account2);
		testCache.add(account3);
		
		cacheService = new CustomCacheServiceImpl<Account>(testCache);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testCache.clear();
	}

	@Test
	public void addSimpleAccountToCacheTest() {
		
		Account accountToAdd = new Account("John Doe", "cOoL PasSwoRd", 0);
		cacheService.addToCache(accountToAdd);
		assertEquals("Account " + accountToAdd.toString() + " should be in cache", true, testCache.contains(accountToAdd));
	}
	
	@Test
	public void removeSimpleAccountFromCacheTest() {
		
		Account accountToRemove = new Account("Jake", "another word",1);
		cacheService.removeFromCache(accountToRemove);
		assertEquals("Account "+ accountToRemove.toString() + " shouldn't be in the cache", false, testCache.contains(accountToRemove));
	}
	
	@Test
	public void retrieveSimpleAccountFromCacheTest() {
		Account accountToRetrieve = new Account("Zach","Password",0);
		assertEquals("Account " + accountToRetrieve.toString() + " should be retrieved", accountToRetrieve, cacheService.retrieveItem(accountToRetrieve));
	}
	
	@Test
	public void retrieveSimpleAccountNotInCacheTest() {
		Account accountToRetrieve = new Account("John","Password",0);
		assertFalse("Account " + accountToRetrieve.toString() + " shouldn't be retrieved", testCache.contains(accountToRetrieve));
	}
	

}
