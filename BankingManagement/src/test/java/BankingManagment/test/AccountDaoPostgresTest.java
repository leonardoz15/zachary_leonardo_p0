/**
 * 
 */
package BankingManagment.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import BankingManagement.dao.AccountDaoPostgres;
import BankingManagement.pojos.Account;
import BankingManagement.util.ConnectionUtil;

/**
 * @author Zachary Leonardo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountDaoPostgresTest {
	
	public AccountDaoPostgres accountDao = new AccountDaoPostgres();
	
	@Mock
	private ConnectionUtil connUtil;
	
	@Mock
	private Connection connection;
	
	private Statement stmt;
	
	private Statement spy;
	
	private Connection realConnection;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		
		realConnection = new ConnectionUtil().createConnection();
		
		stmt = realConnection.createStatement();
		
		spy = Mockito.spy(stmt);
		
		when(connection.createStatement()).thenReturn(spy);
		when(connUtil.createConnection()).thenReturn(connection);
		
		accountDao.setConnUtil(connUtil);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		stmt.executeUpdate("delete from account where username = 'TestName' and password = 'Password'");
		
		realConnection.close();
		
	}

	@Test
	public void createAccountTest() throws SQLException {
		
		Account account = new Account("TestName", "Password", 1);
		
		accountDao.createAccount(account);
		
		String sql = "insert into account (username,password) values ('TestName' , 'Password')";
		
		verify(spy).executeUpdate(sql);
		
		ResultSet rs = stmt.executeQuery("select * from account where username = 'TestName' and password = 'Password'");
		
		assertTrue(rs.next());
		
	}

}
