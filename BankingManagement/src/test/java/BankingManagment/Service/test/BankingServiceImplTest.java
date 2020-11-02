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
import BankingManagement.service.CustomCacheServiceImpl;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingServiceImplTest {
	
	private CustomCacheServiceImpl<Banking> cacheService;
	private static Set<Banking> testCache;
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
		Banking bank1 = new Banking(new Account("Zach","Password",0), 200);
		Banking bank2 = new Banking(new Account("Jake","word",0), 100);
		Banking bank3 = new Banking(new Account(null,null,0), 0);
		
		testCache.add(bank1);
		testCache.add(bank2);
		testCache.add(bank3);
		
		cacheService = new CustomCacheServiceImpl<Banking>(testCache);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testCache.clear();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
