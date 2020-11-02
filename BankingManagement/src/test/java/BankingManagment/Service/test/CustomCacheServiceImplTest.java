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

/**
 * @author Zachary Leonardo
 *
 */
public class CustomCacheServiceImplTest {
	
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
