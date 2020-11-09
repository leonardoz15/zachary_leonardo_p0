/**
 * 
 */
package BankingManagment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import BankingManagement.pojos.Account;
import BankingManagement.util.ConnectionUtil;

/**
 * @author Zachary Leonardo
 *
 */
public class AccountDaoPostgres implements AccountDao {
	
	private Statement statement;
	
	private ConnectionUtil connUtil = new ConnectionUtil();

	/**
	 * @param connUtil the connUtil to set
	 */
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createAccount(Account account) {
		
		String sql = "insert into account (username,password) values (? , ?)";
		
		try(Connection conn = connUtil.createConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getPassword());
			
			Savepoint s1 = conn.setSavepoint();
			int rowsEffected = pstmt.executeUpdate();
			
			if (rowsEffected != 1) {
				conn.rollback(s1);
			} else {
				conn.commit();
			}
			
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account readAccout(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account readAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(int acountId, Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub

	}

}
