package BankingManagment.Service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BankingManagement.pojos.Account;
import BankingManagement.pojos.Banking;
import BankingManagement.service.AccountServiceImpl;
import BankingManagement.service.CustomCacheServiceImpl;

public class AccountServiceImplTest {
	
	private static CustomCacheServiceImpl<Account> cacheService;
	private static AccountServiceImpl accountService; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cacheService = new CustomCacheServiceImpl<Account>();
		accountService = new AccountServiceImpl(cacheService);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateSimpleAccount() {
		String name = "Zach";
		String password = "password";
		accountService.createAccount(name, password);
		assertNotNull("Cache shouldn't be empty" , cacheService.retrieveAllItems());
	}
	
	@Test
	public void testAuthentication() {
		String name = "Zach";
		String password = "password";
		accountService.createAccount(name, password);
		assertNotNull("Authentication should return account", accountService.authenticate(name, password));
	}
	
	@Test
	public void testRemoveAccount() {
		String name = "Zach";
		String password = "password";
		Account testAccount = new Account(name,password,0);
		cacheService.addToCache(testAccount);
		accountService.removeAccount(name, password);
		assertNull("Cache should be empty",cacheService.retrieveItem(testAccount));
	}
}
